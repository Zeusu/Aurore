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

	@Column(name = "matchId") @Id
	private BigInteger matchId;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="matchId")
	private List<AuroreMatchFrame> frames = new ArrayList<AuroreMatchFrame>();
	
	
	@Column(name = "frameInterval")
	private long frameInterval;
	
	
	public AuroreMatch(){}
	
	public AuroreMatch(Match m){
		matchId = m.getMatchId();
		frameInterval = m.getFrameInterval();
		long i = 0;
		for(MatchFrame f : m.getFrames()){
			AuroreMatchFrame frame = new AuroreMatchFrame(f);
			frame.setFrameId(BigInteger.valueOf(i));
			frame.setMatchId(matchId);
			frames.add(frame);
			i += 1;
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
