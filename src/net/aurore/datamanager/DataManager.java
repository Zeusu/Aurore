package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;
import net.aurore.entities.AuroreMatchSummary;
import net.aurore.entities.MatchListItem;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;

public interface DataManager {

	public boolean saveSummoner(Summoner s);
	
	public Summoner retrieveSummonerById(long id);
	
	public Summoner retrieveSummonerByName(String name);
	
	public void saveRank(Rank r);
	
	public Rank retrieveRankBySummonerId(long summonerId);
	
	public void saveAuroreMatchSummary(AuroreMatchSummary match);
	
	public AuroreMatchSummary retrieveMatchByMatchId(BigInteger matchId);
	
	public List<BigInteger> retrieveMatchList(); 
	
	public void saveMatchListItem(MatchListItem item);
	
	public List<MatchListItem> retrieveItemsBySummonerId(long summonerId);
	
	public List<MatchListItem> retrieveItemsByMatchId(BigInteger matchId);
}
