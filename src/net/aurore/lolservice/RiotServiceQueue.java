package net.aurore.lolservice;

import java.util.LinkedList;

public class RiotServiceQueue {

	private final LinkedList<Long> QUEUE_SEC = new LinkedList<Long>();
	
	private final LinkedList<Long> QUEUE_MIN = new LinkedList<Long>();
	
	private int interval;
	
	private int nbRequest;
	
	private int intervalMin;
	
	private int nbRequestMin;
	
	protected RiotServiceQueue(int i, int nbReq, int iM, int nbReqM){
		interval = i;
		nbRequest = nbReq;
		intervalMin = iM;
		nbRequestMin = nbReqM;
	}
	
	private void addToQueue(LinkedList<Long> q , long date){
		Long l = new Long(date);
		q.add(l);
	}
	
	protected long queue(){
		
		long now = System.currentTimeMillis();
		long sValue = doQueue(QUEUE_SEC,now,interval, nbRequest);
		long mValue = doQueue(QUEUE_MIN,now, intervalMin, nbRequestMin);
		
		return Math.max(sValue, mValue); 

	}
	
	private long doQueue(LinkedList<Long> q, long now, int interval, int nbRequest){
		
		
		addToQueue(q,now);
		if(now > q.getFirst() + interval){
			clearQueue(q,now, interval);
		}
		Long l = q.getFirst();
		if(nbRequest > q.size() + 1) return 0;
		
		return interval - Math.abs(now - l.longValue());
	}
	
	private void clearQueue(LinkedList<Long> q,long currentTime, long rmTime){
		if(currentTime > q.getFirst() + rmTime){
			q.removeFirst();
			clearQueue(q, currentTime, rmTime);
		}
		return;
	}	
}
