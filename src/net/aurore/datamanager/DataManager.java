package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;

import net.aurore.entities.AuroreGuildMember;
import net.aurore.entities.AuroreGuildMemberId;
import net.aurore.entities.AuroreMatchSummary;
import net.aurore.entities.AuroreParticipantSummary;
import net.aurore.entities.AuroreStats;
import net.aurore.entities.GuildConfig;
import net.aurore.entities.MatchListItem;
import net.aurore.entities.ScoreTrigger;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;

public interface DataManager {

	public boolean saveSummoner(Summoner s);
	
	public Summoner retrieveSummonerById(long id);
	
	public Summoner retrieveSummonerByName(String name);
	
	public void saveRank(Rank r);
	
	public Rank retrieveRankBySummonerId(long summonerId);
	
	public void saveAuroreMatchSummary(AuroreMatchSummary match);
	
	public AuroreMatchSummary retrieveMatchByMatchId(BigInteger matchId);
	
	public List<BigInteger> retrieveMatchList(); 
	
	public void saveMatchListItem(MatchListItem item);
	
	public List<MatchListItem> retrieveItemsBySummonerId(long summonerId);
	
	public List<MatchListItem> retrieveItemsByMatchId(BigInteger matchId);
	
	public void saveAuroreStats(AuroreStats s);
	
	public AuroreStats retrieveAuroreStatsBySummonerId(long summonerId);
	
	public List<AuroreParticipantSummary> retrieveParticipantsBySummonerId(long summonerId);

	public AuroreStats retrieveGlobalAuroreStats();
	
	public void saveGuildConfig(GuildConfig g);
	
	public GuildConfig retrieveGuildConfigById(long id);
	
	public void saveGuildMember(AuroreGuildMember m);
	
	public AuroreGuildMember retrieveAuroreGuildMemberById(AuroreGuildMemberId id);
	
	public List<AuroreGuildMember> retrieveAuroreGuildMemberById(long id);
	
	public void saveScoreTrigger(ScoreTrigger s);
	
	public List<ScoreTrigger> retrieveScoreTriggerByGuildId(long guildId);

}
