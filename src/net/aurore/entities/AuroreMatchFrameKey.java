package net.aurore.entities;

import java.io.Serializable;
import java.math.BigInteger;


@SuppressWarnings("serial")
public class AuroreMatchFrameKey implements Serializable{

	private BigInteger matchId;
	
	private BigInteger frameId;
	
	
	@Override
	public int hashCode(){
		return 0;
	}
	
	public boolean equals(Object o){
		if(o == null) return false;
		if(o.getClass() != getClass()) return false;
		AuroreMatchFrameKey k = (AuroreMatchFrameKey) o;
		return (matchId.equals(k.getMatchId()) && frameId.equals(k.getFrameId()));
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

}
