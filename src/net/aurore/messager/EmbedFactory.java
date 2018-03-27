package net.aurore.messager;

import java.awt.Color;

import net.aurore.util.TitleTextList;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;

public class EmbedFactory {
	
	private static final Color COLOR = Color.decode("#550000");
	
	
	
	protected EmbedFactory(){}
	
	
	protected MessageEmbed setEmbed(String message){
		EmbedBuilder builder = new EmbedBuilder();
		builder.setColor(COLOR);
		builder.setDescription(message);
		return builder.build();
	}
	
	protected MessageEmbed setEmbed(String title, TitleTextList texts, String imageURL){
		EmbedBuilder builder = new EmbedBuilder();
		builder.setColor(COLOR);
		builder.setTitle(title);
		builder.setThumbnail(imageURL);
		for(String[] strs : texts){
			builder.addField(strs[0], strs[1], false);
		}
		return builder.build();
	}
}
