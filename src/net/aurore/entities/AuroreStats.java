package net.aurore.entities;

import javax.persistence.*;

import net.aurore.lolservice.entities.Summoner;

@Entity
@Table(name = "stats")
public class AuroreStats {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name = "summoner_id", unique = true)
	private Summoner s;
	
	@Column(name = "kda")
	private double kda;
	
	@Column(name = "average_kill")
	private double averageKill;
	
	@Column(name = "average_death")
	private double averageDeath;
	
	@Column(name = "average_assists")
	private double averageAssits;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Summoner getS() {
		return s;
	}

	public void setS(Summoner s) {
		this.s = s;
	}

	public double getKda() {
		return kda;
	}

	public void setKda(double kda) {
		this.kda = kda;
	}

	public double getAverageKill() {
		return averageKill;
	}

	public void setAverageKill(double averageKill) {
		this.averageKill = averageKill;
	}

	public double getAverageDeath() {
		return averageDeath;
	}

	public void setAverageDeath(double averageDeath) {
		this.averageDeath = averageDeath;
	}

	public double getAverageAssits() {
		return averageAssits;
	}

	public void setAverageAssits(double averageAssits) {
		this.averageAssits = averageAssits;
	}
	
	
}
