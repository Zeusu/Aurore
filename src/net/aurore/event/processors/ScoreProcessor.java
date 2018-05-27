package net.aurore.event.processors;

import java.util.List;
import java.util.Random;

import net.aurore.core.Config;
import net.aurore.entities.AuroreGuildMember;
import net.aurore.entities.AuroreGuildMemberId;
import net.aurore.entities.ScoreTrigger;
import net.aurore.event.EventManagerImpl;
import net.aurore.event.EventProc;
import net.aurore.event.EventProcessor;
import net.aurore.event.Events;
import net.aurore.util.ConfigManager;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;;

@EventProc(Events.ON_MESSAGE)
public class ScoreProcessor extends EventProcessor {

	public static final Random R = new Random();
	
	public ScoreProcessor(EventManagerImpl manager) {
		super(manager);
	}
	

	@Override
	public void process(Event event) {
		if(!(event instanceof MessageReceivedEvent)) return;
		MessageReceivedEvent ev = (MessageReceivedEvent) event;
		Guild g = ev.getGuild();
		if(ev.getAuthor().isBot()) return;
		AuroreGuildMemberId id = new AuroreGuildMemberId();
		id.setGuildId(g.getIdLong());
		id.setId(ev.getAuthor().getIdLong());
		AuroreGuildMember member = getManager().getDM().retrieveAuroreGuildMemberById(id);
		double maxScore = (((double)(ev.getMessage().getContentRaw().length()) / (double)(((Config) ConfigManager.getConfig(Config.KEY)).getTextLimit())) * 100);
		if(member != null)  member.setScore(member.getScore() + R.nextInt((int)(5+maxScore)));
		else{
			member = new AuroreGuildMember();
			member.setId(id);
			member.setScore(R.nextInt(10));
		}
		List<ScoreTrigger> triggers = getManager().getDM().retrieveScoreTriggerByGuildId(g.getIdLong());
		Member m = ev.getMember(); 
		for(ScoreTrigger t: triggers){
			if(!hasRole(m,t.getRoleId()) && member.getScore() >= t.getScoreAmount()){
				try{
					g.getController().addSingleRoleToMember(m, g.getRoleById(t.getRoleId())).queue();
					if(!t.getMessage().equals("")) send(ev.getChannel(),t.getMessage());
				}catch(Exception e){}
			}
		}
		getManager().getDM().saveGuildMember(member);		
	}
	
	
	private boolean hasRole(Member m, long roleId){
		for(Role r : m.getRoles()){
			if(r.getIdLong() == roleId) return true;
		}
		return false;
	}
}
