package net.aurore.entities;

@SuppressWarnings("serial")
public class InvalidPropertyException extends Exception{
	
	private String invalideName;
	
	public InvalidPropertyException(String name) {
		invalideName = name;
	}

	public String getInvalideName() {
		return invalideName;
	}

	public void setInvalideName(String invalideName) {
		this.invalideName = invalideName;
	}

}
