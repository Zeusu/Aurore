package net.aurore.command.lol;

import java.util.List;

import net.aurore.command.AbstractCommandImpl;
import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.entities.AuroreStats;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;
import net.aurore.util.Encoder;
import net.aurore.util.TitleTextList;
import net.dv8tion.jda.core.entities.Member;

@Command("getSummoner")
public class CommandGetSummoner extends AbstractCommandImpl{

	public CommandGetSummoner(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public void onInvoke(CommandContext context, String[] args, List<Member> mentioned) {

		String summonerName = parseArguments(args,1);
		
		Summoner s = getCommandManager().getDM().retrieveSummonerByName(summonerName);
		if(s == null){
			return;
		}
		Rank sRank = getCommandManager().getDM().retrieveRankBySummonerId(s.getId());
		AuroreStats stats = getCommandManager().getDM().retrieveAuroreStatsBySummonerId(s.getId()); 
		
		TitleTextList l = new TitleTextList();
		l.addNode("Summoner Name", s.getName());
		l.addNode("Summoner Level", "" + s.getSummonerLevel());
		if(sRank != null)
			l.addNode("Summoner Rank", "" + sRank.getTier());
		if(stats != null){
			l.addNode("Average KDA", "" + stats.getKda());
			l.addNode("Average Kills", "" + stats.getAverageKill());
			l.addNode("Average Deaths", "" + stats.getAverageDeath());
			l.addNode("Average Assists", "" + stats.getAverageAssits());
		}
		this.sendEmbed(context.getChannel(), "Profile", l, "http://avatar.leagueoflegends.com/euw/" + Encoder.encode(s.getName()) + ".png");
		
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.LOL.toString();
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return args.length > 1;
	}

}
