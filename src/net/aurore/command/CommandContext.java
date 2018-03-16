package net.aurore.command;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class CommandContext{

	private User author;
	
	private MessageChannel channel;
	
	private Guild guild;
	
	private Member member;
	
	private Message msg;
	
	private long MessageId;
	
	private boolean isGuildChannel;
	
	public CommandContext(User author,MessageChannel channel, Guild guild, Member member, Message msg, long MessageId,boolean isGuildChannel){
		setAuthor(author);
		setChannel(channel);
		setGuild(guild);
		setMember(member);
		setMsg(msg);
		setMessageId(MessageId);
		setIsGuildChannel(isGuildChannel); 
	}

	protected void setIsGuildChannel(boolean bool) {
		this.isGuildChannel = bool;
	}
	
	public boolean isGuildChannel(){
		return this.isGuildChannel;
	}

	public User getAuthor() {
		return author;
	}

	protected void setAuthor(User author) {
		this.author = author;
	}

	public Guild getGuild() {
		return guild;
	}

	protected void setGuild(Guild guild) {
		this.guild = guild;
	}

	public Member getMember() {
		return member;
	}

	protected void setMember(Member member) {
		this.member = member;
	}

	public Message getMsg() {
		return msg;
	}

	protected void setMsg(Message msg) {
		this.msg = msg;
	}

	public long getMessageId() {
		return MessageId;
	}

	protected void setMessageId(long messageId) {
		MessageId = messageId;
	}
	
	public MessageChannel getChannel(){
		return this.channel;
	}

	protected void setChannel(MessageChannel channel) {
		this.channel = channel;
	}
	
}
