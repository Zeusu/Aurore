package net.aurore.event;

import net.dv8tion.jda.core.events.Event;

public interface EventProcessorI {

	
	public abstract void process(Event event);
	
}
