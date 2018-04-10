package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;

import net.aurore.entities.MatchListItem;

public interface MatchListItemJPA {

	 public void save();
	 
	 public List<MatchListItem> retrieveBySummonerId(long summonerId);
	
	 public List<MatchListItem> retrieveByMatchId(BigInteger matchId);
	
}
