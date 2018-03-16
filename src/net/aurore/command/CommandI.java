package net.aurore.command;

import java.util.List;

import net.aurore.command.CommandContext;
import net.dv8tion.jda.core.entities.Member;

public interface CommandI {
	
	public void onInvoke(CommandContext context, String[] args,List <Member> mentioned);
		
	public String help();
	
	public String getCatHelp();
}
