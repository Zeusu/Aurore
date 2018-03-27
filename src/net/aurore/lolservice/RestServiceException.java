package net.aurore.lolservice;

import java.util.HashMap;
import java.util.Map;

import net.aurore.core.AuroreException;

public class RestServiceException extends AuroreException{

	private static final long serialVersionUID = 1L;
	
	private static final Map<Integer,String> TEXTS = new HashMap<Integer,String>();
	
	static{
		TEXTS.put(400, "Bad request");
		TEXTS.put(401, "Unauthorized");
		TEXTS.put(403, "Forbidden (Is API Key up ?)");
		TEXTS.put(405, "Method not allowed (Put instead of Get ?)");
		TEXTS.put(415, "Unsupported media type");
		TEXTS.put(429, "|!| Rate limit exceeded |!|");
		TEXTS.put(500, "Internal serveur error");
		TEXTS.put(502, "Bad gateway");
		TEXTS.put(503, "Service unavailable");
		TEXTS.put(504, "Gateway timeout");
	}
	
	private int errorCode;
	
	
	public RestServiceException(){
		sendError("Undefined RestServiceExeption, please check logs");
	}
	
	public RestServiceException(int errorCode){
		this.errorCode = errorCode;
		StringBuffer buffer = new StringBuffer();
		buffer.append("Error code: ");
		buffer.append(errorCode);
		buffer.append('\n');
		buffer.append("Error type: ");
		buffer.append(TEXTS.get(errorCode));
		sendError(buffer.toString());
	}

	public int getErrorCode() {
		return errorCode;
	}
}
