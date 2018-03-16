package net.aurore.command;

import net.aurore.core.node.AuroreNode;

public class CommandManagerBuilder {

	public CommandManagerImpl build(AuroreNode node){
		return new CommandManagerImpl(node);
	}
	
}
