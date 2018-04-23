package net.aurore.lolservice;

import java.math.BigInteger;

import net.aurore.entities.Context;
import net.aurore.lolservice.requests.MatchListRequest;
import net.aurore.lolservice.requests.MatchRequest;
import net.aurore.lolservice.requests.MatchesRequest;
import net.aurore.lolservice.requests.RankRequest;
import net.aurore.lolservice.requests.SummonerRequest;
import net.aurore.util.Encoder;

public class AuroreLoLServiceImpl implements AuroreLoLService {

	private static final RestService REST_SERVICE = new RestService();

	@Override
	public void summonerByName(String name, Context<?> c, String key){
		try{
			
			REST_SERVICE.addToQueue(new SummonerRequest(SummonerRequest.SUMMONER_BY_NAME_URL + Encoder.encode(name),c,key));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void summonerBySummonerId(long summonerId, Context<?> c, String key){
		try{
			REST_SERVICE.addToQueue(new SummonerRequest(SummonerRequest.SUMMONER_BY_SUMMONER_ID + summonerId, c, key));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void rankBySummonerId(long summonerId, Context<?> c, String key){
		try{
			REST_SERVICE.addToQueue(new RankRequest(RankRequest.RANK_BY_SUMMONER_ID_URL + summonerId,c,key,summonerId));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void matchByMatchId(BigInteger matchId, Context<?> c, String key) {
		try{
			REST_SERVICE.addToQueue(new MatchRequest(MatchRequest.MATCH_BY_MATCH_ID_URL + matchId, c, key, matchId));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void matchListByAccountId(long accountId, Context<?> c, String key) {
		try{
			REST_SERVICE.addToQueue(new MatchListRequest(MatchListRequest.MATCHLIST_BY_ACCOUNT_ID + accountId, c, key));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void matchListByAccountIdWithStartIndex(long accountId, long startIndex ,Context<?> c, String key) {
		try{
			REST_SERVICE.addToQueue(new MatchListRequest(MatchListRequest.MATCHLIST_BY_ACCOUNT_ID + accountId + "?beginIndex=" + startIndex, c, key));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void matchesByMatchId(BigInteger matchId, Context<?> c, String key) {
		try {
			REST_SERVICE.addToQueue(new MatchesRequest(MatchesRequest.MATCHES_BY_MATCH_ID + matchId, c, key,matchId));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
