package net.aurore.datamanager;


import org.hibernate.Query;
import org.hibernate.Session;

import net.aurore.entities.GuildConfig;


public class GuildConfigJPAImpl implements GuildConfigJPA{

	private static final String GUILD_CONFIG_BY_ID = "FROM GuildConfig WHERE " + GuildConfigJPA.PARAM_ID + " = :" + GuildConfigJPA.PARAM_ID;
	
	private GuildConfig config;
	private Session sess;
	
	
	GuildConfigJPAImpl(GuildConfig config, Session sess){
		this.config = config;
		this.sess = sess;
	}


	@Override
	public void save() {
		GuildConfig c = retrieveByGuildId(config.getGuildId());
		
		if(c != null){
			c.setPrefix(config.getPrefix());
		}else{
			c = config;
		}
		
		sess.beginTransaction();
		sess.saveOrUpdate(c);
		sess.getTransaction().commit();
		sess.clear();
	}


	@Override
	public GuildConfig retrieveByGuildId(long guildId) {
		Query query = sess.createQuery(GUILD_CONFIG_BY_ID);
		query.setParameter(GuildConfigJPA.PARAM_ID, guildId);
		Object o = query.uniqueResult();
		if(o instanceof GuildConfig) return (GuildConfig) o;
		return null;
	}
	
	
}
