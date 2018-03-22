package net.aurore.lolservice.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchFrame {
	
	private long timestamp;
	
	private Map<Integer,MatchParticipantFrame> participantFrames = new HashMap<Integer,MatchParticipantFrame>();
	
	private List<MatchEvent> events = new ArrayList<MatchEvent>();
	
	
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public Map<Integer,MatchParticipantFrame> getParticipantFrames() {
		return participantFrames;
	}
	public void setParticipantFrames(Map<Integer,MatchParticipantFrame> participantFrames) {
		this.participantFrames = participantFrames;
	}
	public List<MatchEvent> getEvents() {
		return events;
	}
	public void setEvents(List<MatchEvent> events) {
		this.events = events;
	}
	
}
