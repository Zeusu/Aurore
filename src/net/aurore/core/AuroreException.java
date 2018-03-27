package net.aurore.core;

public class AuroreException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private static final String AURORE_ERROR_FIRST_LINE = "[AURORE EXCEPTION] Aurore couldn't execute an action ... please read ....";
	
	protected void sendError(String toSend){
		System.err.println(AURORE_ERROR_FIRST_LINE);
		System.err.println(toSend);
	}
	
}
