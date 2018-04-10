package net.aurore.lolservice;

public interface AuroreLoLCalculator {

	public double averageKDA();	
	
	public double averageKills();
	
	public double averageDeaths();
	
	public double averageAssists();
	
	public void focusSummoner(long summonerId) throws CalculatorInitException;
	
	public void focusChampion(long championId) throws CalculatorInitException;
	
}
