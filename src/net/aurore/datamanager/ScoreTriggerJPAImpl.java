package net.aurore.datamanager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import net.aurore.entities.ScoreTrigger;

public class ScoreTriggerJPAImpl implements ScoreTriggerJPA {
	
	private static final String SCORE_TRIGGER_BY_GUILD_ID = "FROM ScoreTrigger WHERE " + ScoreTriggerJPA.PARAM_GUILD_ID + " = :" + ScoreTriggerJPA.PARAM_GUILD_ID;

	private ScoreTrigger s;
	private Session sess;
	
	
	ScoreTriggerJPAImpl(ScoreTrigger s, Session sess){
		this.s = s;
		this.sess = sess;
	}
	
	
	@Override
	public void save() {
		sess.beginTransaction();
		sess.saveOrUpdate(s);
		sess.getTransaction().commit();
		sess.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScoreTrigger> retrieveByGuildId(long guildId) {
		Query q = sess.createQuery(SCORE_TRIGGER_BY_GUILD_ID);
		q.setParameter(ScoreTriggerJPA.PARAM_GUILD_ID, guildId);
		return q.list();
	}

}
