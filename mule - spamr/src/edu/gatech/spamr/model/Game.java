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
