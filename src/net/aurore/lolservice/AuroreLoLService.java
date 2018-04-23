package net.aurore.lolservice;

import java.math.BigInteger;

import net.aurore.entities.Context;

public interface AuroreLoLService {
		
	public void summonerByName(String name, Context<?> c, String key);
	
	public void summonerBySummonerId(long summonerId, Context<?> c, String key);
	
	public void rankBySummonerId(long summonerId, Context<?> c, String key);
	
	public void matchByMatchId(BigInteger matchId, Context<?> c, String key);
	
	public void matchListByAccountId(long accountId, Context<?> c, String key);
	
	public void matchListByAccountIdWithStartIndex(long accountId, long startIndex ,Context<?> c, String key);
	
	public void matchesByMatchId(BigInteger matchId, Context<?> c, String key);
	
}
