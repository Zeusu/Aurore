package net.aurore.event;

import net.dv8tion.jda.core.events.Event;

public interface EventManager {

	public void process(String identifier, Event e);
	
}
