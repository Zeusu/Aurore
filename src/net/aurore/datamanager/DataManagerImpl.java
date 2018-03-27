package net.aurore.datamanager;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;

import net.aurore.entities.AuroreMatch;
import net.aurore.entities.AuroreMatchSummary;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;

public class DataManagerImpl implements DataManager {

	private Session session;
	
	protected DataManagerImpl(Session s){
		session = s;
	}

	@Override
	public boolean saveSummoner(Summoner s) {
		boolean isStored = retrieveSummonerById(s.getId()) != null;
		if(isStored){
			new SummonerJPAImpl(s,session).update();
		}else{
			new SummonerJPAImpl(s,session).save();
		}
		return true;
	}

	@Override
	public Summoner retrieveSummonerById(long id) {
		return new SummonerJPAImpl(new Summoner(),session).retrieveById(id);
	}

	@Override
	public Summoner retrieveSummonerByName(String name) {
		return new SummonerJPAImpl(new Summoner(), session).retrieveByName(name);
	}

	@Override
	public void saveRank(Rank r) {
		new RankJPAImpl(r,session).save();
	}

	public void saveAuroreMatch(AuroreMatch match) {
		new AuroreMatchJPAImpl(match,session).save();
	}

	@Override
	public List<BigInteger> retrieveMatchList() {
		return new AuroreMatchSummaryJPAImpl(new AuroreMatchSummary(),session).retrieveMatchList();
	}
	
	@Override
	public void saveAuroreMatchSummary(AuroreMatchSummary match){
		new AuroreMatchSummaryJPAImpl(match,session).save();
	}
}
