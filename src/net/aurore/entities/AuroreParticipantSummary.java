package net.aurore.entities;

import java.math.BigInteger;

import javax.persistence.*;

import net.aurore.lolservice.entities.MatchesParticipant;
import net.aurore.lolservice.entities.MatchesParticipantIdentity;
import net.aurore.lolservice.entities.MatchesParticipantStats;

@Entity
@Table(name = "match_participant_summary")
public class AuroreParticipantSummary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aurore_participant_id", nullable = false, unique = true)
	BigInteger auroreParticipantId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "match_id")
	AuroreMatchSummary match;
	
	
	
	
	@Column(name = "summonerName")
	private String summonerName;
	
	@Column(name = "currentAccountId")
	private long currentAccountId;
	
	@Column(name = "summonerId")
	private long summonerId;
	
	@Column(name = "accountId")
	private long accountId;
	
	@Column(name = "participantId")
	private int participantId;
	
	@Column(name = "teamId")
	private int teamId;
	
	@Column(name = "spell1Id")
	private int spell1Id;
	
	@Column(name = "spell2Id")
	private int spell2Id;
	
	@Column(name = "championId")
	private int championId;
	
	@Column(name = "physicalDamageDealt")
	private long physicalDamageDealt;
	
	@Column(name = "neutralMinionsKilledTeamJungle")
	private int neutralMinionsKilledTeamJungle;
	
	@Column(name = "magicDamageDealt")
	private long magicDamageDealt;
	
	@Column(name = "totalPlayerScore")
	private int totalPlayerScore;
	
	@Column(name = "deaths")
	private int deaths;
	
	@Column(name = "win")
	private boolean win;
	
	@Column(name = "neutralMinionsKilledEnnemyJungle")
	private int neutralMinionsKilledEnemyJungle;
	
	@Column(name = "largestCriticalStrike")
	private int largestCriticalStrike;
	
	@Column(name = "totalDamageDealt")
	private long totalDamageDealt;
	
	@Column(name = "magicDamageDealtToChampions")
	private long magicDamageDealtToChampions;
	
	@Column(name = "visionWardsBoughtInGame")
	private int visionWardsBoughtInGame;
	
	@Column(name = "damageDealtToObjectives")
	private long damageDealtToObjectives;
	
	@Column(name = "largestKillingSpree")
	private int largestKillingSpree;
	
	@Column(name = "quadraKills")
	private int quadraKills;
	
	@Column(name = "teamObjective")
	private int teamObjective;
	
	@Column(name = "totalTimeCrowdControlDealt")
	private int totalTimeCrowdControlDealt;
	
	@Column(name = "longestTimeSpentLiving")
	private int longestTimeSpentLiving;
	
	@Column(name = "wardsKilled")
	private int wardsKilled;
	
	@Column(name = "firstTowerAssist")
	private boolean firstTowerAssist;
	
	@Column(name = "firstTowerKill")
	private boolean firstTowerKill;
	
	@Column(name = "item0")
	private int item0;
	
	@Column(name = "item1")
	private int item1;
	
	@Column(name = "item2")
	private int item2;
	
	@Column(name = "item3")
	private int item3;
	
	@Column(name = "item4")
	private int item4;
	
	@Column(name = "item5")
	private int item5;
	
	@Column(name = "item6")
	private int item6;
	
	@Column(name = "firstBloodAssist")
	private boolean firstBloodAssist;
	
	@Column(name = "visionScore")
	private long visionScore;
	
	@Column(name = "wardsPlaced")
	private int wardsPlaced;
	
	@Column(name = "turretKills")
	private int turretKills;
	
	@Column(name = "tripleKills")
	private int tripleKills;
	
	@Column(name = "damageSelfMitigated")
	private long damageSelfMitigated;
	
	@Column(name = "champLevel")
	private int champLevel;
	
	@Column(name = "firstInhibitorKill")
	private boolean firstInhibitorKill;
	
	@Column(name = "goldEarned")
	private int goldEarned;
	
	@Column(name = "magicalDamageTaken")
	private long magicalDamageTaken;
	
	@Column(name = "kills")
	private int kills;
	
	@Column(name = "doubleKills")
	private int doubleKills;
	
	@Column(name = "trueDamageTaken")
	private long trueDamageTaken;
	
	@Column(name = "firstInhibitorAssist")
	private boolean firstInhibitorAssist;
	
	@Column(name = "assists")
	private int assists;
	
	@Column(name = "unrealKills")
	private int unrealKills;
	
	@Column(name = "neutralMinionsKilled")
	private int neutralMinionsKilled;
	
	@Column(name = "objectivePlayerScore")
	private int objectivePlayerScore;
	
	@Column(name = "combatPlayerScore")
	private int combatPlayerScore;
	
	@Column(name = "damageDealtToTurrets")
	private long damageDealtToTurrets;
	
	@Column(name = "physicalDamageDealtToChampions")
	private long physicalDamageDealtToChampions;
	
	@Column(name = "goldSpent")
	private int goldSpent;
	
	@Column(name = "trueDamageDealt")
	private long trueDamageDealt;
	
	@Column(name = "trueDamageDealtToChampions")
	private long trueDamageDealtToChampions;
	
	@Column(name = "totalHeal")
	private long totalHeal;
	
	@Column(name = "totalMinionsKilled")
	private int totalMinionsKilled;
	
	@Column(name = "firstBloodKill")
	private boolean firstBloodKill;
	
	@Column(name = "largestMultiKill")
	private int largestMultiKill;
	
	@Column(name = "sightWardsBoughtInGame")
	private int sightWardsBoughtInGame;
	
	@Column(name = "totalDamageDealtToChampions")
	private long totalDamageDealtToChampions;
	
	@Column(name = "totalUnitsHealed")
	private int totalUnitsHealed;
	
	@Column(name = "inhibitorKills")
	private int inhibitorKills;
	
	@Column(name = "totalScoreRank")
	private int totalScoreRank;
	
	@Column(name = "totalDamageTaken")
	private long totalDamageTaken;
	
	@Column(name = "killingSprees")
	private int killingSprees;
	
	@Column(name = "timeCCingOthers")
	private long timeCCingOthers;
	
	@Column(name = "physicalDamageTaken")
	private long physicalDamageTaken;

	@Column(name = "pentaKills")
	private int pentaKills;
	
	public AuroreParticipantSummary(){}
	
	public AuroreParticipantSummary(MatchesParticipantIdentity pI, MatchesParticipant p, MatchesParticipantStats stats, AuroreMatchSummary match) {
		this.match = match;
		
		summonerName = pI.getPlayer().getSummonerName();
		currentAccountId = pI.getPlayer().getCurrentAccountId();
		summonerId = pI.getPlayer().getSummonerId();
		accountId = pI.getPlayer().getAccountId();
		participantId = pI.getParticipantId();
		teamId = p.getTeamId();
		spell1Id = p.getSpell1Id();
		spell2Id = p.getSpell2Id();
		championId = p.getChampionId();
		physicalDamageDealt = stats.getPhysicalDamageDealt();
		neutralMinionsKilledTeamJungle = stats.getNeutralMinionsKilledTeamJungle();
		magicDamageDealt = stats.getMagicDamageDealt();
		totalPlayerScore = stats.getTotalPlayerScore();
		deaths = stats.getDeaths();
		win = stats.isWin();
		neutralMinionsKilledEnemyJungle = stats.getNeutralMinionsKilledEnemyJungle();
		largestCriticalStrike = stats.getLargestCriticalStrike();
		totalDamageDealt = stats.getTotalDamageDealt();
		magicDamageDealtToChampions = stats.getMagicDamageDealtToChampions();
		visionWardsBoughtInGame = stats.getVisionWardsBoughtInGame();
		damageDealtToObjectives = stats.getDamageDealtToObjectives();
		largestKillingSpree = stats.getLargestKillingSpree();
		item0 = stats.getItem0();
		item1 = stats.getItem1();
		item2 = stats.getItem2();
		item3 = stats.getItem3();
		item4 = stats.getItem4();
		item5 = stats.getItem5();
		item6 = stats.getItem6();
		quadraKills = stats.getQuadraKills();
		teamObjective = stats.getTeamObjective();
		totalTimeCrowdControlDealt = stats.getTotalTimeCrowdControlDealt();
		longestTimeSpentLiving = stats.getLongestTimeSpentLiving();
		wardsKilled = stats.getWardsKilled();
		firstTowerAssist = stats.isFirstTowerAssist();
		firstTowerKill = stats.isFirstTowerKill();
		firstBloodAssist = stats.isFirstBloodAssist();
		visionScore = stats.getVisionScore();
		wardsPlaced = stats.getWardsPlaced();
		turretKills = stats.getTurretKills();
		tripleKills = stats.getTripleKills();
		damageSelfMitigated = stats.getDamageSelfMitigated();
		champLevel = stats.getChampLevel();
		firstInhibitorKill = stats.isFirstInhibitorKill();
		goldEarned = stats.getGoldEarned();
		magicalDamageTaken = stats.getMagicalDamageTaken();
		kills = stats.getKills();
		doubleKills = stats.getDoubleKills();
		trueDamageTaken = stats.getTrueDamageTaken();
		firstInhibitorAssist = stats.isFirstInhibitorAssist();
		assists = stats.getAssists();
		unrealKills = stats.getUnrealKills();
		neutralMinionsKilled = stats.getNeutralMinionsKilled();
		objectivePlayerScore = stats.getObjectivePlayerScore();
		combatPlayerScore = stats.getCombatPlayerScore();
		damageDealtToTurrets = stats.getDamageDealtToTurrets();
		physicalDamageDealtToChampions = stats.getPhysicalDamageDealtToChampions();
		goldSpent = stats.getGoldSpent();
		trueDamageDealt = stats.getTrueDamageDealt();
		trueDamageDealtToChampions = stats.getTrueDamageDealtToChampions();
		pentaKills = stats.getPentaKills();
		totalHeal = stats.getTotalHeal();
		totalMinionsKilled = stats.getTotalMinionsKilled();
		firstBloodKill = stats.isFirstBloodKill();
		largestMultiKill = stats.getLargestMultiKill();
		sightWardsBoughtInGame = stats.getSightWardsBoughtInGame();
		totalDamageDealtToChampions = stats.getTotalDamageDealtToChampions();
		totalUnitsHealed = stats.getTotalUnitsHealed();
		inhibitorKills = stats.getInhibitorKills();
		totalScoreRank = stats.getTotalScoreRank();
		totalDamageTaken = stats.getTotalDamageTaken();
		killingSprees = stats.getKillingSprees();
		timeCCingOthers = stats.getTimeCCingOthers();
		physicalDamageTaken = stats.getPhysicalDamageTaken();
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public long getCurrentAccountId() {
		return currentAccountId;
	}

	public void setCurrentAccountId(long currentAccountId) {
		this.currentAccountId = currentAccountId;
	}

	public long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getSpell1Id() {
		return spell1Id;
	}

	public void setSpell1Id(int spell1Id) {
		this.spell1Id = spell1Id;
	}

	public int getSpell2Id() {
		return spell2Id;
	}

	public void setSpell2Id(int spell2Id) {
		this.spell2Id = spell2Id;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public long getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}

	public void setPhysicalDamageDealt(long physicalDamageDealt) {
		this.physicalDamageDealt = physicalDamageDealt;
	}

	public int getNeutralMinionsKilledTeamJungle() {
		return neutralMinionsKilledTeamJungle;
	}

	public void setNeutralMinionsKilledTeamJungle(int neutralMinionsKilledTeamJungle) {
		this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
	}

	public long getMagicDamageDealt() {
		return magicDamageDealt;
	}

	public void setMagicDamageDealt(long magicDamageDealt) {
		this.magicDamageDealt = magicDamageDealt;
	}

	public int getTotalPlayerScore() {
		return totalPlayerScore;
	}

	public void setTotalPlayerScore(int totalPlayerScore) {
		this.totalPlayerScore = totalPlayerScore;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public int getNeutralMinionsKilledEnemyJungle() {
		return neutralMinionsKilledEnemyJungle;
	}

	public void setNeutralMinionsKilledEnemyJungle(int neutralMinionsKilledEnemyJungle) {
		this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
	}

	public int getLargestCriticalStrike() {
		return largestCriticalStrike;
	}

	public void setLargestCriticalStrike(int largestCriticalStrike) {
		this.largestCriticalStrike = largestCriticalStrike;
	}

	public long getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public void setTotalDamageDealt(long totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public long getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	public void setMagicDamageDealtToChampions(long magicDamageDealtToChampions) {
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
	}

	public int getVisionWardsBoughtInGame() {
		return visionWardsBoughtInGame;
	}

	public void setVisionWardsBoughtInGame(int visionWardsBoughtInGame) {
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
	}

	public long getDamageDealtToObjectives() {
		return damageDealtToObjectives;
	}

	public void setDamageDealtToObjectives(long damageDealtToObjectives) {
		this.damageDealtToObjectives = damageDealtToObjectives;
	}

	public int getLargestKillingSpree() {
		return largestKillingSpree;
	}

	public void setLargestKillingSpree(int largestKillingSpree) {
		this.largestKillingSpree = largestKillingSpree;
	}

	public int getQuadraKills() {
		return quadraKills;
	}

	public void setQuadraKills(int quadraKills) {
		this.quadraKills = quadraKills;
	}

	public int getTeamObjective() {
		return teamObjective;
	}

	public void setTeamObjective(int teamObjective) {
		this.teamObjective = teamObjective;
	}

	public int getTotalTimeCrowdControlDealt() {
		return totalTimeCrowdControlDealt;
	}

	public void setTotalTimeCrowdControlDealt(int totalTimeCrowdControlDealt) {
		this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
	}

	public int getLongestTimeSpentLiving() {
		return longestTimeSpentLiving;
	}

	public void setLongestTimeSpentLiving(int longestTimeSpentLiving) {
		this.longestTimeSpentLiving = longestTimeSpentLiving;
	}

	public int getWardsKilled() {
		return wardsKilled;
	}

	public void setWardsKilled(int wardsKilled) {
		this.wardsKilled = wardsKilled;
	}

	public boolean isFirstTowerAssist() {
		return firstTowerAssist;
	}

	public void setFirstTowerAssist(boolean firstTowerAssist) {
		this.firstTowerAssist = firstTowerAssist;
	}

	public boolean isFirstTowerKill() {
		return firstTowerKill;
	}

	public void setFirstTowerKill(boolean firstTowerKill) {
		this.firstTowerKill = firstTowerKill;
	}

	public int getItem0() {
		return item0;
	}

	public void setItem0(int item0) {
		this.item0 = item0;
	}

	public int getItem1() {
		return item1;
	}

	public void setItem1(int item1) {
		this.item1 = item1;
	}

	public int getItem2() {
		return item2;
	}

	public void setItem2(int item2) {
		this.item2 = item2;
	}

	public int getItem3() {
		return item3;
	}

	public void setItem3(int item3) {
		this.item3 = item3;
	}

	public int getItem4() {
		return item4;
	}

	public void setItem4(int item4) {
		this.item4 = item4;
	}

	public int getItem5() {
		return item5;
	}

	public void setItem5(int item5) {
		this.item5 = item5;
	}

	public int getItem6() {
		return item6;
	}

	public void setItem6(int item6) {
		this.item6 = item6;
	}

	public boolean isFirstBloodAssist() {
		return firstBloodAssist;
	}

	public void setFirstBloodAssist(boolean firstBloodAssist) {
		this.firstBloodAssist = firstBloodAssist;
	}

	public long getVisionScore() {
		return visionScore;
	}

	public void setVisionScore(long visionScore) {
		this.visionScore = visionScore;
	}

	public int getWardsPlaced() {
		return wardsPlaced;
	}

	public void setWardsPlaced(int wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}

	public int getTurretKills() {
		return turretKills;
	}

	public void setTurretKills(int turretKills) {
		this.turretKills = turretKills;
	}

	public int getTripleKills() {
		return tripleKills;
	}

	public void setTripleKills(int tripleKills) {
		this.tripleKills = tripleKills;
	}

	public long getDamageSelfMitigated() {
		return damageSelfMitigated;
	}

	public void setDamageSelfMitigated(long damageSelfMitigated) {
		this.damageSelfMitigated = damageSelfMitigated;
	}

	public int getChampLevel() {
		return champLevel;
	}

	public void setChampLevel(int champLevel) {
		this.champLevel = champLevel;
	}
	
	public boolean isFirstInhibitorKill() {
		return firstInhibitorKill;
	}

	public void setFirstInhibitorKill(boolean firstInhibitorKill) {
		this.firstInhibitorKill = firstInhibitorKill;
	}

	public int getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(int goldEarned) {
		this.goldEarned = goldEarned;
	}

	public long getMagicalDamageTaken() {
		return magicalDamageTaken;
	}

	public void setMagicalDamageTaken(long magicalDamageTaken) {
		this.magicalDamageTaken = magicalDamageTaken;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDoubleKills() {
		return doubleKills;
	}

	public void setDoubleKills(int doubleKills) {
		this.doubleKills = doubleKills;
	}

	public long getTrueDamageTaken() {
		return trueDamageTaken;
	}

	public void setTrueDamageTaken(long trueDamageTaken) {
		this.trueDamageTaken = trueDamageTaken;
	}

	public boolean isFirstInhibitorAssist() {
		return firstInhibitorAssist;
	}

	public void setFirstInhibitorAssist(boolean firstInhibitorAssist) {
		this.firstInhibitorAssist = firstInhibitorAssist;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getUnrealKills() {
		return unrealKills;
	}

	public void setUnrealKills(int unrealKills) {
		this.unrealKills = unrealKills;
	}

	public int getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	public void setNeutralMinionsKilled(int neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}

	public int getObjectivePlayerScore() {
		return objectivePlayerScore;
	}

	public void setObjectivePlayerScore(int objectivePlayerScore) {
		this.objectivePlayerScore = objectivePlayerScore;
	}

	public int getCombatPlayerScore() {
		return combatPlayerScore;
	}

	public void setCombatPlayerScore(int combatPlayerScore) {
		this.combatPlayerScore = combatPlayerScore;
	}

	public long getDamageDealtToTurrets() {
		return damageDealtToTurrets;
	}

	public void setDamageDealtToTurrets(long damageDealtToTurrets) {
		this.damageDealtToTurrets = damageDealtToTurrets;
	}

	public long getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	public void setPhysicalDamageDealtToChampions(long physicalDamageDealtToChampions) {
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
	}

	public int getGoldSpent() {
		return goldSpent;
	}

	public void setGoldSpent(int goldSpent) {
		this.goldSpent = goldSpent;
	}

	public long getTrueDamageDealt() {
		return trueDamageDealt;
	}

	public void setTrueDamageDealt(long trueDamageDealt) {
		this.trueDamageDealt = trueDamageDealt;
	}

	public long getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}

	public void setTrueDamageDealtToChampions(long trueDamageDealtToChampions) {
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
	}

	public long getTotalHeal() {
		return totalHeal;
	}

	public void setTotalHeal(long totalHeal) {
		this.totalHeal = totalHeal;
	}

	public int getTotalMinionsKilled() {
		return totalMinionsKilled;
	}

	public void setTotalMinionsKilled(int totalMinionsKilled) {
		this.totalMinionsKilled = totalMinionsKilled;
	}

	public boolean isFirstBloodKill() {
		return firstBloodKill;
	}

	public void setFirstBloodKill(boolean firstBloodKill) {
		this.firstBloodKill = firstBloodKill;
	}

	public int getLargestMultiKill() {
		return largestMultiKill;
	}

	public void setLargestMultiKill(int largestMultiKill) {
		this.largestMultiKill = largestMultiKill;
	}

	public int getSightWardsBoughtInGame() {
		return sightWardsBoughtInGame;
	}

	public void setSightWardsBoughtInGame(int sightWardsBoughtInGame) {
		this.sightWardsBoughtInGame = sightWardsBoughtInGame;
	}

	public long getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public void setTotalDamageDealtToChampions(long totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}

	public int getTotalUnitsHealed() {
		return totalUnitsHealed;
	}

	public void setTotalUnitsHealed(int totalUnitsHealed) {
		this.totalUnitsHealed = totalUnitsHealed;
	}

	public int getInhibitorKills() {
		return inhibitorKills;
	}

	public void setInhibitorKills(int inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}

	public int getTotalScoreRank() {
		return totalScoreRank;
	}

	public void setTotalScoreRank(int totalScoreRank) {
		this.totalScoreRank = totalScoreRank;
	}

	public long getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public void setTotalDamageTaken(long totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public int getKillingSprees() {
		return killingSprees;
	}

	public void setKillingSprees(int killingSprees) {
		this.killingSprees = killingSprees;
	}

	public long getTimeCCingOthers() {
		return timeCCingOthers;
	}

	public void setTimeCCingOthers(long timeCCingOthers) {
		this.timeCCingOthers = timeCCingOthers;
	}

	public long getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}

	public void setPhysicalDamageTaken(long physicalDamageTaken) {
		this.physicalDamageTaken = physicalDamageTaken;
	}

	public int getPentaKills() {
		return pentaKills;
	}

	public void setPentaKills(int pentaKills) {
		this.pentaKills = pentaKills;
	}

	public BigInteger getAuroreParticipantId() {
		return auroreParticipantId;
	}

	public void setAuroreParticipantId(BigInteger auroreParticipantId) {
		this.auroreParticipantId = auroreParticipantId;
	}

	public AuroreMatchSummary getMatch() {
		return match;
	}

	public void setMatch(AuroreMatchSummary match) {
		this.match = match;
	}

	

	
}
