package net.aurore.datamanager;

import org.hibernate.Session;

import net.aurore.lolservice.entities.Rank;

public class RankJPAImpl implements RankJPA {

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

}
