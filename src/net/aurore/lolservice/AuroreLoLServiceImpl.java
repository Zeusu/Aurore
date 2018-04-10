package net.aurore.lolservice;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	
	@Override
	public void testRequest(){		
		try {
			REST_SERVICE.doRequest("https://euw1.api.riotgames.com/lol/status/v3/shard-data");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Summoner summonerByName(String name){
		try{
			REST_SERVICE.addToQueue(SUMMONER_BY_NAME_URL + Encoder.encode(name));
			//if(response.isSuccess()) return MAPPER.readValue(response.getResponseText(), Summoner.class);
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public Summoner summonerBySummonerId(long summonerId){
		try{
			RestServiceResponse response = REST_SERVICE.doRequest(SUMMONER_BY_SUMMONER_ID + summonerId);
			return MAPPER.readValue(response.getResponseText(), Summoner.class);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Rank rankBySummonerId(long summonerId){
		try{
			RestServiceResponse response = REST_SERVICE.doRequest(RANK_BY_SUMMONER_ID_URL + summonerId);
			if(response.isSuccess()){
				Rank[] ranks = MAPPER.readValue(response.getResponseText(), Rank[].class);
				Rank result = null;
				for(Rank r : ranks) if(r.getQueueType().equals(Rank.RANKED_SOLO)){
					result = r;
					result.setSummonerId(summonerId);
				}
				return result;
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Match matchByMatchId(BigInteger matchId) {
		try{
			String response = REST_SERVICE.doRequest(MATCH_BY_MATCH_ID_URL + matchId).getResponseText();
			if(response != null){
				Match m = MAPPER.readValue(response, Match.class);
				m.setMatchId(matchId);
				return m;
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<MatchList> matchListByAccountId(long accountId) {
		List<MatchList> result = new LinkedList<MatchList>();
		try{
			String response = REST_SERVICE.doRequest(MATCHLIST_BY_ACCOUNT_ID + accountId).getResponseText();
			if(response != null){
				MatchList m = MAPPER.readValue(response, MatchList.class);
				result.add(m);
				while(m.getEndIndex() <= m.getTotalGames() - 1){
					response = REST_SERVICE.doRequest(MATCHLIST_BY_ACCOUNT_ID + accountId + "?beginIndex=" + m.getEndIndex()).getResponseText();
					if(response != null){
						m = MAPPER.readValue(response, MatchList.class);
						result.add(m);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Matches matchesByMatchId(BigInteger matchId) {
		try {
			RestServiceResponse response = REST_SERVICE.doRequest(MATCHES_BY_MATCH_ID + matchId);
			if(response.isSuccess()){
				Matches m = MAPPER.readValue(response.getResponseText(), Matches.class);
				m.setMatchId(matchId);
				return m;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
