package net.aurore.command.score;

import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.PublicCommand;
import net.aurore.entities.AuroreGuildMember;
import net.dv8tion.jda.core.entities.Member;

@Command("top")
public class CommandTop extends PublicCommand {

	public CommandTop(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public String help() {
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.UTILITY.toString();
	}

	@Override
	public void execute(CommandContext context, String[] args, List<Member> mentioned) {
		List<AuroreGuildMember> members = getDM().retrieveAuroreGuildMemberById(context.getGuild().getIdLong());
		int start = 0;		
		if(args.length == 2){
			start = Integer.parseInt(args[1]) - 1;
			if(!(start < members.size()) && start >= 0){
				return;
			}
		}
		int max = start + 10;
		int i = 0;
		StringBuffer toSend = new StringBuffer();
		toSend.append("```");
		for(AuroreGuildMember m : members){
			if(i >= start){
				if(i < max){
					toSend.append(i+1);
					toSend.append(" - ");
					Member member = context.getGuild().getMemberById(m.getUserId());
					if(member != null){
						toSend.append(member.getEffectiveName());
					}else{
						toSend.append("Member leave or doesn't exist...");
					}
					toSend.append(": ");
					toSend.append(m.getScore());
					toSend.append('\n');
				}
			}
			i+=1;
		}
		toSend.append("```");
		if(!toSend.toString().equals("``````")) this.send(context.getChannel(), toSend.toString());
		
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return args.length == 1 || args.length == 2;
	}

}
