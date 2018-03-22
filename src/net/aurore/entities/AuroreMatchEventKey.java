package net.aurore.entities;

import java.io.Serializable;
import java.math.BigInteger;


@SuppressWarnings("serial")
public class AuroreMatchEventKey implements Serializable{

	private BigInteger matchId;
	
	private BigInteger frameId;
	
	private BigInteger eventId;
	
	@Override
	public int hashCode(){
		return 0;
	}
	
	public boolean equals(Object o){
		if(o == null) return false;
		if(o.getClass() != getClass()) return false;
		AuroreMatchEventKey key = (AuroreMatchEventKey) o;
		return (matchId.equals(key.getMatchId())
				&& frameId.equals(key.frameId)
				&& eventId.equals(key.getEventId()));
	}
	
	public BigInteger getMatchId() {
		return matchId;
	}

	public void setMatchId(BigInteger matchId) {
		this.matchId = matchId;
	}

	public BigInteger getFrameId() {
		return frameId;
	}

	public void setFrameId(BigInteger frameId) {
		this.frameId = frameId;
	}

	public BigInteger getEventId() {
		return eventId;
	}

	public void setEventId(BigInteger eventId) {
		this.eventId = eventId;
	}
}
