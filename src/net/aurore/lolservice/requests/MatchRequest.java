package net.aurore.lolservice.requests;

import java.io.IOException;
import java.math.BigInteger;

import net.aurore.entities.Context;
import net.aurore.lolservice.RestServiceRequest;
import net.aurore.lolservice.entities.AuroreLoLEntity;
import net.aurore.lolservice.entities.Match;

public class MatchRequest extends RestServiceRequest {

	public static final String MATCH_BY_MATCH_ID_URL = "https://euw1.api.riotgames.com/lol/match/v3/timelines/by-match/";
	
	private final BigInteger matchId;
	
	public MatchRequest(String url, Context<?> c, String k, BigInteger matchId) {
		super(url, c, k);
		this.matchId = matchId;
	}

	@Override
	public AuroreLoLEntity deserializeRequestObject(String responseText) {
		try {
			Match m = MAPPER.readValue(responseText, Match.class);
			m.setMatchId(matchId);
			return m;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
