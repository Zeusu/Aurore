package net.aurore.lolservice.requests;

import java.io.IOException;

import net.aurore.entities.Context;
import net.aurore.lolservice.RestServiceRequest;
import net.aurore.lolservice.entities.AuroreLoLEntity;
import net.aurore.lolservice.entities.MatchList;

public class MatchListRequest extends RestServiceRequest {

	public static final String MATCHLIST_BY_ACCOUNT_ID = "https://euw1.api.riotgames.com/lol/match/v3/matchlists/by-account/";
	
	
	public MatchListRequest(String url, Context<?> c, String k) {
		super(url, c, k);
	}

	@Override
	public AuroreLoLEntity deserializeRequestObject(String responseText) {
		try {
			return MAPPER.readValue(responseText, MatchList.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}

}
