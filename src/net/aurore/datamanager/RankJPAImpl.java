package net.aurore.datamanager;

import org.hibernate.Query;
import org.hibernate.Session;

import net.aurore.lolservice.entities.Rank;

public class RankJPAImpl implements RankJPA {

	
	private static final String PARAM_SUMMONER_ID = "summonerId";
	
	private static final String RANK_BY_SUMMONER_ID = "FROM Rank WHERE " + PARAM_SUMMONER_ID + " = :" + PARAM_SUMMONER_ID;
	
	
	private Rank rank;
	private Session sess;


	RankJPAImpl(Rank rank, Session sess){
		this.rank = rank;
		this.sess = sess;
	}
	
	
	@Override
	public void save() {
		sess.beginTransaction();
		sess.save(rank);
		sess.getTransaction().commit();
		sess.clear();
	}


	@Override
	public Rank getRank(long summonerId) {
		Query query = sess.createQuery(RANK_BY_SUMMONER_ID);
		query.setParameter(PARAM_SUMMONER_ID, summonerId);
		Object o = query.uniqueResult();
		if(o == null) return null;
		if(o instanceof Rank){
			return (Rank) o;
		}
		return null;
	}

}
