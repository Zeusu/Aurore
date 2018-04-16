package net.aurore.lolservice.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Match extends AuroreLoLEntity{

	@JsonIgnore
	private BigInteger matchId;
	
	private List<MatchFrame> frames = new ArrayList<MatchFrame>();
	
	private long frameInterval;
	
	public List<MatchFrame> getFrames() {
		return frames;
	}
	public void setFrames(List<MatchFrame> frames) {
		this.frames = frames;
	}
	public long getFrameInterval() {
		return frameInterval;
	}
	public void setFrameInterval(long frameInterval) {
		this.frameInterval = frameInterval;
	}
	
	public BigInteger getMatchId() {
		return matchId;
	}
	public void setMatchId(BigInteger matchId) {
		this.matchId = matchId;
	}
	
}
