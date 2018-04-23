package net.aurore.lolservice;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.aurore.entities.Context;
import net.aurore.lolservice.entities.AuroreLoLEntity;

public abstract class RestServiceRequest {

	
	private final String URL;
	
	private long date;
	
	private final Context<?> CONTEXT;
	
	private final String KEY;
	
	private boolean validated = false;
	
	protected static final ObjectMapper MAPPER = new ObjectMapper();
	
	public RestServiceRequest(String url, Context<?> c, String k){
		URL = url;
		CONTEXT = c;
		KEY = k;
	}
	
	
	public abstract AuroreLoLEntity deserializeRequestObject(String responseText);
	

	public String getURL(){
		return URL;
	}
	
	public long getDate(){
		return date;
	}
	
	public void setDate(long date){
		this.date = date;
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

}
