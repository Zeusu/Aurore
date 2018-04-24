package net.aurore.lolservice.stats;

import java.util.List;

import net.aurore.entities.AuroreParticipantSummary;

public class AuroreLoLCalculatorParticipant implements AuroreLoLCalculator{

	
	public List<AuroreParticipantSummary> parts;
	
	public AuroreLoLCalculatorParticipant(List<AuroreParticipantSummary> parts){
		this.parts = parts;
	}
	
	@Override
	public double averageKDA() {
		double ka = 0;
		double d = 0;
		for(AuroreParticipantSummary p : parts){
			ka += (p.getKills() + p.getAssists());
			d += p.getDeaths();
		}
		return ka/d;
	}

	@Override
	public double averageKills() {
		double kills = 0;
		for(AuroreParticipantSummary p : parts){
			kills += p.getKills();
		}
		return kills/parts.size();
	}

	@Override
	public double averageDeaths() {
		double deaths = 0;
		for(AuroreParticipantSummary p : parts){
			deaths += p.getDeaths();
		}
		return deaths/parts.size();
	}

	@Override
	public double averageAssists() {
		double assists = 0;
		for(AuroreParticipantSummary p : parts){
			assists += p.getAssists();
		}
		return assists/parts.size();
	}

}
