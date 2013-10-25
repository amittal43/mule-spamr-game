package edu.gatech.spamr.model;

import edu.gatech.spamr.model.Map.MapType;

/** 
 * The Game class represents the actual application of the game
 * 
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/22/2013 
 */

public class Game {
	
	//turn & round variables
	private static int currentRound = 1;		//game starts in round 1 
	private static int currentTurn = 1;			//game starts with the first player going
	private static int numRounds = 6;           //initialize at default number of rounds
	private final int MAX_TURNS = 4;			//we assume a 4 player game so it has 4 turns per round
	
	//creates player object for each person
	private static Player p1 = new Player();
	private static Player p2 = new Player();
	private static Player p3 = new Player();
	private static Player p4 = new Player();
	
	//stores what map the game is going to use and the difficulty level
	private static Map gameMap = new Map(MapType.DEFAULT);
	private static Difficulty diff;
	
	//creates and describes the Difficulty enum
	//each enum holds the starting food and energy for players in the game
	public enum Difficulty{BEGINNER(8,4,6), STANDARD(4,2,12), TOURNAMENT(4,2,12);
		
		private final int startingFood;
		private final int startingEnergy;
		private final int numRounds;
		
		Difficulty(int food, int energy, int rounds){
			startingFood = food;
			startingEnergy = energy;
			numRounds = rounds;
		}
		
		public int getStartingFood(){
			return startingFood;
		}
		
		public int getStartingEnergy(){
			return startingEnergy;
		}
		
		public int getNumRounds(){
			return numRounds;
		}
	}
	
	//Should be called at the end of a player's turn once to update who's turn it is and what round the game is in
	public void updateTurn(){
		if (currentTurn == 4){
			currentTurn = 1;
			currentRound++;
		} else {
			currentTurn++;
		}
	}
	
	//getters and setters 
	public static int getCurrentTurn(){
		return currentTurn;
	}
	
	public static int getCurrentRound(){
		return currentRound;
	}
	
	//no setter for map as map class has a way to set type
	public static Map getMap(){
		return gameMap;
	}
	
	public static Difficulty getDifficulty(){
		return diff;
	}
	
	public static void setDifficulty(Difficulty d){
		diff = d;
	}
	
	public static void setNumRounds(int rounds){
		numRounds = rounds;
	}
	
	public static int getNumRounds(){
		return numRounds;
	}
	
	//player gets so their data can be updated by player class getters and setters
	public static Player getPlayer1(){
		return p1;
	}
	public static Player getPlayer2(){
		return p2;
	}
	public static Player getPlayer3(){
		return p3;
	}
	public static Player getPlayer4(){
		return p4;
	}
}
