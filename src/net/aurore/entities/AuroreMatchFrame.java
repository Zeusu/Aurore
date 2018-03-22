package net.aurore.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.*;

import net.aurore.lolservice.entities.MatchEvent;
import net.aurore.lolservice.entities.MatchFrame;
import net.aurore.lolservice.entities.MatchParticipantFrame;


@Entity
@Table(name = "matchframe")
@IdClass(AuroreMatchFrameKey.class)
public class AuroreMatchFrame{

	public AuroreMatchFrame(){}
	
	public AuroreMatchFrame(MatchFrame frame){
		this();
		timestamp = frame.getTimestamp();
		
		int size = frame.getParticipantFrames().size();
		for(int i = 1; i < size ; i++){
			participantFrames.add(null);
		}
		for(Entry<Integer,MatchParticipantFrame> e : frame.getParticipantFrames().entrySet()){
			AuroreMatchParticipantFrame p = new AuroreMatchParticipantFrame(e.getValue(),getMatchId(), getFrameId());
			participantFrames.add(e.getKey(), p);
		}
		long id = 0;
		for(MatchEvent e : frame.getEvents()){
			AuroreMatchEvent event = new AuroreMatchEvent(e,getMatchId(),getFrameId(),BigInteger.valueOf(id));
			events.add(event);
			id += 1;
		}
	}
	
	@Id
	@Column(name = "matchId")
	private BigInteger matchId;
	
	@Id
	@Column(name = "frameId")
	private BigInteger frameId;
	
	@Column(name = "timestamp")
	private long timestamp;
		
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name = "matchId"),
		@JoinColumn(name = "frameId")
	})
	private List<AuroreMatchParticipantFrame> participantFrames = new ArrayList<AuroreMatchParticipantFrame>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name = "matchId"),
		@JoinColumn(name = "frameId")
	})
	private List<AuroreMatchEvent> events = new ArrayList<AuroreMatchEvent>();
	
	
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public List<AuroreMatchParticipantFrame> getParticipantFrames() {
		return participantFrames;
	}
	public void setParticipantFrames(List<AuroreMatchParticipantFrame> participantFrames) {
		this.participantFrames = participantFrames;
	}
	public List<AuroreMatchEvent> getEvents() {
		return events;
	}
	public void setEvents(List<AuroreMatchEvent> events) {
		this.events = events;
	}
	
	public BigInteger getMatchId() {
		return matchId;
	}

	public void setMatchId(BigInteger matchId) {
		this.matchId = matchId;
	}

	public BigInteger getFrameId() {
		return frameId;
	}

	public void setFrameId(BigInteger frameId) {
		this.frameId = frameId;
	}
	
	
}
