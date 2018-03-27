package net.aurore.entities;


import javax.persistence.*;

import net.aurore.lolservice.entities.MatchParticipantFrame;

@Entity
@Table(name = "matchparticipantframe")
public class AuroreMatchParticipantFrame {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auroreParticipantId", nullable = false, unique = true)
	private int auroreParticipantId; 
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "frameId")
	private AuroreMatchFrame frame; 
	
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
	
	@Column(name = "participantId")
	private int participantId;
	
	
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
	
	public AuroreMatchParticipantFrame(MatchParticipantFrame participant, AuroreMatchFrame frame){
		this(participant);
		this.frame = frame;
	}
	
	public int getAuroreParticipantId() {
		return auroreParticipantId;
	}

	public void setAuroreParticipantId(int auroreParticipantId) {
		this.auroreParticipantId = auroreParticipantId;
	}

	public boolean equals(Object o){
		if(o == null) return false;
		
		if(!(o instanceof AuroreMatchParticipantFrame)) return false;
		
		AuroreMatchParticipantFrame k = (AuroreMatchParticipantFrame) o;
		return (frame.getMatch().getMatchId().equals(k.frame.getMatch().getMatchId())
				&& frame.getFrameId().equals(k.frame.getFrameId())
				&& participantId == k.getParticipantId());
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

	public AuroreMatchFrame getFrame() {
		return frame;
	}

	public void setFrame(AuroreMatchFrame frame) {
		this.frame = frame;
	}

}

