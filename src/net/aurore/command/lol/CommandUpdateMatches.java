package net.aurore.command.lol;

import java.math.BigInteger;
import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.LoLCommand;
import net.aurore.entities.AuroreMatchSummary;
import net.aurore.entities.AuroreParticipantSummary;
import net.aurore.entities.Context;
import net.aurore.entities.MatchListItem;
import net.dv8tion.jda.core.entities.Member;

@Command("updateMatches")
public class CommandUpdateMatches extends LoLCommand{

	public CommandUpdateMatches(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public void execute(CommandContext context, String[] args, List<Member> mentioned) {
		List<BigInteger> l = getDM().retrieveMatchList();
		System.out.println("All Match Retrieved");
		for(BigInteger i : l){
			AuroreMatchSummary m = getDM().retrieveMatchByMatchId(i);
			for(AuroreParticipantSummary p : m.getParticipants()){
				try{
					if(! (getDM().retrieveSummonerById(p.getSummonerId()) == null))
						getDM().saveMatchListItem(new MatchListItem(p.getSummonerId(),m.getMatchId()));
				}catch(Exception e){}
			}
		}
		System.out.println("Update End");
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.LOL_UPDATE.toString();
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return true;
	}

	@Override
	public void callback(Context<?> context, Object e) {
	}

}
