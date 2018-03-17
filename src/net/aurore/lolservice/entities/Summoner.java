package net.aurore.lolservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Summoner {

	@Id
	private long id;
	
	private int profileIconId;
	
	private String name;
	
	private long summonerLevel;
	
	private long revisionDate;
	
	private long accountId;

	
	
	public Summoner(){
		super();
	}
	
	public Summoner(int profileIconId, String name, long summonerLevel, long revisionDate, long id, long accountId) {
		super();
		this.profileIconId = profileIconId;
		this.name = name;
		this.summonerLevel = summonerLevel;
		this.revisionDate = revisionDate;
		this.id = id;
		this.accountId = accountId;
	}

	
	
	
	public int getProfileIconId() {
		return profileIconId;
	}

	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSummonerLevel() {
		return summonerLevel;
	}

	public void setSummonerLevel(long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}

	public long getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(long revisionDate) {
		this.revisionDate = revisionDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
}
