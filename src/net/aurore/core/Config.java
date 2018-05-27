package net.aurore.core;

import net.aurore.util.AbstractConfig;
import net.aurore.util.ConfigClass;
import net.aurore.util.Property;

@ConfigClass(key = Config.KEY, path = Config.CONFIG_PATH)
public final class Config extends AbstractConfig{

	private static final long serialVersionUID = 7817545549274942346L;

	public static final String KEY = "MAIN_CONFIG";
	
	public static final String CONFIG_PATH = "globalConfig.properties";

	@Property
	private char prefix = '>';
	
	@Property
	private String token = "";
	
	@Property
	private int textLimit = 2000;

	public char getPrefix() {
		return prefix;
	}

	public void setPrefix(char prefix) {
		this.prefix = prefix;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getTextLimit() {
		return textLimit;
	}

	public void setTextLimit(int textLimit) {
		this.textLimit = textLimit;
	}
	
}
