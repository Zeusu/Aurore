package net.aurore.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.reflections.Reflections;

public final class ConfigManager {

	
	private static final String REGEX_PROPERTIES = "(.*)(\\.)properties";
	private static final String SETTER = "set";
	
	private static final Map<String, AbstractConfig> CONFIGS = new HashMap<String, AbstractConfig>();
	private static boolean isInit = false;
	
	static{
		init();
	}
	
	public static AbstractConfig getConfig(String key){
		return CONFIGS.get(key);
	}
	
	public static void saveConfig(String key, AbstractConfig c){
		CONFIGS.put(key, c);
	}
	
	public static void init(){
		if(!isInit){
			Reflections reflect = new Reflections();
			Set<Class<?>> clss = reflect.getTypesAnnotatedWith(ConfigClass.class);
			for(Class<?> c : clss){
				ConfigClass a = c.getAnnotation(ConfigClass.class);
				try {
					loadProperties(a.path(), c, a.key());
				} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException | IOException e) {
					e.printStackTrace();
				}
			}
			isInit = true;
		}
	}
	
	public static void reload() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException{
		for(Map.Entry<String, AbstractConfig> e : CONFIGS.entrySet()){
			loadProperties(e.getValue().getSource().getAbsolutePath(), e.getValue().getClass(),e.getKey(), e.getValue());
		}
	}
	
	public static AbstractConfig loadProperties(String path, Class<?> cls, String key) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException{
		AbstractConfig o = (AbstractConfig) cls.newInstance();
		return loadProperties(path, cls, key,o);
	}
	
	private static AbstractConfig loadProperties(String path, Class<?> cls, String key,AbstractConfig o) throws NoSuchMethodException, SecurityException, IOException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if(AbstractConfig.class.isAssignableFrom(cls)){
			if (path.matches(REGEX_PROPERTIES)) {
				InputStream fichierProperties = Thread.currentThread().getContextClassLoader()
						.getResourceAsStream("../" + path);
				Properties properties = new Properties();
				properties.load(fichierProperties);
				for (Field field : cls.getDeclaredFields()) {
					field.setAccessible(true);
					if (field.isAnnotationPresent(Property.class)) {
						Method setter = cls.getMethod(
								SETTER + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1),
								field.getType());
						setter.setAccessible(true);
						String propertyName = field.getAnnotation(Property.class).value();
						if (propertyName.equals(""))
							propertyName = field.getName();
						invoke(o, setter, field.getType(), properties.getProperty(propertyName));
					}
				}
				saveConfig(key,o);
				return o;
			}
			return null;
		}
		return null;
	}
	
	
	private static void invoke(Object o, Method method, Class<?> type, String value) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if (type.equals(double.class) || type.equals(Double.class)) {
			method.invoke(o, Double.parseDouble(value));
		} 
		
		else if (type.equals(float.class) || type.equals(Float.class)) {
			method.invoke(o, Float.parseFloat(value));
		} 
		
		else if (type.equals(long.class) || type.equals(Long.class)) {
			method.invoke(o, Long.parseLong(value));
		} 
		
		else if (type.equals(int.class) || type.equals(Integer.class)) {
			method.invoke(o, Integer.parseInt(value));
		} 
		
		else if (type.equals(short.class) || type.equals(Short.class)) {
			method.invoke(o, Short.parseShort(value));
		} 
		
		else if (type.equals(byte.class) || type.equals(Byte.class)) {
			method.invoke(o, Byte.parseByte(value));
		} 
		
		else if (type.equals(char.class) || type.equals(Character.class)) {
			method.invoke(o, value.charAt(0));
		} 
		
		else if (type.equals(boolean.class) || type.equals(Boolean.class)) {
			method.invoke(o, Boolean.parseBoolean(value));
		} 
		
		else if (type.equals(String.class)) {
			method.invoke(o, value);
		} 
	}
	
}
