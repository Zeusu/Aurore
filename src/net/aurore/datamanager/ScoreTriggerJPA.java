package net.aurore.datamanager;

import java.util.List;

import net.aurore.entities.ScoreTrigger;

public interface ScoreTriggerJPA {

	public String PARAM_GUILD_ID = "guild_id";
	
	public void save();
	
	public List<ScoreTrigger> retrieveByGuildId(long guildId);
	
}
