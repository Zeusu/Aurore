package net.aurore.core;

import java.util.LinkedList;
import java.util.List;

public final class AuroreConsoleMessages {

	private static final List<Object> HISTORIC = new LinkedList<Object>(); 
	
	public static void add(Object o){
		HISTORIC.add(o);
		System.out.println(o);
		if(HISTORIC.size() > 500) clearHistoric();
	}
	
	public static List<Object> getHistoric(){
		return HISTORIC;
	}
	
	private static void clearHistoric(){
		HISTORIC.remove(0);
		if(HISTORIC.size() > 500) clearHistoric();
	}
	
}
