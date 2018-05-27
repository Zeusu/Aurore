package net.aurore.command.config;

import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.RestrictCommand;
import net.aurore.entities.GuildConfig;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;

@Command("setPrefix")
public class CommandSetPrefix extends RestrictCommand {

	public CommandSetPrefix(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.CONFIG.toString();
	}

	@Override
	protected void execute(CommandContext context, String[] args, List<Member> mentioned) {
		GuildConfig config = getDM().retrieveGuildConfigById(context.getGuild().getIdLong());
		config.setPrefix(args[1]);
		getDM().saveGuildConfig(config);
		
	}

	@Override
	protected Permission[] permissions() {
		return new Permission[]{Permission.ADMINISTRATOR};
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return args.length == 2 && args[1].length() < 4;
	}

}
