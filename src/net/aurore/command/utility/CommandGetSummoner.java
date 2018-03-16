package net.aurore.command.utility;

import java.util.List;

import net.aurore.command.AbstractCommandImpl;
import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
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
		StringBuffer summonerName = new StringBuffer("");
		for(int i = 1; i < args.length; i++){
			summonerName.append(args[i]);
			if(i != args.length - 1){
				summonerName.append(' ');
			}
		}
		Summoner s = getCommandManager().getLoLService().summonerByName(summonerName.toString());
		Rank sRank = getCommandManager().getLoLService().rankBySummonerId(s.getId());
		
		TitleTextList l = new TitleTextList();
		l.addNode("Summoner Name", s.getName());
		l.addNode("Summoner Level", "" + s.getSummonerLevel());
		l.addNode("Summoner Rank", "" + sRank.getTier());
		this.sendEmbed(context.getChannel(), "Profile", l, "http://avatar.leagueoflegends.com/euw/" + Encoder.encode(s.getName()) + ".png");
		
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.TEST.toString();
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return args.length > 1;
	}

}
