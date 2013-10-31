package edu.gatech.spamr.model;

import edu.gatech.spamr.model.Map.MapType;
import edu.gatech.spamr.view.MapUI;

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
	private static Round currentRound = new Round();		//game starts in round 0
	private static int currentTurn = 0;			//game starts with the first player going
	private static int numRounds = 6;           //initialize at default number of rounds
	private final int MAX_TURNS = 4;			//we assume a 4 player game so it has 4 turns per round
	
	
	
	//creates player object for each person
	private static Player p1 = new Player();
	private static Player p2 = new Player();
	private static Player p3 = new Player();
	private static Player p4 = new Player();
	
	//play order
	private static Player[] playOrder = new Player[]{p1, p2, p3, p4};
	
	//stores what map the game is going to use and the difficulty level
	private static Map gameMap = new Map(MapType.DEFAULT);
	private static MapUI gameMapUI = new MapUI();
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
	public static void updateTurn(){
		if (currentTurn == 3){
			currentTurn = 0;
			currentRound.nextRound();//updates the round number
			decidePlayOrder(playOrder);//updates the order of play
		} else {
			currentTurn++;
		}
	}
	
	
	//should determine play order (if 2 players have the same score the later one moves up in turn order)
	public static void decidePlayOrder(Player[] players){
		int[] pscores = new int[players.length]; //array of player scores
		for(int i = 0; i < players.length; i++) {
			pscores[i] = scorePlayer(players[i]);
		}
		
		Player[] toReturn = new Player[players.length];
		for(int i = 0; i < players.length;i++){
			int min = 1000;
			int minInd = -1;
			for(int j = 0; j < players.length; j++) {
				min = Math.min(pscores[j],min);
				if (min == pscores[j])
					minInd = j;
			}
			toReturn[i] = players[minInd];
			pscores[minInd] = 1001;
		}
		playOrder = toReturn;
	}
	
	//TODO make a real score heuristic
	private static int scorePlayer(Player p){
		return p.getMoney()/100; //currently just keeps reversing turn order
	}
	
	
	
	//getters and setters 
	public static int getCurrentTurn(){
		return currentTurn;
	}
	
	public static Round getCurrentRound(){
		return currentRound;
	}
	
	//no setter for map as map class has a way to set type
	public static Map getMap(){
		return gameMap;
	}
	
	public static MapUI getMapUI(){
		return gameMapUI;
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
	
	//playorder getter/setters
	public Player[] getPlayOrder() {
		return playOrder;
	}
	
	public static Player getCurrentPlayer(){
		return playOrder[currentTurn];
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
