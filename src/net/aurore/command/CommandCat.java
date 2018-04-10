package net.aurore.command;

public enum CommandCat {
	
	UTILITY("Utility"),
	MODERATION("Moderation"),
	TEST("Test"),
	LOL_UPDATE("League Of Legends Update"),
	LOL("League Of Legends");
	
	private String name;

	CommandCat(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
	
}
