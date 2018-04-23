package net.aurore.lolservice.requests;

import java.io.IOException;

import net.aurore.entities.Context;
import net.aurore.lolservice.RestServiceRequest;
import net.aurore.lolservice.entities.AuroreLoLEntity;
import net.aurore.lolservice.entities.Summoner;

public class SummonerRequest extends RestServiceRequest{
	
	public static final String SUMMONER_BY_NAME_URL = "https://euw1.api.riotgames.com/lol/summoner/v3/summoners/by-name/";
	public static final String SUMMONER_BY_SUMMONER_ID = "https://euw1.api.riotgames.com/lol/summoner/v3/summoners/";
	
	public SummonerRequest(String url, Context<?> c, String k) {
		super(url, c, k);
	}
	
	@Override
	public AuroreLoLEntity deserializeRequestObject(String responseText) {
		try {
			return (AuroreLoLEntity) MAPPER.readValue(responseText, Summoner.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
