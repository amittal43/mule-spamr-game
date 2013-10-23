package edu.gatech.spamr.model;

import edu.gatech.spamr.model.Map.MapType;


public class Game {

	private static int currentRound = 1;		//game starts in round 1 
	private static int currentTurn = 1;			//game starts with the first player going
	private final int MAX_TURNS = 4;	
	private static Player p1 = new Player();
	private static Player p2 = new Player();
	private static Player p3 = new Player();
	private static Player p4 = new Player();
	private static Map gameMap = new Map(MapType.DEFAULT);
	private static Difficulty diff;
	
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
	
	public static Map getMap(){
		return gameMap;
	}
	
	public static Difficulty getDifficulty(){
		return diff;
	}
	
	public static void setDifficulty(Difficulty d){
		diff = d;
	}
	
	//player gets
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
