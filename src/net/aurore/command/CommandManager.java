package net.aurore.command;

import net.aurore.datamanager.DataManager;
import net.aurore.entities.GuildConfig;
import net.aurore.lolservice.AuroreLoLService;
import net.aurore.util.TitleTextList;

public interface CommandManager {
	
	public void runCommand(CommandContext context, String identifier, GuildConfig c);
	
	public TitleTextList getCommands();
	
	public AuroreLoLService getLoLService();
	
	public DataManager getDM();
	
	public String getSelfId();
	
}


