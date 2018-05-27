package net.aurore.command.fun;

import java.util.List;
import java.util.Random;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.PublicCommand;
import net.dv8tion.jda.core.entities.Member;

@Command("roll")
public class CommandRoll extends PublicCommand{

	private static final Random RANDOM = new Random();
	
	public CommandRoll(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.FUN.toString();
	}

	@Override
	public void execute(CommandContext context, String[] args, List<Member> mentioned) {
		int value = Integer.parseInt(args[1]);
		this.reply(context.getMsg(), new StringBuilder().appendCodePoint(0x1F3B2).toString() + " vous avez fait: " + (RANDOM.nextInt(value) + 1) + " !");
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return args.length == 2;
	}

}
