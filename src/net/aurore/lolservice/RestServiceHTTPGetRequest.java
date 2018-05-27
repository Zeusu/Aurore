package net.aurore.lolservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.aurore.util.ConfigManager;

public class RestServiceHTTPGetRequest{
	
	private static final String ORIGIN_KEY = "Origin";
	private static final String CHARSET_KEY = "Accept-Charset";
	private static final String TOKEN_KEY = "X-Riot-Token";
	private static final String LANGUAGE_KEY = "Accept-Language";
	private static final String USERAGENT_KEY = "User-Agent";

	private final RestServiceRequest request;
	
	private final RestService service;
	
	public RestServiceHTTPGetRequest(RestServiceRequest request,RestService service){
		this.request = request;
		this.service = service;
	}
	
	
	public RestServiceResponse execute() throws IOException, RestServiceException{
		LoLServiceConfig c = (LoLServiceConfig) ConfigManager.getConfig(LoLServiceConfig.KEY);
		String url = request.getURL();
		URL obj = new URL(url);
		HttpURLConnection conec = (HttpURLConnection) obj.openConnection();
		conec.setRequestMethod("GET");
			
		conec.setRequestProperty(ORIGIN_KEY, c.getOrigin());
		conec.setRequestProperty(CHARSET_KEY, c.getCharset());
		conec.setRequestProperty(TOKEN_KEY, c.getToken());
		conec.setRequestProperty(LANGUAGE_KEY, c.getLanguage());
		conec.setRequestProperty(USERAGENT_KEY, c.getUseragent());
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
