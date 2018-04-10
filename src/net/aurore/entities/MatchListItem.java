package net.aurore.entities;

import java.math.BigInteger;

import javax.persistence.*;


@Entity
@Table(name = "match_list")
@IdClass(MatchListItemKey.class)
public class MatchListItem {

	@Id
	@Column(name = "match_id", nullable = false)
	private BigInteger matchId;
	
	@Id
	@Column(name = "summoner_id", nullable = false)
	private long summonerId;

	public MatchListItem(){}
	
	public MatchListItem(long summonerId, BigInteger matchId){
		this.matchId = matchId;
		this.summonerId = summonerId;
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
