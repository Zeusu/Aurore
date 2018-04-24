package net.aurore.datamanager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import net.aurore.entities.AuroreParticipantSummary;

public class AuroreParticipantSummaryJPAImpl implements AuroreParticipantSummaryJPA{
	
	private static final String PARTICIPANT_BY_SUMMONER_ID = "FROM AuroreParticipantSummary WHERE " + SummonerJPA.PARAM_SUMMONERID + " = :" + SummonerJPA.PARAM_SUMMONERID;

	
	Session sess;
	
	
	AuroreParticipantSummaryJPAImpl(Session s) {
		sess = s;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AuroreParticipantSummary> retrieveSummariesBySummonerId(long summonerId) {
		Query query = sess.createQuery(PARTICIPANT_BY_SUMMONER_ID);
		query.setParameter(SummonerJPA.PARAM_SUMMONERID, summonerId);
		List<AuroreParticipantSummary> result = (List<AuroreParticipantSummary>) query.list();
		return result;
	}
	
	
	
	
	
}
