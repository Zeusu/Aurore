package net.aurore.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import net.dv8tion.jda.core.entities.Guild;

@Entity
@Table(name = "score_trigger")
public class ScoreTrigger {
	
	private static final String REGEX_BLOCKS = "(\\{(.*): (.*)\\})*";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;
	
	@Column(name = "guild_id", nullable = false)
	private long guildId;

	@Column(name = "score_amount", nullable = false)
	private int scoreAmount = 0;
	
	@Column(name = "role_id")
	private long roleId = 0;
	
	@Column(name = "message")
	private String message = "";

	
	public static ScoreTrigger parse(String toParse, Guild g) throws InvalidBlockException, InvalidPropertyException, InvalidValueException{
		if(toParse != null && toParse.matches(REGEX_BLOCKS)){
			ScoreTrigger trigger = new ScoreTrigger();
			trigger.guildId = g.getIdLong();
			List<String> blocks = new LinkedList<String>();
			int startIndex = 0;
			int endIndex = 0;
			for(int i = 0; i < toParse.length(); i++){
				char c = toParse.charAt(i);
				if(c == '{') startIndex = i + 1;
				else if(c == '}'){
					endIndex = i;
					blocks.add(toParse.substring(startIndex, endIndex));
				}
			}
			for(String s : blocks){
				String[] value = s.split(" ");
				if(value[0].length() > 1){
					String propertyName = value[0].substring(0, value[0].length() - 1);
					switch(propertyName){
						case "role":
							try{
								trigger.roleId = g.getRolesByName(value[1], false).get(0).getIdLong();
							}catch(Exception e){
								throw new InvalidValueException(propertyName, value[1]);
							}
							break;
						case "message":
							for(int i = 1; i < value.length; i++){
								trigger.message += value[i] + ' ';
							}
							break;
						case "scoreAmount":
							try{
								trigger.scoreAmount = Integer.parseInt(value[1]);
							}catch(Exception e){
								throw new InvalidValueException(propertyName, value[1]);
							}
							break;
						default:
							throw new InvalidPropertyException(propertyName);
					}
				}
			}
			return trigger;
		}
		throw new InvalidBlockException();
	}
	
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

	public int getScoreAmount() {
		return scoreAmount;
	}

	public void setScoreAmount(int scoreAmount) {
		this.scoreAmount = scoreAmount;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString(){
		return "Guild Id = " + guildId  + "; Message = \"" + message + "\"; Role Id = " + roleId + "; Score Amount = " + scoreAmount + ";";
	}
	
}
