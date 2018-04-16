package net.aurore.lolservice.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "rank")
public class Rank extends AuroreLoLEntity{

	@JsonIgnore
	public static final String RANKED_SOLO = "RANKED_SOLO_5x5";

	
	
	
	@JsonIgnore @Column(name = "summonerId")
	private long summonerId;
	
	@Column(name = "playerOrTeamId") @Id
	private String playerOrTeamId = "";
	
	@Column(name = "rank")
	private String rank = "";
	
	@Column(name = "queueType")
	private String queueType = "";
	
	@Column(name = "hotStreak")
	private boolean hotStreak = false;
	
	@Column(name = "wins")
	private int wins = 0;
	
	@Column(name = "losses")
	private int losses = 0;
	
	@Column(name = "veteran")
	private boolean veteran = false;
	
	@Column(name = "freshBlood")
	private boolean freshBlood = false;
	
	@Column(name = "leagueId")
	private String leagueId = "";
	
	@Column(name = "playerOrTeamName")
	private String playerOrTeamName = "";
	
	@Column(name = "inactive")
	private boolean inactive = false;
	
	@Column(name = "leagueName")
	private String leagueName = "";
	
	@Column(name = "tier")
	private String tier = "";
	
	@Column(name = "leaguePoints")
	private int leaguePoints = 0;

	@Transient
	private MiniSeries miniSeries = null;
	
	
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getQueueType() {
		return queueType;
	}

	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}

	public boolean isHotStreak() {
		return hotStreak;
	}

	public void setHotStreak(boolean hotStreak) {
		this.hotStreak = hotStreak;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public boolean isFreshBlood() {
		return freshBlood;
	}

	public void setFreshBlood(boolean freshBlood) {
		this.freshBlood = freshBlood;
	}

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getPlayerOrTeamName() {
		return playerOrTeamName;
	}

	public void setPlayerOrTeamName(String playerOrTeamName) {
		this.playerOrTeamName = playerOrTeamName;
	}

	public boolean isInactive() {
		return inactive;
	}

	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}

	public String getPlayerOrTeamId() {
		return playerOrTeamId;
	}

	public void setPlayerOrTeamId(String playerOrTeamId) {
		this.playerOrTeamId = playerOrTeamId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public int getLeaguePoints() {
		return leaguePoints;
	}

	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public boolean isVeteran() {
		return veteran;
	}

	public void setVeteran(boolean veteran) {
		this.veteran = veteran;
	}

	public MiniSeries getMiniSeries() {
		return miniSeries;
	}

	public void setMiniSeries(MiniSeries miniSeries) {
		this.miniSeries = miniSeries;
	}
	
	public void setSummonerId(long id){
		summonerId = id;
	}
	
	public long getSummonerId(){
		return summonerId;
	}
}
