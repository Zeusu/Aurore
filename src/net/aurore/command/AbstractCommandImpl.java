package net.aurore.command;

import java.util.List;

import net.aurore.util.TitleTextList;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

public abstract class AbstractCommandImpl implements CommandI{

	private CommandManagerImpl manager;
	
	
	
	protected abstract boolean isOk(CommandContext context, String[] args,List <Member> mentioned);
	
	
	
	public AbstractCommandImpl(CommandManagerImpl manager){
		this.manager = manager;
	}
	
	protected void send(MessageChannel channel, String msg){
		this.manager.getNode().getMessager().send(channel, msg);
	}
	
	protected void reply(Message message, String msg){
		this.manager.getNode().getMessager().reply(message, msg);
	}
	
	protected void sendEmbed(MessageChannel channel, String msg){
		this.manager.getNode().getMessager().sendEmbed(channel, msg);
	}
	
	protected void sendEmbed(MessageChannel channel, String title, TitleTextList texts, String imageURL){
		this.manager.getNode().getMessager().sendEmbed(channel, title, texts, imageURL);
	}
	
	protected CommandManager getCommandManager(){
		return manager;
	}
	
}
