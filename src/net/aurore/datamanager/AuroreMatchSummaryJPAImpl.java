package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.SQLGrammarException;

import net.aurore.entities.AuroreMatchSummary;

@SuppressWarnings("unchecked")
public class AuroreMatchSummaryJPAImpl implements AuroreMatchSummaryJPA {

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
		}catch(SQLGrammarException e){
			System.out.println(e.getSQL());
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
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
		return (AuroreMatchSummary) query.uniqueResult();
	}

}
