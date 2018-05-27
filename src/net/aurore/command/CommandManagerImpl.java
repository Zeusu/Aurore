package net.aurore.command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.reflections.Reflections;

import net.aurore.core.AuroreConsoleMessages;
import net.aurore.core.Config;
import net.aurore.core.node.AuroreNode;
import net.aurore.datamanager.DataManager;
import net.aurore.entities.GuildConfig;
import net.aurore.lolservice.AuroreLoLListener;
import net.aurore.lolservice.AuroreLoLResponseHandler;
import net.aurore.lolservice.AuroreLoLService;
import net.aurore.util.ConfigManager;
import net.aurore.util.TitleTextList;

public class CommandManagerImpl implements CommandManager {
	
	private static final String PACKAGE_PATH = "net.aurore.command";
	
	private Map<String,CommandI> commands = new HashMap<String,CommandI>();
	
	private AuroreNode node;
	
	
	protected CommandManagerImpl(AuroreNode node){
		this.node = node;
		init();
	}
	
	private void init(){
		Reflections reflect = new Reflections(PACKAGE_PATH);
		Set<Class<?>> annotated = reflect.getTypesAnnotatedWith(Command.class);
		for(Class<?> clss : annotated){
			String identifier = clss.getAnnotation(Command.class).value();
			CommandI instance = null;
			try {
				instance = (CommandI) clss.getConstructor(this.getClass()).newInstance(this);
				if(AuroreLoLListener.class.isAssignableFrom(clss)){
					AuroreLoLResponseHandler.addListener((AuroreLoLListener) instance);
				}
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			if(instance != null){
				commands.put(identifier,instance);
			}
		}
	}
	
	@Override
	public void runCommand(CommandContext context, String identifier, GuildConfig c) {
		char defaultPrefix = ((Config)ConfigManager.getConfig(Config.KEY)).getPrefix();
		int prefixLength = 1;
		boolean globalPrefix = false;
		if(identifier.matches(""+c.getPrefix() + ".*")){
			prefixLength = c.getPrefix().length();
		}else if(identifier.matches(defaultPrefix + ".*")){
			globalPrefix = true;
		}else{
			return;
		}
		final String commandName =  identifier.substring(prefixLength);
		if (hasCommand(commandName)) {
			if (!globalPrefix || globalPrefix && isGlobalCommand(commandName)) {
				try {
					node.useThread(new Runnable() {
						@Override
						public void run() {
							try{
								commands.get(commandName).onInvoke(context, context.getMsg().getContentRaw().split(" "),
										context.getMsg().getMentionedMembers());
							}catch(Exception e){
								System.err.println("Command internal error");
								e.printStackTrace();
							}
							AuroreConsoleMessages
									.add("[Aurore] " + context.getAuthor().getName() + " try to execute command: "
											+ commandName + " on " + context.getGuild().getName());
						}
					});
				} catch (Exception e) {
					System.err.println("Command internal error");
					e.printStackTrace();
				}
			}
		}
	}
	
	private boolean hasCommand(String identifier){
		return (commands.get(identifier) != null);
	}
	
	private boolean isGlobalCommand(String identifier){
		return !commands.get(identifier).getClass().getAnnotation(Command.class).local();
	}
	
	protected AuroreNode getNode(){
		return node;
	}

	@Override
	public TitleTextList getCommands() {
		TitleTextList result = new TitleTextList();
		for(Entry<String, CommandI> entry : commands.entrySet()){
			result.addNode(entry.getValue().getCatHelp(), entry.getKey());
		}
		return result;
	}
	
	public AuroreLoLService getLoLService(){
		return node.getLoLService();
	}
	
	public DataManager getDM(){
		return node.getDataManager();
	}
	
	public String getSelfId(){
		return node.getSelfId();
	}
	
}
