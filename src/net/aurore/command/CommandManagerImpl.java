package net.aurore.command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.reflections.Reflections;

import net.aurore.core.node.AuroreNode;
import net.aurore.lolservice.AuroreLoLService;
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
	public void runCommand(CommandContext context, String identifier) {
		if(hasCommand(identifier)){
			try{
				commands.get(identifier).onInvoke(context, context.getMsg().getContentRaw().split(" "), context.getMsg().getMentionedMembers());
			}catch(Exception e){
				System.err.println("Command internal error");
			}
		}

	}
	
	private boolean hasCommand(String identifier){
		return (commands.get(identifier) != null);
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
	
	public String getSelfId(){
		return node.getSelfId();
	}
	
}
