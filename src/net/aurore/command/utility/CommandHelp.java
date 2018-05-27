package net.aurore.command.utility;

import java.util.List;

import net.aurore.command.AbstractCommandImpl;
import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.util.ConfigManager;
import net.aurore.util.TitleTextList;
import net.dv8tion.jda.core.entities.Member;
import net.aurore.core.Config;

@Command(value = "help",local = false)
public class CommandHelp extends AbstractCommandImpl {
	


	private static final String TITLE = "" + new StringBuilder().appendCodePoint(0x1F6C8).toString() +  " | Help: Liste des commandes";
	
	private static final String DESCRIPTION;
	
	static{
		DESCRIPTION = "Pour plus de détails sur une commande: `" + ((Config) ConfigManager.getConfig(Config.KEY)).getPrefix() + "help [COMMANDE]`.";
	}
	
	public CommandHelp(CommandManagerImpl manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onInvoke(CommandContext context, String[] args, List<Member> mentioned) {
		if(isOk(context,args,mentioned)){
			TitleTextList commands = this.getCommandManager().getCommands();
			commands.sortByKey();
			String result = "**" + TITLE + "**" + "\n" + DESCRIPTION + "\n";
			String lastIndex = "";
			for(String[] strs : commands){
				if(!strs[0].equals(lastIndex)){
					result += ("\n" + "**" + strs[0] + ":** ");
					lastIndex = strs[0];
				}
				result += ("`" + strs[1] + "` ");
			}
			this.sendEmbed(context.getChannel(), result);
		}
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return true;
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.UTILITY.toString();
	}

}
