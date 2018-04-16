package net.aurore.command.lol;

import java.math.BigInteger;
import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.LoLCommandMultiRequest;
import net.aurore.entities.AuroreMatchSummary;
import net.aurore.entities.Context;
import net.aurore.lolservice.entities.MatchList;
import net.aurore.lolservice.entities.MatchSummary;
import net.aurore.lolservice.entities.Matches;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;
import net.dv8tion.jda.core.entities.Member;

@Command("updateSummoner")
public class CommandUpdateSummoner extends LoLCommandMultiRequest{

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
	public void execute(CommandContext context, String[] args, List<Member> mentioned){
		
		String summonerName = parseArguments(args, 1);
		getLoLService().summonerByName(summonerName, new Context<CommandContext>(context), key());
		setIndex(context.getAuthor().getId(),0);

		
		/*
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
		*/
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return args.length > 1;
	}


	@Override
	public void root(int rootIndex, CommandContext context, Object e) {
		String userId = context.getAuthor().getId();
		System.out.println("hitted");
		if(e instanceof Summoner && rootIndex == 0){
			Summoner s = (Summoner) e;
			getDM().saveSummoner((Summoner) s);
			store(userId, 0, s);
			setIndex(userId, 1);
			getLoLService().rankBySummonerId(s.getId(), new Context<CommandContext>(context), key());
		}
		else if(e instanceof Rank[] && rootIndex == 1){
			Rank[] ranks = (Rank[]) e;
			Rank r = null;
			for(Rank rk : ranks){
				if(rk.getQueueType().equals(Rank.RANKED_SOLO)) r = rk;
			}
			if(r != null){
				getDM().saveRank(r);
				store(userId,1,r);
			}
			setIndex(userId,2);
			getLoLService().matchListByAccountId(((Summoner) getEntity(userId,0)).getAccountId(),new Context<CommandContext>(context), key());
		}
		else if(e instanceof MatchList && rootIndex == 2){
			MatchList m = (MatchList) e;	
			for(MatchSummary ma : m){
				BigInteger matchId = BigInteger.valueOf(ma.getGameId());
				if(getDM().retrieveMatchByMatchId(matchId) == null){
					getLoLService().matchByMatchId(matchId,new Context<CommandContext>(context), key());
				}
			}
			getLoLService().matchListByAccountIdWithStartIndex(((Summoner) getEntity(userId,0)).getAccountId(), m.getEndIndex() ,new Context<CommandContext>(context), key());
		}
		else if(e instanceof Matches && rootIndex == 2){
			
			getDM().saveAuroreMatchSummary(new AuroreMatchSummary((Matches) e));
		}
	}
}
