package net.aurore.datamanager;

import net.aurore.lolservice.entities.Rank;

public interface RankJPA {
	
	public void save();
	
	public Rank getRank(long summonerId);
	
}
