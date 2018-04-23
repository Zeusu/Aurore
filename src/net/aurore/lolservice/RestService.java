package net.aurore.lolservice;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import net.aurore.util.ThreadPoolManager;



public class RestService{
	
	private static final int MAX_REQUEST_PER_SECOUND = 20;
	private static final int SECOUND = 1000;
	private static final int MAX_REQUEST_EVERY_TWO_MINUTES = 100;
	private static final int TWO_MINUTES = 120000;

	
	private static final ThreadPoolExecutor POOL = ThreadPoolManager.initiatePool(3, 3, 1, TimeUnit.MINUTES);
	
	private static final RestServiceQueue QUEUE = new RestServiceQueue(SECOUND, MAX_REQUEST_PER_SECOUND, TWO_MINUTES, MAX_REQUEST_EVERY_TWO_MINUTES);
	
	private final RestServiceControllerThread CONTROLLER;
	
	public RestService(){
		CONTROLLER = new RestServiceControllerThread(this);
		ThreadPoolManager.addSingleThread(CONTROLLER);
		CONTROLLER.start();
	}
	
	public long queue(){
		return QUEUE.queue();
	}
	
	synchronized public void doRequest() throws Exception{
		RestServiceRequest req = QUEUE.getToTreatRequest();
		if(req == null) return;
		RestServiceHTTPGetRequest httpRequest = new RestServiceHTTPGetRequest(QUEUE.getToTreatRequest(),this);
		POOL.submit(new Runnable(){
			@Override
			public void run() {
				RestServiceResponse r = null;
				try {
					r = httpRequest.execute();
				} catch (RestServiceException | IOException e) {
				}
				if(r != null && r.getResponseCode() == 200){
					AuroreLoLResponseHandler.pushResponseTo(r);
				}
			}
		});
		req.validated();
	}
	
	synchronized public void addToQueue(RestServiceRequest r){
		QUEUE.addToQueue(r);
	}
	

	public boolean queueEmpty() {	
		return QUEUE.isEmpty();
	}
	
}
