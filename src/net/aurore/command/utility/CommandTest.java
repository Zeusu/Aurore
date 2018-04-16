package net.aurore.command.utility;

import java.math.BigInteger;
import java.util.List;

import net.aurore.command.AbstractCommandImpl;
import net.aurore.command.Command;
import net.aurore.command.CommandCat;
import net.aurore.command.CommandContext;
import net.aurore.command.CommandI;
import net.aurore.command.CommandManagerImpl;
import net.aurore.entities.Context;
import net.aurore.lolservice.AuroreLoLListener;
import net.aurore.lolservice.AuroreLoLResponseHandler;
import net.aurore.lolservice.entities.AuroreLoLEntity;
import net.aurore.lolservice.entities.Summoner;
import net.dv8tion.jda.core.entities.Member;

@Command("test")
@SuppressWarnings("unused")
public class CommandTest extends AbstractCommandImpl implements AuroreLoLListener {
	
	public static int instances = 0;

	private static final BigInteger TEST_MATCH = new BigInteger("3550152327");
	private final int ID;
	
	public CommandTest(CommandManagerImpl manager) {
		super(manager);
		ID = instances;
		instances += 1;
	}
	
	@Override
	public void onInvoke(CommandContext context, String[] args,List <Member> mentioned) {
		/*for(int i = 0; i < 200; i++){ 
			this.getCommandManager().getLoLService().testRequest();
		}*/
		/*Match m = this.getCommandManager().getLoLService().matchByMatchId(TEST_MATCH);
		if(m != null){
			getCommandManager().getDM().saveAuroreMatch(new AuroreMatch(m));
		}*/
		//System.out.println(getCommandManager().getDM().retrieveMatchList().get(0));
		
		//getCommandManager().getLoLService().matchesByMatchId(TEST_MATCH);
		
		getCommandManager().getLoLService().summonerByName("Riasu sama",new Context<CommandContext>(context),key());

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

	@Override
	public String key() {
		return getClass().getName() + ID;
	}

	@Override
	public void callback(Context<?> context, Object e) {
		Object o = context.getItem();
		if(!(o instanceof CommandContext)) return;
		CommandContext c = (CommandContext) o;
		if(!(e instanceof Summoner)) return;
		Summoner s = (Summoner) e;
		
		send(c.getChannel(), "Summoner name: " +  s.getName());
		
	}

}
