package edu.gatech.spamr.model;

import edu.gatech.spamr.model.Map.MapType;
import edu.gatech.spamr.view.GameScreenUI;
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
	
	//keeping the gameScreenUI naming consistent as parent
	public  GameScreenUI parent;
	
	//turn & round variables
	public  Round currentRound = new Round();		//game starts in round 0
	public  int currentTurn = 0;			//game starts with the first player going
	public  int numRounds = 6;           //initialize at default number of rounds
	public final int MAX_TURNS = 4;			//we assume a 4 player game so it has 4 turns per round
	public  Store store;
	
	//creates player object for each person
	public  Player p1 = new Player();
	public  Player p2 = new Player();
	public  Player p3 = new Player();
	public  Player p4 = new Player();
	
	//play order
	public  Player[] playOrder = new Player[]{p1, p2, p3, p4};
	public  Player currentPlayer = playOrder[currentTurn];
	
	//Timer used for each turn
	public  Thread turnTimer;
	
	//stores what map the game is going to use and the difficulty level
	public  Map gameMap = new Map(MapType.DEFAULT);
	public  MapUI gameMapUI = new MapUI();
	public  Difficulty diff = Difficulty.TOURNAMENT;
	
	
	//creates and describes the Difficulty enum
	//each enum holds the starting food and energy for players in the game
	public enum Difficulty{BEGINNER(8,4,6,16,16,0,25), STANDARD(4,2,12,8,8,8,14), TOURNAMENT(4,2,12,8,8,8,14);
		
		public final int startingFood;
		public final int startingEnergy;
		public final int numRounds;
		public final int storeFood;
		public final int storeEnergy;
		public final int storeOre;
		public final int storeMULE;
		
		Difficulty(int food, int energy, int rounds, int sFood, int sEnergy, int sOre, int sMULE){
			startingFood = food;
			startingEnergy = energy;
			numRounds = rounds;
			storeFood = sFood;
			storeEnergy = sEnergy;
			storeOre = sOre;
			storeMULE = sMULE;
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
		
		public int getStoreFood(){
			return storeFood;
		}
		
		public int getStoreEnergy(){
			return storeEnergy;
		}
		
		public int getStoreOre(){
			return storeOre;
		}
		
		public int getStoreMULES(){
			return storeMULE;
		}
	}
	
	public  Store shop = new Store();
	
	/**
	 * Should be called at the end of a player's turn once 
	 * to update who's turn it is and what round the game is in
	 * it also updates the order of play
	 */
	public  void updateTurn(){
		if (currentTurn == 3){
			currentRound.nextRound();//updates the round number
			playOrder = currentRound.calcTurn(p1, p2, p3, p4);
			currentTurn = 0;
			
			for(Tile tile : gameMap.getMapArray()){
				tile.processProduction();
			}
			
		} else {
			currentTurn++;
		}
		currentPlayer = playOrder[currentTurn];
	}
	
	public  void calcTurnOrder(){
		playOrder = currentRound.calcTurn(p1, p2, p3, p4);
	}

	
	/**
	 * determines play order based off of score
	 * in the case of a tie in score the person who acted last in the previous turn has priority
	 * @param players
	 */
	
	
	//TODO make a real score heuristic
	public  int scorePlayer(Player p){
		return p.getMoney()/100; //currently just keeps reversing turn order
	}
	
	
	
	//getters and setters 
	public  int getCurrentTurn(){
		return currentTurn;
	}
	
	public  Round getCurrentRound(){
		return currentRound;
	}
	
	//no setter for map as map class has a way to set type
	public  Map getMap(){
		return gameMap;
	}
	
	public  MapUI getMapUI(){
		return gameMapUI;
	}
	
	public  Difficulty getDifficulty(){
		return diff;
	}
	
	public  void setDifficulty(Difficulty d){
		diff = d;
	}
	
	public  void setNumRounds(int rounds){
		numRounds = rounds;
	}
	
	public  int getNumRounds(){
		return numRounds;
	}
	
	//playorder getter/setters
	public Player[] getPlayOrder() {
		return playOrder;
	}
	
	public  Player getCurrentPlayer(){
		return playOrder[currentTurn];
	}
	
	public  void setPlayerOrder(Player[] order){
		playOrder = order;
	}
	
	public  Thread getTurnTimer() {
		return turnTimer;
	}
	
	public  void setTurnTimer(Thread t){
		turnTimer = t;
	}
	
	public  GameScreenUI getParent(){
		return parent;
	}
	
	public  void setParent(GameScreenUI p){
		parent = p;
	}
	
	
	
	//player gets so their data can be updated by player class getters and setters
	public  Player getPlayer1(){
		return p1;
	}
	public  Player getPlayer2(){
		return p2;
	}
	public  Player getPlayer3(){
		return p3;
	}
	public  Player getPlayer4(){
		return p4;
	}

	public  Store getStore() {
		return shop;
	}
}
