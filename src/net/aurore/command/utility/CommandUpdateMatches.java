package net.aurore.command.utility;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.aurore.command.AbstractCommandImpl;
import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.entities.AuroreMatchSummary;
import net.aurore.lolservice.entities.MatchList;
import net.aurore.lolservice.entities.MatchSummary;
import net.aurore.lolservice.entities.Matches;
import net.dv8tion.jda.core.entities.Member;

@Command("updateMatches")
public class CommandUpdateMatches extends AbstractCommandImpl{

	public CommandUpdateMatches(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public void onInvoke(CommandContext context, String[] args, List<Member> mentioned) {
		List<MatchList> list = getCommandManager().getLoLService().matchListByAccountId(Long.parseLong(args[1]));
		List<BigInteger> currents = getCommandManager().getDM().retrieveMatchList();
		
		Map<BigInteger,Integer> test = new HashMap<BigInteger,Integer>();
		for(MatchList l : list){
			for(MatchSummary m : l){
				if(test.get(BigInteger.valueOf(m.getGameId())) == null)  test.put(BigInteger.valueOf(m.getGameId()), 1);
				else test.put(BigInteger.valueOf(m.getGameId()),test.get(BigInteger.valueOf(m.getGameId())).intValue() + 1);
			}
		}
		for(Map.Entry<BigInteger,Integer> i : test.entrySet()){
			if(i.getValue().intValue() != 1) System.out.println(i.getKey());
		}
		
		
		/*for(MatchList m : list){
			for(MatchSummary match : m){
				if(currents != null){
					int count = 0;
					BigInteger j = BigInteger.valueOf(match.getGameId());
					
					for(BigInteger i : currents){
						if(i.equals(j)) count += 1;
					}
					if(count == 0){
						Matches lolMatch = getCommandManager().getLoLService().matchesByMatchId(j);
						if(lolMatch != null)
							getCommandManager().getDM().saveAuroreMatchSummary(new AuroreMatchSummary(lolMatch));
					}
				}else{
					Matches lolMatch = getCommandManager().getLoLService().matchesByMatchId(BigInteger.valueOf(match.getGameId()));
					if(lolMatch != null)
						getCommandManager().getDM().saveAuroreMatchSummary(new AuroreMatchSummary(lolMatch));
				}
			}
		}*/
		
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
		return args.length == 2;
	}

}
