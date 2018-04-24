package net.aurore.datamanager;

import net.aurore.lolservice.entities.Summoner;

public interface SummonerJPA {

	public static final String PARAM_SUMMONER_ID = "summoner_id";
	public static final String PARAM_SUMMONERID = "summonerId";
	
	public void save();
	
	public void update();
	
	public Summoner retrieveById(long id);
	
	public Summoner retrieveByName(String name);
		
}
