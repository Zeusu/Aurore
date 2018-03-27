package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import net.aurore.entities.AuroreMatchSummary;

public class AuroreMatchSummaryJPAImpl implements AuroreMatchSummaryJPA {

	private static final String HQL_PARAM_MATCH_ID = "matchId";
	
	
	private static final String HQL_SELECT_LIST_MATCHES = "SELECT " + HQL_PARAM_MATCH_ID + " FROM AuroreMatchSummary";

	private Session sess;
	private AuroreMatchSummary match;
	
	AuroreMatchSummaryJPAImpl(AuroreMatchSummary match, Session sess){
		this.match = match;
		this.sess = sess;
	}
	@Override
	public void save() {
		sess.beginTransaction();
		sess.save(match);
		sess.getTransaction().commit();
		sess.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BigInteger> retrieveMatchList() {
		Query query = sess.createQuery(HQL_SELECT_LIST_MATCHES);
		try {
			return (List<BigInteger>) query.list();
		}catch(Exception e){
			return null;
		}
	}

}
