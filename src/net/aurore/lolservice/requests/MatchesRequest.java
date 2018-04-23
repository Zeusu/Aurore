package net.aurore.lolservice.requests;

import java.io.IOException;
import java.math.BigInteger;

import net.aurore.entities.Context;
import net.aurore.lolservice.RestServiceRequest;
import net.aurore.lolservice.entities.AuroreLoLEntity;
import net.aurore.lolservice.entities.Matches;

public class MatchesRequest extends RestServiceRequest{

	public static final String MATCHES_BY_MATCH_ID = "https://euw1.api.riotgames.com/lol/match/v3/matches/";
	
	private final BigInteger matchId;
	
	public MatchesRequest(String url, Context<?> c, String k, BigInteger matchId) {
		super(url, c, k);
		this.matchId = matchId;
	}

	@Override
	public AuroreLoLEntity deserializeRequestObject(String responseText) {
		try {
			Matches m = MAPPER.readValue(responseText, Matches.class);
			m.setMatchId(matchId);
			return m;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
