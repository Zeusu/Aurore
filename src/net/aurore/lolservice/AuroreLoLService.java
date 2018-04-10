package net.aurore.lolservice;

import java.math.BigInteger;
import java.util.List;

import net.aurore.lolservice.entities.Match;
import net.aurore.lolservice.entities.MatchList;
import net.aurore.lolservice.entities.Matches;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;

public interface AuroreLoLService {
		
	public void testRequest();
	
	public Summoner summonerByName(String name);
	
	public Summoner summonerBySummonerId(long summonerId);
	
	public Rank rankBySummonerId(long summonerId);
	
	public Match matchByMatchId(BigInteger matchId);
	
	public List<MatchList> matchListByAccountId(long accountId);
	
	public Matches matchesByMatchId(BigInteger matchId);
	
}
