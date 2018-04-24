package net.aurore.lolservice.stats;

import java.util.LinkedList;
import java.util.List;

import net.aurore.entities.AuroreMatchSummary;
import net.aurore.entities.AuroreParticipantSummary;

public class AuroreLoLCalculatorImpl implements AuroreLoLCalculator{

	
	
	private List<AuroreMatchSummary> matches;
	
	//Optionals fields
	private boolean focusChamp = false;
	private long champId = 0;
	private boolean focusSummoner = false;
	private long summonerId = 0;
	
	public AuroreLoLCalculatorImpl(List<AuroreMatchSummary> l) throws CalculatorInitException{
		if(l == null) throw new CalculatorInitException("Can not init a calculator with null list");
		matches = l;
	
	}
	
	@Override
	public double averageKDA() {

		List<Double> l = new LinkedList<Double>();
		double divider = 0;

		for (AuroreMatchSummary m : matches) {
			for (AuroreParticipantSummary p : m.getParticipants()) {
				if((focusChamp && ((long) p.getChampionId() == champId)) || (focusSummoner && (p.getSummonerId() == summonerId)) || (focusChamp && focusSummoner)){
					l.add((double) p.getKills() + p.getAssists());
					divider += p.getDeaths();
				}
			}
		}

		return average(l, divider);

	}

	@Override
	public double averageKills() {
		List<Double> l = new LinkedList<Double>();

		for (AuroreMatchSummary m : matches) {
			for (AuroreParticipantSummary p : m.getParticipants()) {
				if((focusChamp && ((long) p.getChampionId() == champId)) || (focusSummoner && (p.getSummonerId() == summonerId)) || (focusChamp && focusSummoner)){
					l.add((double) p.getKills());
				}
			}
		}

		return average(l, l.size());
	}

	@Override
	public double averageDeaths() {
		List<Double> l = new LinkedList<Double>();

		for (AuroreMatchSummary m : matches) {
			for (AuroreParticipantSummary p : m.getParticipants()) {
				if((focusChamp && ((long) p.getChampionId() == champId)) || (focusSummoner && (p.getSummonerId() == summonerId)) || (focusChamp && focusSummoner)){
					l.add((double) p.getDeaths());
				}
			}
		}

		return average(l, l.size());
	}

	@Override
	public double averageAssists() {
		List<Double> l = new LinkedList<Double>();

		for (AuroreMatchSummary m : matches) {
			for (AuroreParticipantSummary p : m.getParticipants()) {
				if((focusChamp && ((long) p.getChampionId() == champId)) || (focusSummoner && (p.getSummonerId() == summonerId)) || (focusChamp && focusSummoner)){
					l.add((double) p.getAssists());
				}
			}
		}

		return average(l, l.size());
	}


	public void focusSummoner(long summonerId) throws CalculatorInitException {
		if(focusChamp) throw new CalculatorInitException("Can not init a calculator with champion AND summoner");
		focusSummoner = true;
		this.summonerId = summonerId;
		
	}


	public void focusChampion(long championId) throws CalculatorInitException {
		if(focusSummoner) throw new CalculatorInitException("Can not init a calculator with champion AND summoner");
		focusChamp = true;
		this.champId = championId;
	}
	
	
	
	private double average(List<Double> l, double divider){
		double total = 0;
		for(Double d : l ){
			total += d;
		}
		return total/divider;
		
	}
	
	
}
