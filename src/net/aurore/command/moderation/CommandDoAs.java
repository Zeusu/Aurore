package net.aurore.command.moderation;

import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.RestrictCommand;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;

@Command("doAs")
public class CommandDoAs extends RestrictCommand {

	public CommandDoAs(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.ADMINISTRATION.toString();
	}

	@Override
	protected void execute(CommandContext context, String[] args, List<Member> mentioned) {
		send(context.getChannel(), parseArguments(args,1));
	}

	@Override
	protected Permission[] permissions() {
		return new Permission[]{Permission.ADMINISTRATOR};
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return args.length > 1;
	}

}
