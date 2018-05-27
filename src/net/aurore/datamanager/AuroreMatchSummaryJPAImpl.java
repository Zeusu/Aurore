package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.aurore.entities.AuroreMatchSummary;

@SuppressWarnings("unchecked")
public class AuroreMatchSummaryJPAImpl implements AuroreMatchSummaryJPA {
	
	private static Logger m_logger = LoggerFactory.getLogger(AuroreMatchSummaryJPAImpl.class);

	private static final String HQL_PARAM_MATCH_ID = "matchId";
	
	private static final String HQL_SELECT_LIST_MATCHES = "SELECT " + HQL_PARAM_MATCH_ID + " FROM AuroreMatchSummary";
	private static final String SELECT_MATCHES = "FROM AuroreMatchSummary";
	private static final String SELECT_MATCH_BY_MATCH_ID = SELECT_MATCHES + " WHERE " + HQL_PARAM_MATCH_ID + " = :" + HQL_PARAM_MATCH_ID;

	private Session sess;
	private AuroreMatchSummary match;
	
	AuroreMatchSummaryJPAImpl(AuroreMatchSummary match, Session sess){
		this.match = match;
		this.sess = sess;
	}
	@Override
	public void save() {
		try{
			sess.beginTransaction();
			sess.save(match);
			sess.getTransaction().commit();
			sess.clear();
		}catch(Exception e){
			m_logger.error("Failed to store match summary",e);
		}
	}

	
	@Override
	public List<BigInteger> retrieveMatchList() {
		Query query = sess.createQuery(HQL_SELECT_LIST_MATCHES);
		return (List<BigInteger>) query.list();
	}
	
	@Override
	public AuroreMatchSummary retrieveByMatchId(BigInteger matchId) {
		Query query = sess.createQuery(SELECT_MATCH_BY_MATCH_ID);
		query.setParameter(HQL_PARAM_MATCH_ID, matchId);
		Object o = query.uniqueResult();
		if(o instanceof AuroreMatchSummary) return (AuroreMatchSummary) o;
		return null;
	}

}
