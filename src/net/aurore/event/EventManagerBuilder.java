package net.aurore.event;

import net.aurore.core.node.AuroreNode;

public class EventManagerBuilder {

	public EventManagerImpl build(AuroreNode node){
		return new EventManagerImpl(node);
	}
	
}
