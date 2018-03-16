package net.aurore.event;

import net.dv8tion.jda.core.events.Event;

public abstract class EventProcessor implements EventProcessorI{

	private EventManager manager;
	
	protected EventProcessor(EventManager manager){
		this.manager = manager;
	}
	
	
	public abstract void process(Event event);

	
	public EventManager getManager(){
		return manager;
	}
	
}
