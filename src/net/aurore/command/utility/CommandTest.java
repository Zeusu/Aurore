package net.aurore.command.utility;

import java.util.List;

import net.aurore.command.AbstractCommandImpl;
import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.util.HibernateUtil;
import net.dv8tion.jda.core.entities.Member;

@Command("test")
public class CommandTest extends AbstractCommandImpl{
	
	public static int instances = 0;
	
	public CommandTest(CommandManagerImpl manager) {
		super(manager);
	}
	
	@Override
	public void onInvoke(CommandContext context, String[] args,List <Member> mentioned) {
		HibernateUtil.test();
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return true;
	}
	
	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.TEST.toString();
	}
}
