package net.aurore.lolservice;

import java.util.LinkedList;

public class RestServiceQueue {

	private final LinkedList<RestServiceRequest> QUEUE_SEC = new LinkedList<RestServiceRequest>();
	
	private final LinkedList<RestServiceRequest> QUEUE_MIN = new LinkedList<RestServiceRequest>();
	
	private int interval;
	
	private int nbRequest;
	
	private int intervalMin;
	
	private int nbRequestMin;
	
	protected RestServiceQueue(int i, int nbReq, int iM, int nbReqM){
		interval = i;
		nbRequest = nbReq;
		intervalMin = iM;
		nbRequestMin = nbReqM;
	}
	
	protected void addToQueue(RestServiceRequest r){
		r.setDate(System.currentTimeMillis());
		QUEUE_SEC.add(r);
		QUEUE_MIN.add(r);
	}
	
	protected RestServiceRequest getToTreatRequest(){
		for(RestServiceRequest r : QUEUE_SEC){
			if(!r.isValidated()) return r;
		}
		return null;
	}
	
	
	protected long queue(){
		
		long now = System.currentTimeMillis();
		long sValue = 0;
		long mValue = 0;
		
		if(QUEUE_SEC.size() != 0){
			sValue = doQueue(QUEUE_SEC,now,interval, nbRequest);
		}
		if(QUEUE_MIN.size() != 0){
			mValue = doQueue(QUEUE_MIN,now, intervalMin, nbRequestMin);
		}
		return Math.max(sValue, mValue); 

	}
	
	private long doQueue(LinkedList<RestServiceRequest> q, long now, int interval, int nbRequest){
		if(now > q.getFirst().getDate() + interval){
			clearQueue(q,now, interval);
		}
		
		if(nbRequest > q.size() + 1) return 0;
		
		Long l = q.getFirst().getDate();
		
		return interval - Math.abs(now - l.longValue());

	}
	
	
	private void clearQueue(LinkedList<RestServiceRequest> q, long currentTime, long rmTime) {
		RestServiceRequest first = null;
		if(q.size() > 0){
			first = q.removeFirst();
		}
		if(first != null){
			if (currentTime > first.getDate() + rmTime) {
				if (q.size() > 0){
					clearQueue(q, currentTime, rmTime);
				}
			}
		}
		return;
	}

	public boolean isEmpty() {
		return QUEUE_SEC.isEmpty();
	}	
}
