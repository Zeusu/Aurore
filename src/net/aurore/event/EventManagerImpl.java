package net.aurore.event;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import net.dv8tion.jda.core.events.Event;
import net.aurore.core.node.AuroreNode;
import net.aurore.datamanager.DataManager;

public class EventManagerImpl implements EventManager {

	
	private static final String PACKAGE_PATH = "net.aurore.event";
	
	private AuroreNode node;
	
	private Map<String, List<EventProcessorI>> processors = new HashMap<String, List<EventProcessorI>>();
	
	protected EventManagerImpl(AuroreNode node){
		this.node = node;
		init();
	}
	
	private void init(){
		Reflections reflect = new Reflections(PACKAGE_PATH);
		Set<Class<?>> annotated = reflect.getTypesAnnotatedWith(EventProc.class);
		for(Class<?> clss : annotated){
			String identifier = clss.getAnnotation(EventProc.class).value();
			EventProcessorI instance = null;
			try {
				instance = (EventProcessorI) clss.getConstructor(this.getClass()).newInstance(this);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			if(instance != null){
				addProcessor(identifier,instance);
			}
		}
	}
	
	private void addProcessor(String identifier, EventProcessorI instance){
		if(processors.get(identifier) != null) processors.get(identifier).add(instance);
		else{
			List<EventProcessorI> l = new ArrayList<EventProcessorI>();
			l.add(instance);
			processors.put(identifier, l);
		}
	}
	
	@Override
	public void process(String identifier, Event e) {
		if (processors.get(identifier) != null) {
			for (EventProcessorI proc : processors.get(identifier)) {
				try {
					node.useThread(new Runnable() {
						@Override
						public void run() {
							proc.process(e);
						}
					});
				} catch (Exception exp) {
					System.err.println("Event internal error");
					exp.printStackTrace();
				}

			}
		}

	}
	
	protected AuroreNode getNode(){
		return node;
	}
	
	public DataManager getDM(){
		return node.getDataManager();
	}

}
