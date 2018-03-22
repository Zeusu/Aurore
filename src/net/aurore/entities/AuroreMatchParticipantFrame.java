package net.aurore.entities;

import java.math.BigInteger;

import javax.persistence.*;

import net.aurore.lolservice.entities.MatchParticipantFrame;

@Entity
@Table(name = "matchparticipantframe")
@IdClass(AuroreMatchParticipantFrameKey.class)
public class AuroreMatchParticipantFrame {
	
	@Id @Column(name = "matchId")
	private BigInteger matchId; 
	
	@Id @Column(name = "frameId")
	private BigInteger frameId; 
	
	@Id @Column(name = "participantId")
	private int participantId; 
	
	@Column(name = "totalGold")
	private int totalGold;
	
	@Column(name = "teamScore")
	private int teamScore;
	
	@Column(name = "level")
	private int level;
	
	@Column(name = "currentGold")
	private int currentGold;
	
	@Column(name = "minionsKilled")
	private int minionsKilled;
	
	@Column(name = "dominionScore")
	private int dominionScore;
	
	@Column(name = "xp")
	private int xp;
	
	@Column(name = "jungleMinionsKilled")
	private int jungleMinionsKilled;
	
	
	public AuroreMatchParticipantFrame(){}
	
	public AuroreMatchParticipantFrame(MatchParticipantFrame participant){
		participantId = participant.getParticipantId();
		
		totalGold = participant.getTotalGold();
		teamScore = participant.getTotalGold();
		level = participant.getLevel();
		currentGold = participant.getCurrentGold();
		minionsKilled = participant.getMinionsKilled();
		dominionScore = participant.getDominionScore();
		xp = participant.getXp();
		jungleMinionsKilled = participant.getJungleMinionsKilled();
		
	}
	
	public AuroreMatchParticipantFrame(MatchParticipantFrame participant, BigInteger matchId, BigInteger frameId){
		this(participant);
		this.matchId = matchId;
		this.frameId = frameId;
	}
	
	
	public int getTotalGold() {
		return totalGold;
	}
	public void setTotalGold(int totalGold) {
		this.totalGold = totalGold;
	}
	public int getTeamScore() {
		return teamScore;
	}
	public void setTeamScore(int teamScore) {
		this.teamScore = teamScore;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getCurrentGold() {
		return currentGold;
	}
	public void setCurrentGold(int currentGold) {
		this.currentGold = currentGold;
	}
	public int getMinionsKilled() {
		return minionsKilled;
	}
	public void setMinionsKilled(int minionsKilled) {
		this.minionsKilled = minionsKilled;
	}
	public int getDominionScore() {
		return dominionScore;
	}
	public void setDominionScore(int dominionScore) {
		this.dominionScore = dominionScore;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public int getJungleMinionsKilled() {
		return jungleMinionsKilled;
	}
	public void setJungleMinionsKilled(int jungleMinionsKilled) {
		this.jungleMinionsKilled = jungleMinionsKilled;
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

