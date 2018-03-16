package net.aurore.command.moderation;

import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.RestrictCommand;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;

@Command("ban")
public class CommandBan extends RestrictCommand {
	
	private static final int DAY_TO_REMOVE_MESSAGES = 1;
	private static final String BAN_TEXT = " a été banni(e) !";

	public CommandBan(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public String help() {
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.MODERATION.toString();
	}

	@Override
	protected void execute(CommandContext context, String[] args, List<Member> mentioned) {
		context.getGuild().getController().ban(mentioned.get(0), DAY_TO_REMOVE_MESSAGES).queue();
		this.sendEmbed(context.getChannel(), mentioned.get(0).getEffectiveName() + ' ' +  BAN_TEXT);
	}

	@Override
	protected Permission[] permissions() {
		return new Permission[]{Permission.ADMINISTRATOR,Permission.BAN_MEMBERS};
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return (context.getGuild().getMemberById(getCommandManager().getSelfId()).hasPermission(Permission.BAN_MEMBERS) && (context.getMsg().getMentionedMembers().size() == 1) && (args.length == 2));
	}

}
