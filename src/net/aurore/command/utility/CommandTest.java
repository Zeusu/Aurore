package net.aurore.command.utility;

import java.math.BigInteger;
import java.util.List;

import net.aurore.command.AbstractCommandImpl;
import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandManagerImpl;
import net.aurore.entities.AuroreMatch;
import net.aurore.lolservice.entities.Match;
import net.dv8tion.jda.core.entities.Member;

@Command("test")
public class CommandTest extends AbstractCommandImpl {

	private static final BigInteger TEST_MATCH = new BigInteger("3550152327");
	
	
	public CommandTest(CommandManagerImpl manager) {
		super(manager);
	}

	@Override
	public void onInvoke(CommandContext context, String[] args,List <Member> mentioned) {
		/*for(int i = 0; i < 200; i++){ 
			this.getCommandManager().getLoLService().testRequest();
		}*/
		Match m = this.getCommandManager().getLoLService().matchByMatchId(TEST_MATCH);
		if(m != null){
			getCommandManager().getDM().saveAuroreMatch(new AuroreMatch(m));
		}
		
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
