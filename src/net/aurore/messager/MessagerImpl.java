package net.aurore.messager;

import net.aurore.util.TitleTextList;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

public class MessagerImpl implements Messager {
	
	private static EmbedFactory embedFactory = new EmbedFactory();

	@Override
	public void reply(Message message, String msg) {
		MessageBuilder builder = new MessageBuilder();
		builder.append(msg);
		execute(message.getChannel(), builder.build());
		
	}

	@Override
	public void send(MessageChannel channel, String msg) {
		MessageBuilder builder = new MessageBuilder();
		builder.append(msg);
		execute(channel, builder.build());
	}

	@Override
	public void sendEmbed(MessageChannel channel, String msg) {
		MessageBuilder builder = new MessageBuilder();
		builder.setEmbed(embedFactory.setEmbed(msg));
		execute(channel, builder.build());
		
	}

	@Override
	public void sendEmbed(MessageChannel channel, String title, TitleTextList texts, String imageURL) {
		MessageBuilder builder = new MessageBuilder();
		builder.setEmbed(embedFactory.setEmbed(title, texts, imageURL));
		execute(channel, builder.build());
	}
	
	private void execute(MessageChannel channel, Message msg){
		channel.sendMessage(msg).queue();
	}

	
}
