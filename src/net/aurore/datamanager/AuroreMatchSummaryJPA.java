package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;

public interface AuroreMatchSummaryJPA {

	public void save();
	
	public List<BigInteger> retrieveMatchList();
	
}
