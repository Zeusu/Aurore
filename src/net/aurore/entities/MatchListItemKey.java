package net.aurore.entities;

import java.io.Serializable;
import java.math.BigInteger;

@SuppressWarnings("serial")
public class MatchListItemKey implements Serializable{


	private BigInteger matchId;
	
	private long summonerId;

	public boolean equals(Object o){
		if(o == null) return false;
		if(!(o instanceof MatchListItemKey)) return false;
		MatchListItemKey k = (MatchListItemKey) o;
		return summonerId == k.summonerId && matchId.equals(k.matchId);
	}
	
	public int hashCode(){
		return matchId.hashCode() + ((int) (summonerId * 32));
	}

	public BigInteger getMatchId() {
		return matchId;
	}

	public void setMatchId(BigInteger matchId) {
		this.matchId = matchId;
	}

	public long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

	
}
