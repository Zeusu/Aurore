package net.aurore.command;

import net.aurore.lolservice.AuroreLoLService;
import net.aurore.util.TitleTextList;

public interface CommandManager {
	
	public void runCommand(CommandContext context, String identifier);
	
	public TitleTextList getCommands();
	
	public AuroreLoLService getLoLService();
	
	public String getSelfId();
	
}

