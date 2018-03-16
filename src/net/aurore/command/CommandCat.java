package net.aurore.command;

public enum CommandCat {
	
	UTILITY("Utility"),
	MODERATION("Moderation"),
	TEST("Test");
	
	private String name;

	CommandCat(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
	
}
