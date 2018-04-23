package net.aurore.lolservice;

import net.aurore.entities.Context;
import net.aurore.lolservice.entities.AuroreLoLEntity;

public class RestServiceResponse {

	private int responseCode;
	
	private String responseText;
	
	private RestServiceRequest request;
	
	private RestService service;
	
	private AuroreLoLEntity responseEntity = null;
	
	
	RestServiceResponse(int code, String text, RestServiceRequest request, RestService service){
		responseCode = code;
		this.request = request;
		this.service = service;
		if(code == 200){
			responseText = text;
			responseEntity = request.deserializeRequestObject(responseText);
		}else if(code == 404){
			responseText = "404 not found";
		}else if(code == 403){
			responseText = "403 Rejected";
		}else if(code >= 400 && code < 500){
			responseText = "Client error";
		}else if(code >= 500 && code < 600){
			responseText = "Serveur error";
		}
	}

	public boolean isSuccess(){
		return responseCode == 200;
	}
	
	public int getResponseCode() {
		return responseCode;
	}

	public String getResponseText() {
		return responseText;
	}

	public String toString(){
		return "Response Code: " + responseCode + "; Response Text: " + responseText + "; Request Url: " + request.getURL();
	}

	public RestService getService() {
		return service;
	}

	public AuroreLoLEntity getResponseEntity() {
		return responseEntity;
	}

	public String getURL() {
		return request.getURL();
	}

	public long getDate() {
		return request.getDate();
	}

	public Context<?> getContext() {
		return request.getContext();
	}

	public String getKey() {
		return request.getKey();
	}
	
}
