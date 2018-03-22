package net.aurore.entities;

import java.io.Serializable;
import java.math.BigInteger;


@SuppressWarnings("serial")
public class AuroreMatchParticipantFrameKey implements Serializable{

	private BigInteger matchId;
	
	private BigInteger frameId;
	
	private int participantId;


	@Override
	public int hashCode(){
		if(matchId == null || frameId == null) return 0;
		final int prime = 31;
		int result = 1;
		result = prime * result + (matchId.hashCode());
		result = prime * result + (frameId.hashCode());
		result = prime * result + participantId;
		return result;
	}
	
	public boolean equals(Object o){
		if(o == null) return false;
		if(o.getClass() != getClass()) return false;
		AuroreMatchParticipantFrameKey k = (AuroreMatchParticipantFrameKey) o;
		return (matchId.equals(k.getMatchId())
				&& frameId.equals(k.getFrameId())
				&& participantId == k.getParticipantId());
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

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

}