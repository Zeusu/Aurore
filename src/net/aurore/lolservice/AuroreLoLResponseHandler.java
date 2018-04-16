package net.aurore.lolservice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.aurore.entities.Context;
import net.aurore.util.ThreadPoolManager;

public class AuroreLoLResponseHandler {

	public static Map<String,AuroreLoLListener> listeners = new HashMap<String,AuroreLoLListener>();
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	public static final ThreadPoolExecutor POOL = ThreadPoolManager.initiatePool(5, 5, 10, TimeUnit.SECONDS);
	
	public static void addListener(AuroreLoLListener listener){
		listeners.put(listener.key(), listener);
	}
	
	public static void pushResponseTo(String key, Context<?> c, RestServiceResponse r, Class<?> cls){
		POOL.submit(new Runnable(){
			@Override
			public void run(){
				Object e = null;
				System.out.println(key);
				System.out.println(cls);
				try {
					e =  MAPPER.readValue(r.getResponseText(), cls);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if(e != null)					
					listeners.get(key).callback(c,e);
			}
		});	
	}

}
