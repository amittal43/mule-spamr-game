package edu.gatech.spamr.model;

import java.awt.Color;

/** 
 * The Player class represents the an information holder which
 * contains all the player related information i.e. name, resources
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/22/2013 
 */

public class Player {

	//Player Variables
	private String name;
	private int playerNum;
	private Race race;
	private PlayerColor color;
	private int money;
	private int food;
	private int energy;
	private int ore;

	//Describes the enum Race
	public enum Race{PACKER(1000), SPHEROID(1000), HUMANOID(600), LEGGITE(1000), FLAPPER(1600), BONZOID(1000), MECHTRON(1000), GOLLUMER(1000);
		private final int startingMoney;
		
		Race(int s){
			startingMoney = s;
		}
		
		public int getStartingMoney(){
			return startingMoney;
		}
	}
	
	
	public enum PlayerColor{BLUE(Color.BLUE), GREEN(Color.GREEN), RED(Color.RED), YELLOW(Color.YELLOW), BLACK(Color.BLACK);
	
	private final Color col;
	
	PlayerColor(Color c){
		col = c;
	}
	
	public Color getRGB(){
		return col;
	}
	}
	
	//constructors
	public Player(){
		name = null;
		race = null;
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
	
	public void updateMoney(int n){ //updates the player's money.
		money += n;
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
	
	public int calcScore(){
		return (money/100) + ore + food + energy;
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
	

	public Color getRGB(){
		return color.getRGB();
	}
}

