package net.aurore.entities;

@SuppressWarnings("serial")
public class InvalidValueException extends Exception {
	
	private String invalideName;
	private String value;
	
	public InvalidValueException(String name, String value) {
		invalideName = name;
		this.value = value;
	}

	public String getInvalideName() {
		return invalideName;
	}

	public void setInvalideName(String invalideName) {
		this.invalideName = invalideName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
