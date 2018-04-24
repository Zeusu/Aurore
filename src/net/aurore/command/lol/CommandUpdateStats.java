package net.aurore.command.lol;

import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.LoLCommand;
import net.aurore.entities.AuroreParticipantSummary;
import net.aurore.entities.AuroreStats;
import net.aurore.entities.Context;
import net.aurore.lolservice.entities.Summoner;
import net.aurore.lolservice.stats.AuroreLoLCalculator;
import net.aurore.lolservice.stats.AuroreLoLCalculatorParticipant;
import net.dv8tion.jda.core.entities.Member;

@Command("updateStats")
public class CommandUpdateStats extends LoLCommand{

	public CommandUpdateStats(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public void execute(CommandContext context, String[] args, List<Member> mentioned) {
		String summonerName = parseArguments(args, 1);
		Summoner s = getDM().retrieveSummonerByName(summonerName);
		if(s == null) return;
		List<AuroreParticipantSummary> parts = getDM().retrieveParticipantsBySummonerId(s.getId());
		if(parts == null){
			System.out.println("error");
			return;
		}
		AuroreLoLCalculator c = new AuroreLoLCalculatorParticipant(parts);
		AuroreStats stats = new AuroreStats();
		stats.setAverageAssits(c.averageAssists());
		stats.setAverageDeath(c.averageDeaths());
		stats.setAverageKill(c.averageKills());
		stats.setKda(c.averageKDA());
		stats.setS(s);
		getDM().saveAuroreStats(stats);
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
		return args.length > 1;
	}

	@Override
	public void callback(Context<?> context, Object e) {
	}

}
