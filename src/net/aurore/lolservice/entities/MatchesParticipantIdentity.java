package net.aurore.lolservice.entities;

public class MatchesParticipantIdentity {

	private MatchesPlayer player;
	private int participantId;
	
	public MatchesPlayer getPlayer() {
		return player;
	}
	public void setPlayer(MatchesPlayer player) {
		this.player = player;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	
	
}
