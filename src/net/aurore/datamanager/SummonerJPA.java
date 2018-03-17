package net.aurore.datamanager;

import net.aurore.lolservice.entities.Summoner;

public interface SummonerJPA {

	public void save();
	
	public void update();
	
	public Summoner retrieveById(long id);
	
	public Summoner retrieveByName(String name);
		
}
