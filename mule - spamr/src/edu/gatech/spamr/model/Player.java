package edu.gatech.spamr.model;

public class Player {

	//data
	private String name;
	private Race race;
	private Difficulty diff;
	private Color color;
	private int money;
	private int food;
	private int energy;
	private int ore;
	
	//array of Tile's which the player owns
	
	//enums
	public enum Race{PACKER, SPHEROID, HUMANOID, LEGGITE, FLAPPER, BONZOID, MECHTRON, GOLLUMER};
	public enum Difficulty{BEGINNER, STANDARD, TOURNAMENT};
	public enum Color{BLUE, GREEN, RED, YELLOW};
	
	
	//getters and setters
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
	
	public int getMoney(){
		return money;
	}
	
	public void setMoney(int m){
		money = m;
	}
	
	public int getFood(){
		return food;
	}
	
	public void setFood(int f){
		food = f;
	}
	
	public int getEnergy(){
		return energy;
	}
	
	public void setEnergy(int e){
		energy = e;
	}
	
	public int getOre(){
		return ore;
	}
	
	public void setOre(int o){
		ore = o;
	}
	
}




