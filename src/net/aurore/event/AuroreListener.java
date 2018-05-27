package net.aurore.event;

import net.aurore.core.node.AuroreNode;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import net.aurore.command.CommandContext;

public class AuroreListener extends ListenerAdapter {
	
	private AuroreNode node;
	
	public AuroreListener(AuroreNode node){
		this.setNode(node);
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String rawMsg = event.getMessage().getContentRaw();
		if(rawMsg != null && !rawMsg.equals("")){
			onCommand(event, rawMsg.split(" ")[0], event.isFromType(ChannelType.PRIVATE));
		}
		node.emit(Events.ON_MESSAGE, event);
	}
	
	public AuroreNode getNode() {
		return node;
	}

	public void setNode(AuroreNode node) {
		this.node = node;
	}
	
	
	private void onCommand(MessageReceivedEvent event,String commandIdentifier,boolean isPM){
		CommandContext commandContext = new CommandContext(event.getAuthor(),
				event.getChannel(),
				event.getGuild(),
				event.getMember(),
				event.getMessage(),
				event.getMessageIdLong(),
				true);
		String identifier = commandIdentifier.split(" ")[0];
		if(!isPM){
			node.runCommand(commandContext,identifier);
		}
	}
	
	
}
