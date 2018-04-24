package net.aurore.datamanager;

import org.hibernate.Session;
import org.hibernate.Query;

import net.aurore.entities.AuroreStats;

public class AuroreStatsJPAImpl implements AuroreStatsJPA {

	private static final String PARAM_SUMMONER_ID = "summoner_id";
	private static final String STATS_BY_SUMMONER_ID = "FROM AuroreStats WHERE " + PARAM_SUMMONER_ID + " = :" + PARAM_SUMMONER_ID;
	
	
	
	
	private Session sess;
	private AuroreStats stats;
	
	AuroreStatsJPAImpl(AuroreStats s, Session sess){
		stats = s;
		this.sess = sess;
	}
	
	
	
	
	@Override
	public void save() {
		try{
			sess.beginTransaction();
			AuroreStats s = null;
			if(stats.getS() != null){
				s = retrieve(stats.getS().getId());
			}
			if(s != null){
				s.setAverageAssits(stats.getAverageAssits());
				s.setAverageDeath(stats.getAverageDeath());
				s.setAverageKill(stats.getAverageKill());
				s.setKda(stats.getKda());
				sess.update(s);
			}else{
				sess.save(stats);
			}
			sess.getTransaction().commit();
			sess.clear();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public AuroreStats retrieve(long summonerId) {
		Query query = sess.createQuery(STATS_BY_SUMMONER_ID);
		query.setParameter(PARAM_SUMMONER_ID, summonerId);
		Object o  = query.uniqueResult();
		if(o instanceof AuroreStats)
			return (AuroreStats) o;
		return null;
	}

}
