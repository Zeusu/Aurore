package net.aurore.util;

import java.io.File;
import java.io.Serializable;

public abstract class AbstractConfig implements Serializable{

	private static final long serialVersionUID = -5004516909335847945L;
	
	private File source;
	
	public AbstractConfig(){
		
	}
	
	protected void init(String path){
		setSource(new File(path));
	}

	protected File getSource() {
		return source;
	}

	protected void setSource(File source) {
		this.source = source;
	}
	
}
