package net.aurore.core;


import javax.security.auth.login.LoginException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import net.aurore.core.node.AuroreNode;
import net.aurore.core.node.AuroreNodeBuilder;
import net.aurore.datamanager.DataManager;
import net.aurore.datamanager.DataManagerBuilder;
import net.aurore.event.AuroreListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.aurore.lolservice.AuroreLoLService;
import net.aurore.lolservice.AuroreLoLServiceImpl;
import net.aurore.util.ConfigManager;
import net.aurore.util.ThreadPoolManager;

@WebListener
public class AuroreCore implements ServletContextListener{
	
	public static final String INVITE_FULL_RIGHT = "https://discordapp.com/oauth2/authorize?client_id=413094559048925184&scope=bot&permissions=2146958591";
	
	public static final String INVITE_PREVISION_RIGHT = "https://discordapp.com/oauth2/authorize?client_id=413094559048925184&scope=bot&permissions=2080894150";
	
	private static final String GAME = "help for commands";
	
	private AuroreNode node;

	public AuroreCore(){
		ConfigManager.init();
		
		Config c = (Config) ConfigManager.getConfig(Config.KEY);
		
		DataManager manager = new DataManagerBuilder().build();
		AuroreNodeBuilder builder = (AuroreNodeBuilder) new AuroreNodeBuilder(AccountType.BOT).setToken(c.getToken());
		builder.setStatus(OnlineStatus.ONLINE);
		builder.setGame(Game.playing(c.getPrefix() + GAME));		
		try {
			node = (AuroreNode) builder.buildBlocking();
		} catch (LoginException | InterruptedException e) {
			e.printStackTrace();
		}
		node.addEventListener(new AuroreListener(node));
		node.setLoLService(((AuroreLoLService) new AuroreLoLServiceImpl()));
		node.init(manager);
		
		
	}


	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		AuroreConsoleMessages.add("[Aurore] Loaded");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		AuroreConsoleMessages.add("[Aurore] Is going to shutdown");
		ThreadPoolManager.shutdown();
		node.shutdownNow();
	}
}
