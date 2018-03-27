package net.aurore.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.aurore.lolservice.entities.MatchesTeamStats;

@Entity
@Table(name = "match_team_summary")
public class AuroreTeamSummary {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "aurore_team_id", nullable = false, unique = true)
		BigInteger auroreTeamId;
		
		@ManyToOne(optional = false)
		@JoinColumn(name = "match_id")
		AuroreMatchSummary match;
	
	
		@Column(name = "firstDragon")
		private boolean firstDragon;
		
		@Column(name = "firstInhibitor")
		private boolean firstInhibitor;
		
		@Column(name = "baronKills")
		private int baronKills;
		
		@Column(name = "firstRiftHerald")
		private boolean firstRiftHerald;
		
		@Column(name = "firstBaron")
		private boolean firstBaron;
		
		@Column(name = "riftHeraldKills")
		private int riftHeraldKills;
		
		@Column(name = "firstBlood")
		private boolean firstBlood;
		
		@Column(name = "teamId")
		private int teamId;
		
		@Column(name = "firstTower")
		private boolean firstTower;
		
		@Column(name = "inhibitorKills")
		private int inhibitorKills;
		
		@Column(name = "towerKills")
		private int towerKills;
		
		@Column(name = "win")
		private String win;
		
		@Column(name = "dragonKills")
		private int dragonKills;

		public AuroreTeamSummary(){}
		
		public AuroreTeamSummary(MatchesTeamStats team, AuroreMatchSummary match) {
			this.match = match;
			
			firstDragon = team.isFirstDragon();
			firstInhibitor = team.isFirstInhibitor();
			baronKills = team.getBaronKills();
			firstRiftHerald = team.isFirstRiftHerald();
			firstBaron = team.isFirstBaron();
			riftHeraldKills = team.getRiftHeraldKills();
			firstBlood = team.isFirstBlood();
			inhibitorKills = team.getInhibitorKills();
			towerKills = team.getTowerKills();
			win = team.getWin();
			dragonKills = team.getDragonKills();
		}

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

		public BigInteger getAuroreTeamId() {
			return auroreTeamId;
		}

		public void setAuroreTeamId(BigInteger auroreTeamId) {
			this.auroreTeamId = auroreTeamId;
		}

		public AuroreMatchSummary getMatch() {
			return match;
		}

		public void setMatch(AuroreMatchSummary match) {
			this.match = match;
		}

		
		
}
