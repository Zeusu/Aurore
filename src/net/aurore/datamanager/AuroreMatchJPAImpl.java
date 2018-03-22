package net.aurore.datamanager;

import org.hibernate.Session;

import net.aurore.entities.AuroreMatch;

public class AuroreMatchJPAImpl implements AuroreMatchJPA{

	
	private Session sess;
	private AuroreMatch match;
	
	AuroreMatchJPAImpl(AuroreMatch match, Session sess){
		this.match = match;
		this.sess = sess;
	}
	
	@Override
	public void save() {
		sess.beginTransaction();
		sess.save(match);
		sess.getTransaction().commit();
	}

}
