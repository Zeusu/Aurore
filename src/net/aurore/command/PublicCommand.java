package net.aurore.command;

import java.util.List;

import net.dv8tion.jda.core.entities.Member;

public abstract class PublicCommand extends AbstractCommandImpl {


	public PublicCommand(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public void onInvoke(CommandContext context, String[] args, List<Member> mentioned) {
		if(isOk(context, args, mentioned)){
			execute(context, args, mentioned);
		}

	}
	
	public abstract void execute(CommandContext context, String[] args, List<Member> mentioned);

}
