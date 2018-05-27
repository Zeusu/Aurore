package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.aurore.entities.AuroreGuildMember;
import net.aurore.entities.AuroreGuildMemberId;
import net.aurore.entities.AuroreMatch;
import net.aurore.entities.AuroreMatchSummary;
import net.aurore.entities.AuroreParticipantSummary;
import net.aurore.entities.AuroreStats;
import net.aurore.entities.GuildConfig;
import net.aurore.entities.MatchListItem;
import net.aurore.entities.ScoreTrigger;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;

public class DataManagerImpl implements DataManager {

	private SessionFactory sF;
	
	protected DataManagerImpl(SessionFactory s){
		this.sF = s;
	}

	@Override
	public boolean saveSummoner(Summoner s) {
		Session session = sF.openSession();
		new SummonerJPAImpl(s,session).save();
		session.close();
		return true;
	}

	@Override
	public Summoner retrieveSummonerById(long id) {
		Session session = sF.openSession();
		Summoner s = new SummonerJPAImpl(new Summoner(),session).retrieveById(id);
		session.close();
		return s;
	}

	@Override
	public Summoner retrieveSummonerByName(String name) {
		Session session = sF.openSession();
		Summoner s = new SummonerJPAImpl(new Summoner(), session).retrieveByName(name);
		session.close();
		return s;
	}

	@Override
	public void saveRank(Rank r) {
		Session session = sF.openSession();
		new RankJPAImpl(r,session).save();
		session.close();
	}

	public void saveAuroreMatch(AuroreMatch match) {
		Session session = sF.openSession();
		new AuroreMatchJPAImpl(match,session).save();
		session.close();
	}

	@Override
	public List<BigInteger> retrieveMatchList() {
		Session session = sF.openSession();
		List<BigInteger> l = new AuroreMatchSummaryJPAImpl(new AuroreMatchSummary(),session).retrieveMatchList();
		session.close();
		return l;
	}
	
	@Override
	public void saveAuroreMatchSummary(AuroreMatchSummary match){
		Session session = sF.openSession();
		new AuroreMatchSummaryJPAImpl(match,session).save();
		session.close();
	}

	@Override
	public Rank retrieveRankBySummonerId(long summonerId) {
		Session session = sF.openSession();
		Rank r = new RankJPAImpl(null, session).getRank(summonerId);
		session.close();
		return r;
	}

	@Override
	public void saveMatchListItem(MatchListItem item) {
		Session session = sF.openSession();
		new MatchListItemJPAImpl(item, session).save();
		session.close();
	}

	@Override
	public List<MatchListItem> retrieveItemsBySummonerId(long summonerId) {
		Session session = sF.openSession();
		List<MatchListItem> l = new MatchListItemJPAImpl(null, session).retrieveBySummonerId(summonerId);
		session.close();
		return l;
	}

	@Override
	public List<MatchListItem> retrieveItemsByMatchId(BigInteger matchId) {
		Session session = sF.openSession();
		List<MatchListItem> l = new MatchListItemJPAImpl(null, session).retrieveByMatchId(matchId);
		session.close();
		return l;
	}

	@Override
	public AuroreMatchSummary retrieveMatchByMatchId(BigInteger matchId) {
		Session session = sF.openSession();
		AuroreMatchSummary s = new AuroreMatchSummaryJPAImpl(null,session).retrieveByMatchId(matchId);
		session.close();
		return s;
	}

	@Override
	public void saveAuroreStats(AuroreStats s) {
		Session session = sF.openSession();
		new AuroreStatsJPAImpl(s,session).save();
		session.close();
	}

	@Override
	public AuroreStats retrieveAuroreStatsBySummonerId(long summonerId) {
		Session session = sF.openSession();
		AuroreStats s = new AuroreStatsJPAImpl(null,session).retrieve(summonerId);
		session.close();
		return s;
	}

	@Override
	public List<AuroreParticipantSummary> retrieveParticipantsBySummonerId(long summonerId) {
		Session session = sF.openSession();
		List<AuroreParticipantSummary> l = new AuroreParticipantSummaryJPAImpl(session).retrieveSummariesBySummonerId(summonerId);
		session.close();
		return l;
	}

	@Override
	public AuroreStats retrieveGlobalAuroreStats() {
		return null;
	}

	@Override
	public void saveGuildConfig(GuildConfig g) {
		Session session = sF.openSession();
		new GuildConfigJPAImpl(g, session).save();
		session.close();
	}

	@Override
	public GuildConfig retrieveGuildConfigById(long id) {
		Session session = sF.openSession();
		GuildConfig g = new GuildConfigJPAImpl(null,session).retrieveByGuildId(id);
		session.close();
		return g;
	}

	@Override
	public void saveGuildMember(AuroreGuildMember m) {
		Session session = sF.openSession();
		new AuroreGuildMemberJPAImpl(m,session).save();
		session.close();
	}

	@Override
	public AuroreGuildMember retrieveAuroreGuildMemberById(AuroreGuildMemberId id) {
		Session session = sF.openSession();
		AuroreGuildMember m = new AuroreGuildMemberJPAImpl(null, session).retrieveById(id);
		session.close();
		return m;
	}

	@Override
	public List<AuroreGuildMember> retrieveAuroreGuildMemberById(long id) {
		Session session = sF.openSession();
		List<AuroreGuildMember> l = new AuroreGuildMemberJPAImpl(null, session).retrieveByGuildId(id);
		session.close();
		return l;
	}

	@Override
	public void saveScoreTrigger(ScoreTrigger s) {
		Session session = sF.openSession();
		new ScoreTriggerJPAImpl(s, session).save();
		session.close();
	}

	@Override
	public List<ScoreTrigger> retrieveScoreTriggerByGuildId(long guildId) {
		Session session = sF.openSession();
		List<ScoreTrigger> l = new ScoreTriggerJPAImpl(null, session).retrieveByGuildId(guildId);
		session.close();
		return l;
	}
}
