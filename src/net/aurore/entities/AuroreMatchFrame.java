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
public class AuroreMatchFrame{

	public AuroreMatchFrame(){}
	
	public AuroreMatchFrame(MatchFrame frame, AuroreMatch m){
		this();
		match = m;
		timestamp = frame.getTimestamp();
		
		for(Entry<Integer,MatchParticipantFrame> e : frame.getParticipantFrames().entrySet()){
			AuroreMatchParticipantFrame p = new AuroreMatchParticipantFrame(e.getValue(),this);
			participantFrames.add(p);
		}
		for(MatchEvent e : frame.getEvents()){
			AuroreMatchEvent event = new AuroreMatchEvent(e,this);
			events.add(event);
		}
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "frameId", nullable = false, unique = true)
	private BigInteger frameId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "matchId")
	private AuroreMatch match;

	@Column(name = "timestamp")
	private long timestamp;
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "frame", fetch = FetchType.LAZY)
	private List<AuroreMatchParticipantFrame> participantFrames = new ArrayList<AuroreMatchParticipantFrame>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "frame", fetch = FetchType.LAZY)
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
	
	public BigInteger getFrameId() {
		return frameId;
	}

	public void setFrameId(BigInteger frameId) {
		this.frameId = frameId;
	}

	public AuroreMatch getMatch() {
		return match;
	}

	public void setMatch(AuroreMatch match) {
		this.match = match;
	}


	
}
