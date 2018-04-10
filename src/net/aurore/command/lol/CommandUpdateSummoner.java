package net.aurore.command.lol;

import java.math.BigInteger;
import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.LoLCommand;
import net.aurore.entities.AuroreMatchSummary;
import net.aurore.lolservice.entities.MatchList;
import net.aurore.lolservice.entities.MatchSummary;
import net.aurore.lolservice.entities.Matches;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;
import net.dv8tion.jda.core.entities.Member;

@Command("updateSummoner")
public class CommandUpdateSummoner extends LoLCommand{

	public CommandUpdateSummoner(CommandManagerImpl manager) {
		super(manager);
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
	public void execute(CommandContext context, String[] args, List<Member> mentioned) {
		
		String summonerName = parseArguments(args, 1);
		boolean isStored = true;
		Summoner s = getDM().retrieveSummonerByName(summonerName);
		
		if(s == null){
			s = getLoLService().summonerByName(summonerName);
			isStored = false;
		}
		if(s == null) return;
		if(!isStored){
			getDM().saveSummoner(s);
		}
		
		isStored = true;
		Rank r = getDM().retrieveRankBySummonerId(s.getId());
		if(r == null){
			r = getLoLService().rankBySummonerId(s.getId());
			isStored = false;
		}
		if(!isStored && r != null){
			getDM().saveRank(r);
		}
		
		List<BigInteger> currents = getDM().retrieveMatchList();
		List<MatchList> matches = getLoLService().matchListByAccountId(s.getAccountId());
		
		for(MatchList l : matches){
			for(MatchSummary m : l){
				int count = 0;
				
				for(BigInteger i : currents){
					if(BigInteger.valueOf(m.getGameId()).equals(i)) count += 1;
				}
				
				if(count == 0){
					Matches lolMatch = getCommandManager().getLoLService().matchesByMatchId(BigInteger.valueOf(m.getGameId()));
					if(lolMatch != null)
						getCommandManager().getDM().saveAuroreMatchSummary(new AuroreMatchSummary(lolMatch));
				}
			}
		}
		
		System.out.println("/!\\ End of Update /!\\");
		
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return args.length > 1;
	}

}
