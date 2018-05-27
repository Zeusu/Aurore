package net.aurore.datamanager;

import net.aurore.entities.GuildConfig;

public interface GuildConfigJPA {

	public static final String PARAM_ID = "id";
	
	public void save();
	
	public GuildConfig retrieveByGuildId(long guildId);
	
}
