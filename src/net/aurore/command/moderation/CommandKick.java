package net.aurore.command.moderation;

import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.RestrictCommand;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;

@Command("kick")
public class CommandKick extends RestrictCommand {

	
	private static final String KICK_TEXT = " a été kick !";
	
	public CommandKick(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.MODERATION.toString();
	}

	@Override
	protected void execute(CommandContext context, String[] args, List<Member> mentioned) {
		context.getGuild().getController().kick(mentioned.get(0)).queue();
		this.sendEmbed(context.getChannel(), mentioned.get(0).getEffectiveName() + ' ' + KICK_TEXT);

	}

	@Override
	protected Permission[] permissions() {
		return new Permission[]{Permission.ADMINISTRATOR, Permission.KICK_MEMBERS};
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return (context.getGuild().getMemberById(getCommandManager().getSelfId()).hasPermission(Permission.KICK_MEMBERS) && (context.getMsg().getMentionedMembers().size() == 1) && (args.length == 2));
	}

}
