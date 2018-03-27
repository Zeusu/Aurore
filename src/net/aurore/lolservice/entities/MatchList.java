package net.aurore.lolservice.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MatchList implements Iterable<MatchSummary> {

	private List<MatchSummary> matches = new ArrayList<MatchSummary>();
	private int totalGames;
	private int startIndex;
	private int endIndex;
	
	@Override
	public Iterator<MatchSummary> iterator() {
		return matches.iterator();
	}

	public List<MatchSummary> getMatches() {
		return matches;
	}

	public void setMatches(List<MatchSummary> matches) {
		this.matches = matches;
	}

	public int getTotalGames() {
		return totalGames;
	}

	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

}
