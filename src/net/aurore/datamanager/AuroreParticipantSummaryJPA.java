package net.aurore.datamanager;

import java.util.List;

import net.aurore.entities.AuroreParticipantSummary;

public interface AuroreParticipantSummaryJPA {

	public List<AuroreParticipantSummary> retrieveSummariesBySummonerId(long summonerId);
	
}
