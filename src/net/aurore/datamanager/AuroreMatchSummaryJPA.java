package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;

import net.aurore.entities.AuroreMatchSummary;

public interface AuroreMatchSummaryJPA {

	public void save();
	
	public List<BigInteger> retrieveMatchList();
	
	public AuroreMatchSummary retrieveByMatchId(BigInteger matchId);
}
