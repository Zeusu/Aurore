package net.aurore.lolservice;

public class RestServiceResponse {

	private int responseCode;
	
	private String responseText;
	
	private String requestUrl;
	
	private RestService service;
	
	RestServiceResponse(int code, String text, String requestUrl, RestService service){
		responseCode = code;
		this.requestUrl = requestUrl;
		this.service = service;
		if(code == 200){
			responseText = text;
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
	
	public RestServiceResponse resend() throws Exception{
		return service.doRequest(requestUrl);
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

	public String getRequestUrl() {
		return requestUrl;
	}

	public String toString(){
		return "Response Code: " + responseCode + "; Response Text: " + responseText + "; Request Url: " + requestUrl;
	}
	
	
	
}
