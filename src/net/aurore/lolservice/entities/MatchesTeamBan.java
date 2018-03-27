package net.aurore.lolservice.entities;

public class MatchesTeamBan {

	private int pickTurn;
	
	private int championId;

	
	public int getPickTurn() {
		return pickTurn;
	}

	public void setPickTurn(int pickTurn) {
		this.pickTurn = pickTurn;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}
}
