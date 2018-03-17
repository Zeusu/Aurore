package net.aurore.lolservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MiniSeries {
	
	@JsonIgnore
	private long id;

	private int target = 0;
	
	private int wins = 0;
	
	private int losses = 0;
	
	private String progress = "";

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
