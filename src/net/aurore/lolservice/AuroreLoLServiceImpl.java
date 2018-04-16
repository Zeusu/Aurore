package net.aurore.lolservice;

import java.math.BigInteger;

import net.aurore.entities.Context;
import net.aurore.lolservice.entities.Match;
import net.aurore.lolservice.entities.MatchList;
import net.aurore.lolservice.entities.Matches;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;
import net.aurore.util.Encoder;

public class AuroreLoLServiceImpl implements AuroreLoLService {

	private static final RestService REST_SERVICE = new RestService();
	
	private static final String SUMMONER_BY_NAME_URL = "https://euw1.api.riotgames.com/lol/summoner/v3/summoners/by-name/";
	private static final String SUMMONER_BY_SUMMONER_ID = "https://euw1.api.riotgames.com/lol/summoner/v3/summoners/";
	private static final String RANK_BY_SUMMONER_ID_URL = "https://euw1.api.riotgames.com/lol/league/v3/positions/by-summoner/";
	private static final String MATCH_BY_MATCH_ID_URL = "https://euw1.api.riotgames.com/lol/match/v3/timelines/by-match/";
	private static final String MATCHLIST_BY_ACCOUNT_ID = "https://euw1.api.riotgames.com/lol/match/v3/matchlists/by-account/";
	private static final String MATCHES_BY_MATCH_ID = "https://euw1.api.riotgames.com/lol/match/v3/matches/";
	

	@Override
	public void testRequest(){		
		try {
			REST_SERVICE.doRequest("https://euw1.api.riotgames.com/lol/status/v3/shard-data");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void summonerByName(String name, Context<?> c, String key){
		try{
			REST_SERVICE.addToQueue(SUMMONER_BY_NAME_URL + Encoder.encode(name),c,key, Summoner.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void summonerBySummonerId(long summonerId, Context<?> c, String key){
		try{
			REST_SERVICE.addToQueue(SUMMONER_BY_SUMMONER_ID + summonerId, c, key, Summoner.class);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void rankBySummonerId(long summonerId, Context<?> c, String key){
		try{
			REST_SERVICE.addToQueue(RANK_BY_SUMMONER_ID_URL + summonerId, c, key, Rank[].class);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void matchByMatchId(BigInteger matchId, Context<?> c, String key) {
		try{
			REST_SERVICE.addToQueue(MATCH_BY_MATCH_ID_URL + matchId, c, key, Match.class);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void matchListByAccountId(long accountId, Context<?> c, String key) {
		try{
			REST_SERVICE.addToQueue(MATCHLIST_BY_ACCOUNT_ID + accountId, c, key, MatchList.class);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void matchListByAccountIdWithStartIndex(long accountId, long startIndex ,Context<?> c, String key) {
		try{
			REST_SERVICE.addToQueue(MATCHLIST_BY_ACCOUNT_ID + accountId + "?beginIndex=" + startIndex, c, key, MatchList.class);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void matchesByMatchId(BigInteger matchId, Context<?> c, String key) {
		try {
			REST_SERVICE.addToQueue(MATCHES_BY_MATCH_ID + matchId, c, key, Matches.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
