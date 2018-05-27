package net.aurore.command;

import java.util.List;

import net.aurore.entities.Context;
import net.aurore.lolservice.AuroreLoLListener;
import net.aurore.lolservice.AuroreLoLService;
import net.dv8tion.jda.core.entities.Member;

public abstract class LoLCommand extends AbstractCommandImpl implements AuroreLoLListener{

	private static int instances = 0;
	
	private final int ID;
	
	public LoLCommand(CommandManagerImpl manager) {
		super(manager);
		ID = instances;
		instances += 1;
	}

	@Override
	public void onInvoke(CommandContext context, String[] args, List<Member> mentioned) {
		if(isOk(context, args, mentioned)){
			execute(context,  args,  mentioned);
		}
	}
	
	
	public abstract void execute(CommandContext context, String[] args, List<Member> mentioned);
	
	@Override
	public String key() {
		return getClass().getName() + ID;
	}

	@Override
	public abstract void callback(Context<?> context, Object e);
	
	protected AuroreLoLService getLoLService(){
		return getCommandManager().getLoLService();
	}

}
