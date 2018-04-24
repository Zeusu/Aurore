package net.aurore.command.utility;

import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.PublicCommand;
import net.dv8tion.jda.core.entities.Member;

@Command("ping")
public class CommandPing extends PublicCommand {

	private static final String PONG = "Pong !";
	
	public CommandPing(CommandManagerImpl manager) {
		super(manager);
	}


	@Override
	public void execute(CommandContext context, String[] args, List<Member> mentioned) {
		this.reply(context.getMsg(), PONG);
		
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

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return true;
	}

}
