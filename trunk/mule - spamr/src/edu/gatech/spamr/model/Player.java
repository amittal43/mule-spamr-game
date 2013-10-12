package edu.gatech.spamr.model;

public class Player {

	//data
	private String name;
	private Race race;
	private Difficulty diff;
	private PlayerColor color;
	private int money;
	private int food;
	private int energy;
	private int ore;
	
	//array of Tile's which the player owns
	
	//enums
	public enum Race{PACKER, SPHEROID, HUMANOID, LEGGITE, FLAPPER, BONZOID, MECHTRON, GOLLUMER};
	public enum Difficulty{BEGINNER, STANDARD, TOURNAMENT};
	public enum PlayerColor{BLUE, GREEN, RED, YELLOW};
	
	public Player(){
		name = null;
		race = null;
		diff = null;
		color = null;
		money = 0;
		food = 0;
		energy = 0;
		ore = 0;
	}
	
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
	
	public PlayerColor getColor(){
		return color;
	}
	
	public void setColor(PlayerColor c){
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




