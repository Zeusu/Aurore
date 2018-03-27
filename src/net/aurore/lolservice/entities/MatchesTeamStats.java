package net.aurore.lolservice.entities;

import java.util.ArrayList;
import java.util.List;

public class MatchesTeamStats {

	private boolean firstDragon;
	
	private boolean firstInhibitor;
	
	private int baronKills;
	
	private boolean firstRiftHerald;
	
	private boolean firstBaron;
	
	private int riftHeraldKills;
	
	private boolean firstBlood;
	
	private int teamId;
	
	private boolean firstTower;
	
	private int vilemawKills;
	
	private int inhibitorKills;
	
	private int towerKills;
	
	private int dominionVictoryScore;
	
	private String win;
	
	private int dragonKills;
	
	private List<MatchesTeamBan> bans = new ArrayList<MatchesTeamBan>();

	public boolean isFirstDragon() {
		return firstDragon;
	}

	public void setFirstDragon(boolean firstDragon) {
		this.firstDragon = firstDragon;
	}

	public boolean isFirstInhibitor() {
		return firstInhibitor;
	}

	public void setFirstInhibitor(boolean firstInhibitor) {
		this.firstInhibitor = firstInhibitor;
	}

	public int getBaronKills() {
		return baronKills;
	}

	public void setBaronKills(int baronKills) {
		this.baronKills = baronKills;
	}

	public boolean isFirstRiftHerald() {
		return firstRiftHerald;
	}

	public void setFirstRiftHerald(boolean firstRiftHerald) {
		this.firstRiftHerald = firstRiftHerald;
	}

	public boolean isFirstBaron() {
		return firstBaron;
	}

	public void setFirstBaron(boolean firstBaron) {
		this.firstBaron = firstBaron;
	}

	public int getRiftHeraldKills() {
		return riftHeraldKills;
	}

	public void setRiftHeraldKills(int riftHeraldKills) {
		this.riftHeraldKills = riftHeraldKills;
	}

	public boolean isFirstBlood() {
		return firstBlood;
	}

	public void setFirstBlood(boolean firstBlood) {
		this.firstBlood = firstBlood;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public boolean isFirstTower() {
		return firstTower;
	}

	public void setFirstTower(boolean firstTower) {
		this.firstTower = firstTower;
	}

	public int getVilemawKills() {
		return vilemawKills;
	}

	public void setVilemawKills(int vilemawKills) {
		this.vilemawKills = vilemawKills;
	}

	public int getInhibitorKills() {
		return inhibitorKills;
	}

	public void setInhibitorKills(int inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}

	public int getTowerKills() {
		return towerKills;
	}

	public void setTowerKills(int towerKills) {
		this.towerKills = towerKills;
	}

	public int getDominionVictoryScore() {
		return dominionVictoryScore;
	}

	public void setDominionVictoryScore(int dominionVictoryScore) {
		this.dominionVictoryScore = dominionVictoryScore;
	}

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}

	public int getDragonKills() {
		return dragonKills;
	}

	public void setDragonKills(int dragonKills) {
		this.dragonKills = dragonKills;
	}

	public List<MatchesTeamBan> getBans() {
		return bans;
	}

	public void setBans(List<MatchesTeamBan> bans) {
		this.bans = bans;
	}
	
	
}
