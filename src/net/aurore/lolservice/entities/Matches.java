package net.aurore.lolservice.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;

public class Matches extends AuroreLoLEntity{
	
	@JsonIgnore
	private BigInteger matchId;
	
	private long gameId;

	private int seasonId;
	
	private int queueId;
	
	private String gameVersion;
	
	private String platformId;
	
	private String gameMode;
	
	private int mapId;
	
	private String gameType;
	
	private long gameDuration;
	
	private long gameCreation;

	private List<MatchesParticipantIdentity> participantIdentities = new ArrayList<MatchesParticipantIdentity>();
	
	private List<MatchesTeamStats> teams = new ArrayList<MatchesTeamStats>();
	
	private List<MatchesParticipant> participants = new ArrayList<MatchesParticipant>();

	
	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public int getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public int getQueueId() {
		return queueId;
	}

	public void setQueueId(int queueId) {
		this.queueId = queueId;
	}

	public String getGameVersion() {
		return gameVersion;
	}

	public void setGameVersion(String gameVersion) {
		this.gameVersion = gameVersion;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public long getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(long gameDuration) {
		this.gameDuration = gameDuration;
	}

	public long getGameCreation() {
		return gameCreation;
	}

	public void setGameCreation(long gameCreation) {
		this.gameCreation = gameCreation;
	}

	public List<MatchesParticipantIdentity> getParticipantIdentities() {
		return participantIdentities;
	}

	public void setParticipantIdentities(List<MatchesParticipantIdentity> participantIdentities) {
		this.participantIdentities = participantIdentities;
	}

	public List<MatchesTeamStats> getTeams() {
		return teams;
	}

	public void setTeams(List<MatchesTeamStats> teams) {
		this.teams = teams;
	}

	public List<MatchesParticipant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<MatchesParticipant> participants) {
		this.participants = participants;
	}

	public BigInteger getMatchId() {
		return matchId;
	}

	public void setMatchId(BigInteger matchId) {
		this.matchId = matchId;
	}
	
}
