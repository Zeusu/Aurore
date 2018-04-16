package net.aurore.lolservice;

import net.aurore.entities.Context;

public interface AuroreLoLListener{

	public String key();
	
	public void callback(Context<?> context, Object e);
	
}
