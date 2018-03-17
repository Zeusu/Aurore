package net.aurore.datamanager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import net.aurore.lolservice.entities.Summoner;

@SuppressWarnings("unchecked")
public class SummonerJPAImpl implements SummonerJPA {

	private static final String HQL_PARAM_ID = "id";
	private static final String HQL_PARAM_ACCOUNT_ID = "aId";
	private static final String HQL_PARAM_REVISION_DATE = "rDate";
	private static final String HQL_PARAM_PROFILE_ICON_ID = "pIId";
	private static final String HQL_PARAM_SUMMONER_LEVEL = "sLvl";
	private static final String HQL_PARAM_NAME = "name";
	
	private static final String HQL_SELECT_BY_ID = "FROM Summoner WHERE id = :" + HQL_PARAM_ID;
	private static final String HQL_SELECT_BY_NAME = "FROM Summoner WHERE name = :" + HQL_PARAM_NAME; 
	private static final String HQL_FULL_UPDATE_BY_ID = "UPDATE Summoner SET accountId = :" + HQL_PARAM_ACCOUNT_ID
														+ " SET revisionDate = :" + HQL_PARAM_REVISION_DATE
														+ " SET profileIconId = :" + HQL_PARAM_PROFILE_ICON_ID
														+ " SET summonerLevel = :" + HQL_PARAM_SUMMONER_LEVEL
														+ " SET name = :" + HQL_PARAM_NAME
														+ " WHERE id = :" + HQL_PARAM_ID;
	

	
	private Summoner sum;
	private Session sess;
	
	
	SummonerJPAImpl(Summoner sum, Session sess){
		this.sum = sum;
		this.sess = sess;
	}
	
	
	@Override
	public void save() {
		sess.beginTransaction();
		sess.save(sum);
		sess.getTransaction().commit();
	}

	@Override
	public void update() {
		Query<?> query = sess.createQuery(HQL_FULL_UPDATE_BY_ID);
		query.setParameter(HQL_PARAM_ID, sum.getId());
		query.setParameter(HQL_PARAM_ACCOUNT_ID, sum.getAccountId());
		query.setParameter(HQL_PARAM_REVISION_DATE, sum.getRevisionDate());
		query.setParameter(HQL_PARAM_PROFILE_ICON_ID, sum.getProfileIconId());
		query.setParameter(HQL_PARAM_SUMMONER_LEVEL, sum.getSummonerLevel());
		query.setParameter(HQL_PARAM_NAME, sum.getName());
		query.executeUpdate();

	}

	@Override
	public Summoner retrieveById(long id) {
		Query<?> query = sess.createQuery(HQL_SELECT_BY_ID);
		query.setParameter(HQL_PARAM_ID, id);
		List<Summoner> l = (List<Summoner>) query.list();
		if(l.size() == 0) return null;
		return l.get(0);
	}


	@Override
	public Summoner retrieveByName(String name) {
		Query<?> query = sess.createQuery(HQL_SELECT_BY_NAME);
		query.setParameter(HQL_PARAM_NAME, name);
		List<Summoner> l = (List<Summoner>) query.list();
		if(l.size() == 0) return null;
		return l.get(0);
	}

}
