package net.aurore.lolservice.stats;

import net.aurore.core.AuroreException;

public class CalculatorInitException extends AuroreException {

	private static final long serialVersionUID = 1L;
	
	public CalculatorInitException(String msg){
		sendError(msg);
	}

}
