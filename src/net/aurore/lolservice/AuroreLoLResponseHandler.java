package net.aurore.lolservice;

import java.util.HashMap;
import java.util.Map;

public class AuroreLoLResponseHandler {

	public static Map<String,AuroreLoLListener> listeners = new HashMap<String,AuroreLoLListener>();
	
	public static void addListener(AuroreLoLListener listener){
		listeners.put(listener.key(), listener);
	}
	
	
}
