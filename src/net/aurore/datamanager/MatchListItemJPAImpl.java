package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import net.aurore.entities.MatchListItem;

@SuppressWarnings("unchecked")
public class MatchListItemJPAImpl implements MatchListItemJPA {
	
	private static final String PARAM_SUMMONER_ID = "summonerId";
	private static final String PARAM_MATCH_ID = "matchId";
	
	private static final String SELECT_ITEMS = "FROM MatchListItem";
	private static final String SELECT_ITEMS_BY_SUMMONER_ID = SELECT_ITEMS + " WHERE " + PARAM_SUMMONER_ID + " = :" + PARAM_SUMMONER_ID;
	private static final String SELECT_ITEMS_BY_MATCH_ID = SELECT_ITEMS + " WHERE" + PARAM_MATCH_ID + " = :" + PARAM_MATCH_ID;

	private Session sess;
	private MatchListItem item;
	
	MatchListItemJPAImpl(MatchListItem item, Session sess){
		this.sess = sess;
		this.item = item;
	}
	
	
	@Override
	public void save() {
		try{
			sess.beginTransaction();
			sess.save(item);
			sess.getTransaction().commit();
			sess.clear();
		}catch(ConstraintViolationException e){
			System.out.println(e.getConstraintName());
			System.out.println(e.getSQLState());
			System.out.println(e.getSQLException());
			System.out.println(e);
			e.printStackTrace();
		}
	}

	
	@Override
	public List<MatchListItem> retrieveBySummonerId(long summonerId) {
		Query query = sess.createQuery(SELECT_ITEMS_BY_SUMMONER_ID);
		query.setParameter(PARAM_SUMMONER_ID, summonerId);
		return query.list();
	}

	@Override
	public List<MatchListItem> retrieveByMatchId(BigInteger matchId) {
		Query query = sess.createQuery(SELECT_ITEMS_BY_MATCH_ID);
		query.setParameter(PARAM_MATCH_ID, matchId);
		return query.list();
	}

}
