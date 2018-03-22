package net.aurore.lolservice.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "miniseries")
public class MiniSeries {
	
	@JsonIgnore @Column(name = "id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "target")
	private int target = 0;
	
	@Column(name = "wins")
	private int wins = 0;
	
	@Column(name = "losses")
	private int losses = 0;
	
	@Column(name = "progress")
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
