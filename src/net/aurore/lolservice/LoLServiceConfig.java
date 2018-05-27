package net.aurore.lolservice;


import net.aurore.util.AbstractConfig;
import net.aurore.util.ConfigClass;
import net.aurore.util.Property;

@ConfigClass(key = LoLServiceConfig.KEY, path = LoLServiceConfig.PATH)
public class LoLServiceConfig extends AbstractConfig {

	private static final long serialVersionUID = 1L;
	
	public static final String PATH = "lolConfig.properties";
	
	public static final String KEY = "lolConfig";

	@Property
	private String origin = null;
	
	@Property
	private String charset = "application/x-www-form-urlencoded; charset=UTF-8";
	
	@Property
	private String token = "";
	
	@Property
	private String language = "fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3";
	
	@Property
	private String useragent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0";
	

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getUseragent() {
		return useragent;
	}

	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}
}
