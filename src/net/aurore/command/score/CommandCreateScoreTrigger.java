package net.aurore.command.score;

import java.util.List;

import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.command.RestrictCommand;
import net.aurore.entities.InvalidBlockException;
import net.aurore.entities.InvalidPropertyException;
import net.aurore.entities.InvalidValueException;
import net.aurore.entities.ScoreTrigger;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;

@Command("createScoreTrigger")
public class CommandCreateScoreTrigger extends RestrictCommand {

	public CommandCreateScoreTrigger(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatHelp() {
		return CommandCat.CONFIG.toString();
	}

	@Override
	protected void execute(CommandContext context, String[] args, List<Member> mentioned) {
		try {
			ScoreTrigger trigger = ScoreTrigger.parse(parseArguments(args, 1),context.getGuild());
			if(trigger.getScoreAmount() != 0 && trigger.getRoleId() != 0){
				send(context.getChannel(), "Creating new score trigger, ScoreTrigger{" + trigger.toString() + "}");
				getDM().saveScoreTrigger(trigger);
			}else{
				send(context.getChannel(), "You must specify valid score amount or role");
			}
		} catch (InvalidBlockException e) {
			send(context.getChannel(), "InvalidBlockException");
		} catch (InvalidPropertyException e) {
			send(context.getChannel(), "InvalidPropertyException");
		} catch (InvalidValueException e) {
			send(context.getChannel(), "InvalidValueException");
		}
	}

	@Override
	protected Permission[] permissions() {
		return new Permission[]{Permission.ADMINISTRATOR};
	}

	@Override
	protected boolean isOk(CommandContext context, String[] args, List<Member> mentioned) {
		return args.length > 1;
	}

}
