package net.aurore.lolservice;

import net.aurore.entities.Context;

public class RestServiceRequest {

	
	private final String URL;
	
	private final long DATE;
	
	private final Context<?> CONTEXT;
	
	private final String KEY;
	
	private final Class<?> CLS;
	
	private boolean validated = false;
	
	
	public RestServiceRequest(String url, long date, Context<?> c, String k, Class<?> cl){
		URL = url;
		DATE = date;
		CONTEXT = c;
		KEY = k;
		CLS = cl;
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

	public Context<?> getContext() {
		return CONTEXT;
	}

	public String getKey() {
		return KEY;
	}

	public Class<?> getCls() {
		return CLS;
	}
}
