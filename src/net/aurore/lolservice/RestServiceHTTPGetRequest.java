package net.aurore.lolservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestServiceHTTPGetRequest{
	
	private static final String ORIGIN_KEY = "Origin";
	private static final String ORIGIN_VALUE = null;
	private static final String CHARSET_KEY = "Accept-Charset";
	private static final String CHARSET_VALUE = "application/x-www-form-urlencoded; charset=UTF-8";
	private static final String TOKEN_KEY = "X-Riot-Token";
	private static final String TOKEN_VALUE = "RGAPI-6f156ef0-ef3d-4af1-ab53-1bb9d20539aa";
	private static final String LANGUAGE_KEY = "Accept-Language";
	private static final String LANGUAGE_VALUE = "fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3";
	private static final String USERAGENT_KEY = "User-Agent";
	private static final String USERAGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0";

	private final RestServiceRequest request;
	
	private final RestService service;
	
	public RestServiceHTTPGetRequest(RestServiceRequest request,RestService service){
		this.request = request;
		this.service = service;
	}
	
	
	public RestServiceResponse execute() throws IOException, RestServiceException{
		String url = request.getURL();
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
				
				return new RestServiceResponse(responseCode,response.toString(),request,service);
				
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

}
