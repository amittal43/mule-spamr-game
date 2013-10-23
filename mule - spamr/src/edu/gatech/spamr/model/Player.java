package edu.gatech.spamr.model;

public class Player {

	//data
	private String name;
	private int playerNum;
	private Race race;
	private Difficulty diff;
	private PlayerColor color;
	private int money;
	private int food;
	private int energy;
	private int ore;

	//enums
	public enum Race{PACKER(1000), SPHEROID(1000), HUMANOID(600), LEGGITE(1000), FLAPPER(1600), BONZOID(1000), MECHTRON(1000), GOLLUMER(1000);
	private final int startingMoney;
	
	Race(int s){
		startingMoney = s;
	}
	
	public int getStartingMoney(){
		return startingMoney;
	}
	
	}
	public enum Difficulty{BEGINNER(8,4), STANDARD(4,2), TOURNAMENT(4,2);
	
	private final int startingFood;
	private final int startingEnergy;
	
	Difficulty(int food, int energy){
		startingFood = food;
		startingEnergy = energy;
	}
	
	public int getStartingFood(){
		return startingFood;
	}
	
	public int getStartingEnergy(){
		return startingEnergy;
	}
	
	}
	
	public enum PlayerColor{BLUE, GREEN, RED, YELLOW};
	
	//constructors
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
	
	public int getPlayerNum(){
		return playerNum;
	}
	
	public void setPlayerNum(int num){
		playerNum = num;
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




