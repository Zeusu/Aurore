package net.aurore.lolservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import net.aurore.entities.Context;
import net.aurore.util.ThreadPoolManager;



public class RestService{
	
	
	
	
	
	private static final int MAX_REQUEST_PER_SECOUND = 20;
	private static final int SECOUND = 1000;
	private static final int MAX_REQUEST_EVERY_TWO_MINUTES = 100;
	private static final int TWO_MINUTES = 120000;
	
	private static final String ORIGIN_KEY = "Origin";
	private static final String ORIGIN_VALUE = null;
	private static final String CHARSET_KEY = "Accept-Charset";
	private static final String CHARSET_VALUE = "application/x-www-form-urlencoded; charset=UTF-8";
	private static final String TOKEN_KEY = "X-Riot-Token";
	private static final String TOKEN_VALUE = "RGAPI-32321af1-93d0-446a-9fcc-0c46e415ec5f";
	private static final String LANGUAGE_KEY = "Accept-Language";
	private static final String LANGUAGE_VALUE = "fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3";
	private static final String USERAGENT_KEY = "User-Agent";
	private static final String USERAGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0";
	
	
	
	private static final ThreadPoolExecutor POOL = ThreadPoolManager.initiatePool(3, 3, 1, TimeUnit.MINUTES);
	
	private static final RestServiceQueue QUEUE = new RestServiceQueue(SECOUND, MAX_REQUEST_PER_SECOUND, TWO_MINUTES, MAX_REQUEST_EVERY_TWO_MINUTES);
	
	private final RestServiceControllerThread CONTROLLER;
	
	public RestService(){
		CONTROLLER = new RestServiceControllerThread(this);
		ThreadPoolManager.addSingleThread(CONTROLLER);
		CONTROLLER.start();
	}
	
	public long queue(){
		return QUEUE.queue();
	}
	
	synchronized public void doRequest() throws Exception{
		RestServiceRequest req = QUEUE.getToTreatRequest();
		if(req == null) return;
		RestServiceHTTPGetRequest httpRequest = new RestServiceHTTPGetRequest(QUEUE.getToTreatRequest().getURL(),this);
		POOL.submit(new Runnable(){
			@Override
			public void run() {
				RestServiceResponse r = null;
				try {
					r = httpRequest.execute();
				} catch (RestServiceException | IOException e) {
					e.printStackTrace();
				}
				if(r != null && r.getResponseCode() == 200){
					AuroreLoLResponseHandler.pushResponseTo(req.getKey(), req.getContext(), r, req.getCls());
				}
			}
		});
		req.validated();
	}
	
	synchronized public void addToQueue(String url,Context<?> c, String key,Class<?> cls){
		QUEUE.addToQueue(url,c,key,cls);
	}
	
	synchronized public RestServiceResponse doRequest(String url) throws RestServiceException, IOException{
		
		/*long toWait = QUEUE.queue();
		
		try {
			Thread.sleep(toWait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		URL obj = new URL(url);
		HttpURLConnection conec = (HttpURLConnection) obj.openConnection();
			
		conec.setRequestMethod("GET");
			
		conec.setRequestProperty(ORIGIN_KEY, ORIGIN_VALUE);
		conec.setRequestProperty(CHARSET_KEY, CHARSET_VALUE);
		conec.setRequestProperty(TOKEN_KEY, TOKEN_VALUE);
		conec.setRequestProperty(LANGUAGE_KEY,LANGUAGE_VALUE);
		conec.setRequestProperty(USERAGENT_KEY, USERAGENT_VALUE);

		StringBuffer response = new StringBuffer();
		int responseCode = conec.getResponseCode();
		if(responseCode == 200){
			try{
				System.out.println("Sending 'GET' request to URL : " + url);
				System.out.println("Response Code : " + responseCode);
				BufferedReader in = new BufferedReader(
				        new InputStreamReader(conec.getInputStream()));
				String inputLine;
				
	
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				
				System.out.println("Response Body: " + response.toString());
				
				return new RestServiceResponse(responseCode,response.toString(),url,this);
				
			}catch(IOException e){
				e.printStackTrace();
				return null;
			}
		}
		else{
			System.out.println(url);
			throw new RestServiceException(responseCode);
		}
	}

	public boolean queueEmpty() {	
		return QUEUE.isEmpty();
	}
	
}
