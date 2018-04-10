package net.aurore.command;

import java.util.List;

import net.aurore.datamanager.DataManager;
import net.aurore.lolservice.AuroreLoLService;
import net.dv8tion.jda.core.entities.Member;

public abstract class LoLCommand extends AbstractCommandImpl{

	public LoLCommand(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public void onInvoke(CommandContext context, String[] args, List<Member> mentioned) {
		if(isOk(context, args, mentioned)){
			execute(context,  args,  mentioned);
		}
	}
	
	public abstract void execute(CommandContext context, String[] args, List<Member> mentioned);
	
	protected AuroreLoLService getLoLService(){
		return getCommandManager().getLoLService();
	}
	
	protected DataManager getDM(){
		return getCommandManager().getDM();
	}
	
}
