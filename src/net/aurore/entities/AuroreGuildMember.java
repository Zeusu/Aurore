package net.aurore.entities;

import javax.persistence.*;

@Entity
@Table(name = "guild_member")
public class AuroreGuildMember {
	
	@EmbeddedId
	private AuroreGuildMemberId id;
	
	@Column(name = "score")
	private int score;
	
	
	public AuroreGuildMember(){}
	
	public AuroreGuildMember(long userId, long guildId, int score){
		id = new AuroreGuildMemberId();
		id.setId(userId);
		id.setGuildId(guildId);
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public AuroreGuildMemberId getId() {
		return id;
	}

	public void setId(AuroreGuildMemberId id) {
		this.id = id;
	}

	public long getUserId() {
		return id.getId();
	}

	public long getGuildId() {
		return id.getGuildId();
	}
}
