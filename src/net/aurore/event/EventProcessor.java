package net.aurore.event;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.Event;

public abstract class EventProcessor implements EventProcessorI{

	private EventManagerImpl manager;
	
	protected EventProcessor(EventManagerImpl manager){
		this.manager = manager;
	}
	
	
	public abstract void process(Event event);

	
	public EventManagerImpl getManager(){
		return manager;
	}
	
	protected void send(MessageChannel channel, String msg){
		manager.getNode().getMessager().send(channel, msg);
	}
	
}
