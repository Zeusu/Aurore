package net.aurore.datamanager;

import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;

public interface DataManager {

	
	
	public boolean saveSummoner(Summoner s);
	
	public Summoner retrieveSummonerById(long id);
	
	public Summoner retrieveSummonerByName(String name);
	
	
	
	public void saveRank(Rank r);
}
