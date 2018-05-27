package net.aurore.command;

import java.util.List;

import net.aurore.datamanager.DataManager;
import net.aurore.util.TitleTextList;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

public abstract class AbstractCommandImpl implements CommandI{

	private CommandManagerImpl manager;
	
	private static int instances = 0;
	
	private final int COMMAND_ID; 
	
	protected abstract boolean isOk(CommandContext context, String[] args,List <Member> mentioned);
	
	
	
	public AbstractCommandImpl(CommandManagerImpl manager){
		this.manager = manager;
		COMMAND_ID = instances;
		instances += 1;
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
	
	protected String parseArguments(String args[], int startIdx){
		if(startIdx < args.length){
			StringBuffer buffer = new StringBuffer();
			for(int i = startIdx; i < args.length; i++){
				buffer.append(args[i]);
				if(i != args.length - 1){
					buffer.append(' ');
				}
			}
			return buffer.toString();
		}else{
			return null;
		}
	}
	
	public int getId(){
		return COMMAND_ID;
	}
	
	public String generateCommandKey(CommandContext context){
		return "" + COMMAND_ID + context.getGuild().getId() + context.getAuthor().getId();
	}
	
	protected DataManager getDM(){
		return getCommandManager().getDM();
	}
	
}
