package net.aurore.lolservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class RestService {
	
	private static final int MAX_REQUEST_PER_SECOUND = 20;
	private static final int SECOUND = 1000;
	private static final int MAX_REQUEST_EVERY_TWO_MINUTES = 100;
	private static final int TWO_MINUTES = 120000;
	
	private static final String ORIGIN_KEY = "Origin";
	private static final String ORIGIN_VALUE = null;
	private static final String CHARSET_KEY = "Accept-Charset";
	private static final String CHARSET_VALUE = "application/x-www-form-urlencoded; charset=UTF-8";
	private static final String TOKEN_KEY = "X-Riot-Token";
	private static final String TOKEN_VALUE = "RGAPI-dded2bd4-87b1-4410-a4b3-51dc493d2a31";
	private static final String LANGUAGE_KEY = "Accept-Language";
	private static final String LANGUAGE_VALUE = "fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3";
	private static final String USERAGENT_KEY = "User-Agent";
	private static final String USERAGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0";
	
	private static final RiotServiceQueue QUEUE = new RiotServiceQueue(SECOUND, MAX_REQUEST_PER_SECOUND, TWO_MINUTES, MAX_REQUEST_EVERY_TWO_MINUTES);
	
	synchronized public String doRequest(String url) throws Exception{
		
		long toWait = QUEUE.queue();
		
		System.out.println(toWait);
		Thread.sleep(toWait);
		
		URL obj = new URL(url);
		HttpURLConnection conec = (HttpURLConnection) obj.openConnection();
		
		conec.setRequestMethod("GET");
		
		conec.setRequestProperty(ORIGIN_KEY, ORIGIN_VALUE);
		conec.setRequestProperty(CHARSET_KEY, CHARSET_VALUE);
		conec.setRequestProperty(TOKEN_KEY, TOKEN_VALUE);
		conec.setRequestProperty(LANGUAGE_KEY,LANGUAGE_VALUE);
		conec.setRequestProperty(USERAGENT_KEY, USERAGENT_VALUE);
		
		int responseCode = conec.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(conec.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		System.out.println("Response Body: " + response.toString());
		
		return response.toString();
	}
	
}
