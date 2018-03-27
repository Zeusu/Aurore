package net.aurore.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import net.aurore.lolservice.entities.Matches;
import net.aurore.lolservice.entities.MatchesParticipant;
import net.aurore.lolservice.entities.MatchesParticipantIdentity;
import net.aurore.lolservice.entities.MatchesTeamStats;

@Entity
@Table(name = "match_summary")
public class AuroreMatchSummary {
	
	@Id
	@Column(name = "matchId", nullable = false, unique = true)
	private BigInteger matchId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "match", fetch = FetchType.LAZY)
	private List<AuroreParticipantSummary> participants = new ArrayList<AuroreParticipantSummary>();
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "match", fetch = FetchType.LAZY)
	private List<AuroreTeamSummary> teams = new ArrayList<AuroreTeamSummary>();
	
	@Column(name = "seasonId")
	private int seasonId;
	
	@Column(name = "queueId")
	private int queueId;
	
	@Column(name = "gameVersion")
	private String gameVersion;
	
	@Column(name = "platformId")
	private String platformId;
	
	@Column(name = "gameDuration")
	private long gameDuration;
	
	public AuroreMatchSummary(){}
	
	public AuroreMatchSummary(Matches m){
		matchId = m.getMatchId();
		seasonId = m.getSeasonId();
		queueId = m.getQueueId();
		gameVersion = m.getGameVersion();
		platformId = m.getPlatformId();
		gameDuration = m.getGameDuration();
		
		for(MatchesTeamStats team : m.getTeams()){
			teams.add(new AuroreTeamSummary(team,this));
		}
		
		for(MatchesParticipantIdentity pI : m.getParticipantIdentities()){
			for(MatchesParticipant p : m.getParticipants()){
				if(pI.getParticipantId() == p.getParticipantId()){
					participants.add(new AuroreParticipantSummary(pI, p , p.getStats(),this));
				}
			}
		}
		
	}

	public BigInteger getMatchId() {
		return matchId;
	}

	public void setMatchId(BigInteger matchId) {
		this.matchId = matchId;
	}

	public List<AuroreParticipantSummary> getParticipants() {
		return participants;
	}

	public void setParticipants(List<AuroreParticipantSummary> participants) {
		this.participants = participants;
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

	public long getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(long gameDuration) {
		this.gameDuration = gameDuration;
	}
	
	
	
	


}
