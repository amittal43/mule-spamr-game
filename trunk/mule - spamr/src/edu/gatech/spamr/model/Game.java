package edu.gatech.spamr.model;

public class Game {

	private int currentRound = 1;	//game starts in round 1 
	private int currentTurn = 1;	//game starts with the first player going
	private final int MAX_TURNS = 4;
	
	
	
	//Should be called at the end of a player's turn once to update who's turn it is and what round the game is in
	public void updateTurn(){
		if (currentTurn == 4){
			currentTurn = 1;
			currentRound++;
		} else {
			currentTurn++;
		}
	}
	
	public int getCurrentTurn(){
		return currentTurn;
	}
	
	public int getCurrentRound(){
		return currentRound;
	}

	
}
