package net.aurore.lolservice;

public class RestServiceRequest {

	
	private final String URL;
	
	private final long DATE;
	
	private boolean validated = false;
	
	public RestServiceRequest(String url, long date){
		URL = url;
		DATE = date;
	}

	public String getURL(){
		return URL;
	}
	
	public long getDate(){
		return DATE;
	}
	
	public void validated(){
		validated = true;
	}
	
	public boolean isValidated(){
		return validated;
	}
}
