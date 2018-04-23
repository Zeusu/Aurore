package net.aurore.lolservice.requests;

import java.io.IOException;

import net.aurore.entities.Context;
import net.aurore.lolservice.RestServiceRequest;
import net.aurore.lolservice.entities.AuroreLoLEntity;
import net.aurore.lolservice.entities.Rank;

public class RankRequest extends RestServiceRequest {
	
	public static final String RANK_BY_SUMMONER_ID_URL = "https://euw1.api.riotgames.com/lol/league/v3/positions/by-summoner/";

	private final long summonerId;
	
	public RankRequest(String url, Context<?> c, String k,long summonerId) {
		super(url, c, k);
		this.summonerId = summonerId;
	}

	@Override
	public AuroreLoLEntity deserializeRequestObject(String responseText) {
		System.out.println("didier");
		try {
			
			Rank[] rks = MAPPER.readValue(responseText, Rank[].class);
			for(Rank r : rks){
				if(r.getQueueType().equals(Rank.RANKED_SOLO)){
					r.setSummonerId(summonerId);
					return r;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
