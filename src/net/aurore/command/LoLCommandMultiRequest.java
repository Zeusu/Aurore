package net.aurore.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.aurore.entities.Context;
import net.dv8tion.jda.core.entities.Member;

public abstract class LoLCommandMultiRequest extends LoLCommand {

	private Map<String,Integer> indexes = new HashMap<String,Integer>();
	private Map<String,Map<Integer,Object>> entities = new HashMap<String,Map<Integer,Object>>();
	
	
	public LoLCommandMultiRequest(CommandManagerImpl manager) {
		super(manager);
		
	}
	
	@Override
	public void onInvoke(CommandContext context, String[] args, List<Member> mentioned) {
		if(isOk(context, args, mentioned)){
			String userId = context.getAuthor().getId();
			indexes.put(userId, 0);
			entities.put(userId, new HashMap<Integer,Object>());
			execute(context,  args,  mentioned);
		}
	}

	@Override
	public void callback(Context<?> context, Object e) {
		Object o = context.getItem();
		if(!(o instanceof CommandContext)) return;
		CommandContext c = (CommandContext) o;
		root(indexes.get(c.getAuthor().getId()),c,e);
	}
	
	protected int getIndex(String userId){
		return indexes.get(userId);
	}
	
	protected void setIndex(String userId, int index){
		indexes.put(userId, index);
	}
	
	protected Object getEntity(String userId, int i){
		return entities.get(userId).get(i);
	}
	
	protected void store(String userId, int i, Object e){
		entities.get(userId).put(i, e);
	}

	public abstract void root(int rootIndex, CommandContext context, Object e); 

}
