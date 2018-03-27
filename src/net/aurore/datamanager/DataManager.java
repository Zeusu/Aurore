package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;
import net.aurore.entities.AuroreMatchSummary;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;

public interface DataManager {

	
	
	public boolean saveSummoner(Summoner s);
	
	public Summoner retrieveSummonerById(long id);
	
	public Summoner retrieveSummonerByName(String name);
	
	public void saveRank(Rank r);
	
	public void saveAuroreMatchSummary(AuroreMatchSummary match);
	
	public List<BigInteger> retrieveMatchList(); 
}
