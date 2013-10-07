package edu.gatech.spamr.model;

public class Player {

	private String name;
	private Race race;
	private Difficulty diff;
	private Color color;
	public enum Race{PACKER, SPHEROID, HUMANOID, LEGGITE, FLAPPER, BONZOID, MECHTRON, GOLLUMER};
	public enum Difficulty{BEGINNER, STANDARD, TOURNAMENT};
	public enum Color{BLUE, GREEN, RED, YELLOW};
	
	public String getName(){
		return name;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public Race getRace(){
		return race;
	}
	
	public void setRace(Race r){
		race = r;
	}
	
	public Difficulty getDifficulty(){
		return diff;
	}
	
	public void setDifficulty(Difficulty d){
		diff = d;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color c){
		color = c;
	}
}