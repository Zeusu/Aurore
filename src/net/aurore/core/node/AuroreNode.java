package net.aurore.core.node;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import com.neovisionaries.ws.client.WebSocketFactory;

import net.aurore.command.CommandManager;
import net.aurore.command.CommandManagerBuilder;
import net.aurore.datamanager.DataManager;
import net.aurore.event.EventManager;
import net.aurore.event.EventManagerBuilder;
import net.aurore.lolservice.AuroreLoLService;
import net.aurore.messager.Messager;
import net.aurore.messager.MessagerImpl;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.impl.JDAImpl;
import net.dv8tion.jda.core.utils.SessionController;
import okhttp3.OkHttpClient.Builder;


public class AuroreNode extends JDAImpl{
	
	private int nodeId;
	
	private static int totalNodes;
	
	private Map<String, CommandManager> commandManagers = new HashMap<String, CommandManager>();
	
	private Map<String, EventManager> eventManagers = new HashMap<String, EventManager>();
	
	private Messager messager = new MessagerImpl();
	
	private AuroreLoLService LoLService;
	
	private DataManager dm;
	
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
			commandManagers.put(guild.getId(), new CommandManagerBuilder().build(this));
			eventManagers.put(guild.getId(), new EventManagerBuilder().build(this));
			System.out.println(guild.getId());
		}
	}
	
	public int getNodeId(){
		return nodeId;
	}
	
	public Messager getMessager(){
		return messager;
	}

	public CommandManager getCommandManager(String id) {
		return commandManagers.get(id);
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
}
