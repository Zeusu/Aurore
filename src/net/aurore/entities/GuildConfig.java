package net.aurore.entities;

import javax.persistence.*;

@Entity
@Table(name = "guild_config")
public class GuildConfig {

	@Id
	@Column(name = "id")
	private long guildId;
	
	@Column(name = "prefix")
	private String prefix;
	
	
	public long getGuildId() {
		return guildId;
	}

	public void setGuildId(long guildId) {
		this.guildId = guildId;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	
}
