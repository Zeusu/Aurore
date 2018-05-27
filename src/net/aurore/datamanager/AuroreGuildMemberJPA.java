package net.aurore.datamanager;

import java.util.List;

import net.aurore.entities.AuroreGuildMember;
import net.aurore.entities.AuroreGuildMemberId;

public interface AuroreGuildMemberJPA {

	public static final String PARAM_USER_ID = "user_id";
	public static final String PARA_GUILD_ID = "guild_id";
	
	public void save();
	
	public AuroreGuildMember retrieveById(AuroreGuildMemberId id);
	
	public List<AuroreGuildMember> retrieveByGuildId(long id);
	
}
