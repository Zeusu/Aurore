package net.aurore.lolservice;

import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.aurore.lolservice.entities.Match;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;
import net.aurore.util.Encoder;

public class AuroreLoLServiceImpl implements AuroreLoLService {

	private static final RestService REST_SERVICE = new RestService();
	
	private static final String SUMMONER_BY_NAME_URL = "https://euw1.api.riotgames.com/lol/summoner/v3/summoners/by-name/";
	private static final String RANK_BY_SUMMONER_ID_URL = "https://euw1.api.riotgames.com/lol/league/v3/positions/by-summoner/";
	private static final String MATCH_BY_MATCH_ID_URL = "https://euw1.api.riotgames.com/lol/match/v3/timelines/by-match/";
	
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
			String response = REST_SERVICE.doRequest(SUMMONER_BY_NAME_URL + Encoder.encode(name));
			return MAPPER.readValue(response, Summoner.class);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public Rank rankBySummonerId(long summonerId){
		try{
			String response = REST_SERVICE.doRequest(RANK_BY_SUMMONER_ID_URL + summonerId);
			Rank[] ranks = MAPPER.readValue(response, Rank[].class);
			Rank result = null;
			for(Rank r : ranks) if(r.getQueueType().equals(Rank.RANKED_SOLO)){
				result = r;
				result.setSummonerId(summonerId);
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Match matchByMatchId(BigInteger matchId) {
		try{
			String response = REST_SERVICE.doRequest(MATCH_BY_MATCH_ID_URL + matchId);
			Match m = MAPPER.readValue(response, Match.class);
			m.setMatchId(matchId);
			return m;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
