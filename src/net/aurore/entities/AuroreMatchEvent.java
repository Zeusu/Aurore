package net.aurore.entities;

import java.math.BigInteger;

import javax.persistence.*;

import net.aurore.lolservice.entities.MatchEvent;

@Entity
@Table(name = "matcheventframe")
@IdClass(AuroreMatchEventKey.class)
public class AuroreMatchEvent {

	@Id
	@Column(name = "matchId")
	private BigInteger matchId;
	
	@Id
	@Column(name = "frameId") 
	private BigInteger frameId;
	
	@Id
	@Column(name = "eventId")
	private BigInteger eventId;
	
	
	
	@Column(name = "eventType")
	private String eventType;
	
	@Column(name = "towerType")
	private String towerType;
	
	@Column(name = "teamId")
	private int teamId;
	
	@Column(name = "ascendedType")
	private String ascendedType;
	
	@Column(name = "killerId")
	private int killerId;
	
	@Column(name = "levelUpType")
	private String levelUpType;
	
	@Column(name = "pointCaptured")
	private String pointCaptured;
	
	@Column(name = "wardType")
	private String wardType;
	
	@Column(name = "monsterType")
	private String monsterType;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "skillSlot")
	private int skillSlot;
	
	@Column(name = "victimId")
	private int victimId;
	
	@Column(name = "timestamp")
	private long timestamp;
	
	@Column(name = "afterId")
	private int afterId;
	
	@Column(name = "monsterSubType")
	private String monsterSubType;
	
	@Column(name = "laneType")
	private String laneType;
	
	@Column(name = "itemId")
	private int itemId;
	
	@Column(name = "participantId")
	private int participantId;
	
	@Column(name = "buildingType")
	private String buildingType;
	
	@Column(name = "creatorId")
	private int creatorId;
	
	@Column(name = "beforeId")
	private int beforeId;
	
	public AuroreMatchEvent(){}
	
	public AuroreMatchEvent(MatchEvent event){
		eventType = event.getEventType();
		towerType = event.getTowerType();
		teamId = event.getTeamId();
		ascendedType = event.getAscendedType();
		killerId = event.getKillerId();
		levelUpType = event.getLevelUpType();
		pointCaptured = event.getPointCaptured();
		wardType = event.getWardType();
		monsterType = event.getMonsterType();
		type = event.getType();
		skillSlot = event.getSkillSlot();
		victimId = event.getVictimId();
		timestamp = event.getTimestamp();
		afterId = event.getAfterId();
		monsterSubType = event.getMonsterSubType();
		laneType = event.getLaneType();
		itemId = event.getItemId();
		participantId = event.getParticipantId();
		buildingType = event.getBuildingType();
		creatorId = event.getCreatorId();
		beforeId = event.getBeforeId();
	}
	
	public AuroreMatchEvent(MatchEvent event, BigInteger matchId, BigInteger frameId, BigInteger eventId){
		this(event);
		this.matchId = matchId;
		this.frameId = frameId;
		this.eventId = eventId;
	}
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getTowerType() {
		return towerType;
	}
	public void setTowerType(String towerType) {
		this.towerType = towerType;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getAscendedType() {
		return ascendedType;
	}
	public void setAscendedType(String ascendedType) {
		this.ascendedType = ascendedType;
	}
	public String getLevelUpType() {
		return levelUpType;
	}
	public void setLevelUpType(String levelUpType) {
		this.levelUpType = levelUpType;
	}
	public String getPointCaptured() {
		return pointCaptured;
	}
	public void setPointCaptured(String pointCaptured) {
		this.pointCaptured = pointCaptured;
	}
	public String getWardType() {
		return wardType;
	}
	public void setWardType(String wardType) {
		this.wardType = wardType;
	}
	public String getMonsterType() {
		return monsterType;
	}
	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSkillSlot() {
		return skillSlot;
	}
	public void setSkillSlot(int skillSlot) {
		this.skillSlot = skillSlot;
	}
	public int getVictimId() {
		return victimId;
	}
	public void setVictimId(int victimId) {
		this.victimId = victimId;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public int getAfterId() {
		return afterId;
	}
	public void setAfterId(int afterId) {
		this.afterId = afterId;
	}
	public String getMonsterSubType() {
		return monsterSubType;
	}
	public void setMonsterSubType(String monsterSubType) {
		this.monsterSubType = monsterSubType;
	}
	public String getLaneType() {
		return laneType;
	}
	public void setLaneType(String laneType) {
		this.laneType = laneType;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public int getBeforeId() {
		return beforeId;
	}
	public void setBeforeId(int beforeId) {
		this.beforeId = beforeId;
	}
	public int getKillerId() {
		return killerId;
	}
	public void setKillerId(int killerId) {
		this.killerId = killerId;
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