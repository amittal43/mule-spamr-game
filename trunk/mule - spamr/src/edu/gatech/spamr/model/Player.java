package edu.gatech.spamr.model;

public class Player {

	private String name;
	private String race;
	private enum race{PACKER, SPHEROID, HUMANOID, LEGGITE, FLAPPER, BONZOID, MECHTRON, GOLLUMER};
	public enum difficulty{BEGINNER, STANDARD, TOURNAMENT};
	private enum color{BLUE, GREEN, RED, YELLOW};
	
	public String getName(){
		return name;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public String getRace(){
		return race;
	}
	
	public void setRace(String n){
		race = n;
	}
	
}
