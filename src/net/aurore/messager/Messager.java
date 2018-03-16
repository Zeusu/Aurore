package net.aurore.messager;

import net.aurore.util.TitleTextList;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

public interface Messager {

	public void reply(Message message, String msg);
	
	public void send(MessageChannel channel, String msg);
	
	public void sendEmbed(MessageChannel channel, String msg);
	
	public void sendEmbed(MessageChannel channel, String title, TitleTextList texts, String imageURL);
}
