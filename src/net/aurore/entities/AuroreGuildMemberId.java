package net.aurore.entities;

import java.io.Serializable;

import javax.persistence.Column;

public class AuroreGuildMemberId implements Serializable{

	private static final long serialVersionUID = 8091966275377033374L;

	@Column(name = "user_id")
	private long id;
	
	@Column(name = "guild_id")
	private long guildId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGuildId() {
		return guildId;
	}

	public void setGuildId(long guildId) {
		this.guildId = guildId;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null) return false;
		if(!(o instanceof AuroreGuildMemberId)) return false;
		AuroreGuildMemberId id = (AuroreGuildMemberId) o;
		return this.id == id.id && this.guildId == id.guildId;
	}
	
	@Override
	public int hashCode(){
		return ("" + (id + guildId)).hashCode();
	}
	
}
