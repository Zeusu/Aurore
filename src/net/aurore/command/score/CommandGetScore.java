package net.aurore.command.score;

import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.PublicCommand;
import net.aurore.entities.AuroreGuildMember;
import net.aurore.entities.AuroreGuildMemberId;
import net.dv8tion.jda.core.entities.Member;

@Command("getScore")
public class CommandGetScore extends PublicCommand {

	public CommandGetScore(CommandManagerImpl manager) {
		super(manager);
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
	public void execute(CommandContext context, String[] args, List<Member> mentioned) {
		AuroreGuildMemberId id = new AuroreGuildMemberId();
		id.setId(context.getAuthor().getIdLong());
		id.setGuildId(context.getGuild().getIdLong());
		AuroreGuildMember member = getDM().retrieveAuroreGuildMemberById(id);
		final int score;
		if(member == null)
			score = 0;
		else
			score = member.getScore();
		sendEmbed(context.getChannel(), "Votre score est de: " + score);
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return true;
	}

}
