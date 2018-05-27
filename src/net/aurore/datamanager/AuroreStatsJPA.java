package net.aurore.datamanager;

import net.aurore.entities.AuroreStats;

public interface AuroreStatsJPA {

	public void save();
	
	public AuroreStats retrieve(long summonerId);
	
	public AuroreStats retrieveGlobalStats();
	
}
