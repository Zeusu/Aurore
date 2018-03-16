package net.aurore.lolservice;

import java.math.BigInteger;

import net.aurore.lolservice.entities.Match;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;

public interface AuroreLoLService {
		
	public void testRequest();
	
	public Summoner summonerByName(String name);
	
	public Rank rankBySummonerId(long summonerId);
	
	public Match matchByMatchId(BigInteger matchId);
	
}
