package net.aurore.datamanager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import net.aurore.entities.AuroreGuildMember;
import net.aurore.entities.AuroreGuildMemberId;

public class AuroreGuildMemberJPAImpl implements AuroreGuildMemberJPA {
	
	private static final String MEMBER_BY_ID = "FROM AuroreGuildMember WHERE " + AuroreGuildMemberJPA.PARAM_USER_ID + " = :" + AuroreGuildMemberJPA.PARAM_USER_ID + 
												" AND " + AuroreGuildMemberJPA.PARA_GUILD_ID + " = :" + AuroreGuildMemberJPA.PARA_GUILD_ID;
	private static final String MEMBERS_BY_GUILD_ID = "FROM AuroreGuildMember WHERE " + AuroreGuildMemberJPA.PARA_GUILD_ID + " = :" + AuroreGuildMemberJPA.PARA_GUILD_ID + " ORDER BY score DESC";

	private Session sess;
	private AuroreGuildMember m;
	
	AuroreGuildMemberJPAImpl(AuroreGuildMember m, Session sess){
		this.m = m;
		this.sess = sess;
	}
	
	@Override
	public void save() {
		AuroreGuildMember member = retrieveById(m.getId());
		if(member == null) member = m;
		else member.setScore(m.getScore());
		sess.beginTransaction();
		sess.saveOrUpdate(member);
		sess.getTransaction().commit();
		sess.clear();
	}

	@Override
	public AuroreGuildMember retrieveById(AuroreGuildMemberId id) {
		Query q = sess.createQuery(MEMBER_BY_ID);
		q.setParameter(AuroreGuildMemberJPA.PARAM_USER_ID, id.getId());
		q.setParameter(AuroreGuildMemberJPA.PARA_GUILD_ID, id.getGuildId());
		Object o = q.uniqueResult();
		if(o instanceof AuroreGuildMember) return (AuroreGuildMember) o;
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuroreGuildMember> retrieveByGuildId(long id) {
		Query q = sess.createQuery(MEMBERS_BY_GUILD_ID);
		q.setParameter(AuroreGuildMemberJPA.PARA_GUILD_ID, id);
		return q.list();
	}

}
