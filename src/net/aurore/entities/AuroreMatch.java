package net.aurore.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import net.aurore.lolservice.entities.Match;
import net.aurore.lolservice.entities.MatchFrame;

@Entity
@Table(name = "match")
public class AuroreMatch {

	@Id
	@Column(name = "matchId", nullable = false, unique = true)
	private BigInteger matchId;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "match", fetch = FetchType.LAZY)
	private List<AuroreMatchFrame> frames = new ArrayList<AuroreMatchFrame>();
	
	
	@Column(name = "frameInterval")
	private long frameInterval;
	
	
	public AuroreMatch(){}
	
	public AuroreMatch(Match m){
		matchId = m.getMatchId();
		frameInterval = m.getFrameInterval();
		for(MatchFrame f : m.getFrames()){
			AuroreMatchFrame frame = new AuroreMatchFrame(f,this);
			frames.add(frame);
		}
	}
	
	public List<AuroreMatchFrame> getFrames() {
		return frames;
	}
	public void setFrames(List<AuroreMatchFrame> frames) {
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
