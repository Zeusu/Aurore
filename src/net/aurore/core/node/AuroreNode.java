package net.aurore.core.node;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.neovisionaries.ws.client.WebSocketFactory;

import net.aurore.command.CommandContext;
import net.aurore.command.CommandManager;
import net.aurore.command.CommandManagerBuilder;
import net.aurore.core.Config;
import net.aurore.datamanager.DataManager;
import net.aurore.entities.GuildConfig;
import net.aurore.event.EventManager;
import net.aurore.event.EventManagerBuilder;
import net.aurore.lolservice.AuroreLoLService;
import net.aurore.messager.Messager;
import net.aurore.messager.MessagerImpl;
import net.aurore.util.ConfigManager;
import net.aurore.util.ThreadPoolManager;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.impl.JDAImpl;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.utils.SessionController;
import okhttp3.OkHttpClient.Builder;


public class AuroreNode extends JDAImpl{
	
	private int nodeId;
	
	private static int totalNodes;
	
	private Messager messager = new MessagerImpl();
	
	private AuroreLoLService LoLService;
	
	private DataManager dm;
	
	private ThreadPoolExecutor commandPool = ThreadPoolManager.initiatePool(2, 2, 1, TimeUnit.NANOSECONDS);
	
	private CommandManager commandManager = new CommandManagerBuilder().build(this);
	
	private EventManager eventManager = new EventManagerBuilder().build(this);
	
	static{
		totalNodes = 0;
	}
	
	public AuroreNode(AccountType accountType, String token, SessionController controller, Builder httpClientBuilder,
			WebSocketFactory wsFactory, boolean autoReconnect, boolean audioEnabled, boolean useShutdownHook,
			boolean bulkDeleteSplittingEnabled, boolean retryOnTimeout, boolean enableMDC, int corePoolSize,
			int maxReconnectDelay, ConcurrentMap<String, String> contextMap) {
		super(accountType, token, controller, httpClientBuilder, wsFactory, autoReconnect, audioEnabled, useShutdownHook,
				bulkDeleteSplittingEnabled, retryOnTimeout, enableMDC, corePoolSize, maxReconnectDelay, contextMap);
		nodeId = totalNodes;
		totalNodes +=1;
	}
	
	public void init(DataManager dm){
		this.dm = dm;
		for(Guild guild : getGuilds()){
			if(dm.retrieveGuildConfigById(guild.getIdLong()) == null){
				createDefaultGuildConfig(guild);
			}
			System.out.println("[Aurore] connected to guild: " + guild.getName());
		}
	}
	
	private GuildConfig createDefaultGuildConfig(Guild guild){
		GuildConfig config = new GuildConfig();
		config.setGuildId(guild.getIdLong());
		config.setPrefix("" + ((Config) ConfigManager.getConfig(Config.KEY)).getPrefix());
		dm.saveGuildConfig(config);
		return config;
	}
	
	public int getNodeId(){
		return nodeId;
	}
	
	public Messager getMessager(){
		return messager;
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public void setLoLService(AuroreLoLService auroreLoLService) {
		LoLService = auroreLoLService;
	}
	
	public AuroreLoLService getLoLService(){
		return LoLService;
	}
	
	public String getSelfId(){
		return selfUser.getId();
	}
	
	public DataManager getDataManager(){
		return this.dm;
	}

	public void runCommand(CommandContext commandContext, String identifier) {
		if(!commandContext.getAuthor().isBot()){
			GuildConfig c = dm.retrieveGuildConfigById(commandContext.getGuild().getIdLong());
			if(c == null) c = createDefaultGuildConfig(commandContext.getGuild());
			commandManager.runCommand(commandContext, identifier,c);
		}
	}
	
	public void emit(String identifier, Event e){
		eventManager.process(identifier, e);
	}
	
	public void useThread(Runnable task){
		/*Future<?> f =*/ commandPool.submit(task);
		/*try {
			f.get(1, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			f.cancel(true);
		}*/
	}
}
