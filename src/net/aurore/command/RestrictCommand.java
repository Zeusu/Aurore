package net.aurore.command;

import java.util.List;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;

public abstract class RestrictCommand extends AbstractCommandImpl {

	private static final String PERMSSIONS_TO_LOW = "Vous n'avez pas les permissions !";
	
	
	public RestrictCommand(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public void onInvoke(CommandContext context, String[] args, List<Member> mentioned) {
		if(checkPermission(permissions(), context)){
			if(isOk(context,args,mentioned)){
				execute(context,args,mentioned);
			}
		}else{
			this.reply(context.getMsg(), PERMSSIONS_TO_LOW);
		}

	}
	
	private boolean checkPermission(Permission[] perms, CommandContext context){
		for(Permission p : perms){
			if(context.getMember().hasPermission(p)) return true;
		}
		return false;
	}
	
	protected abstract void execute(CommandContext context, String[] args, List<Member> mentioned);
	
	protected abstract Permission[] permissions();
	
}
