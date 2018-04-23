package net.aurore.lolservice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import net.aurore.util.ThreadPoolManager;

public class AuroreLoLResponseHandler {

	public static Map<String,AuroreLoLListener> listeners = new HashMap<String,AuroreLoLListener>();
	
	public static final ThreadPoolExecutor POOL = ThreadPoolManager.initiatePool(5, 5, 10, TimeUnit.SECONDS);
	
	public static void addListener(AuroreLoLListener listener){
		listeners.put(listener.key(), listener);
	}
	
	public static void pushResponseTo(RestServiceResponse r){
		POOL.submit(new Runnable(){
			@Override
			public void run(){			
				listeners.get(r.getKey()).callback(r.getContext(),r.getResponseEntity());
			}
		});	
	}

}
