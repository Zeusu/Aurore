package net.aurore.lolservice.entities;

import java.util.ArrayList;
import java.util.List;

public class MatchesParticipant {

	private int participantId;
	
	private int teamId;
	
	private int spell2Id;
	
	private String highestAchievedSeasonTier;
	
	private int spell1Id;
	
	private int championId;
	
	private MatchesParticipantStats stats;
	
	private List<MatchesRune> runes = new ArrayList<MatchesRune>();
	
	private MatchesParticipantTimeline timeline;
	
	private List<MatchesMastery> masteries = new ArrayList<MatchesMastery>();

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

	public int getSpell2Id() {
		return spell2Id;
	}

	public void setSpell2Id(int spell2Id) {
		this.spell2Id = spell2Id;
	}

	public String getHighestAchievedSeasonTier() {
		return highestAchievedSeasonTier;
	}

	public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
		this.highestAchievedSeasonTier = highestAchievedSeasonTier;
	}

	public int getSpell1Id() {
		return spell1Id;
	}

	public void setSpell1Id(int spell1Id) {
		this.spell1Id = spell1Id;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public MatchesParticipantStats getStats() {
		return stats;
	}

	public void setStats(MatchesParticipantStats stats) {
		this.stats = stats;
	}

	public List<MatchesRune> getRunes() {
		return runes;
	}

	public void setRunes(List<MatchesRune> runes) {
		this.runes = runes;
	}

	public MatchesParticipantTimeline getTimeline() {
		return timeline;
	}

	public void setTimeline(MatchesParticipantTimeline timeline) {
		this.timeline = timeline;
	}

	public List<MatchesMastery> getMasteries() {
		return masteries;
	}

	public void setMasteries(List<MatchesMastery> masteries) {
		this.masteries = masteries;
	}
	
	
}
