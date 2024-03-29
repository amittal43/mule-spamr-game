package edu.gatech.spamr.model;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import edu.gatech.spamr.model.Map.MapType;
import edu.gatech.spamr.view.GameScreenUI;
import edu.gatech.spamr.view.MapUI;
import edu.gatech.spamr.view.StatPanel;

/** 
 * The Game class represents the actual application of the game.
 * 
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/22/2013 
 */

public class Game implements Serializable {
	
	/**
	 * Method creation for Serializable
	 */
	private static final long serialVersionUID = 5331329139065557361L;

	//keeping the gameScreenUI naming consistent as parent
	public  GameScreenUI parent;
	
	//turn & round variables
	public  Round currentRound = new Round();		//game starts in round 0
	public  int currentTurn = 0;			//game starts with the first player going
	public  int numRounds = 6;           //initialize at default number of rounds
	public final int MAX_TURNS = 4;			//we assume a 4 player game so it has 4 turns per round
	public  Store store = new Store();
	
	//creates player object for each person
	public  Player player1 = new Player();
	public  Player player2 = new Player();
	public  Player player3 = new Player();
	public  Player player4 = new Player();
	
	//play order
	public  Player[] playOrder = new Player[]{player1, player2, player3, player4};
	public  Player currentPlayer = playOrder[currentTurn];

	
	//stores what map the game is going to use and the difficulty level
	public  Map gameMap = new Map(MapType.DEFAULT);
	//public  MapUI gameMapUI = new MapUI();
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
	
	/**
	 * Should be called at the end of a player's turn once 
	 * to update who's turn it is and what round the game is in
	 * it also updates the order of play
	 */
	public  void updateTurn(){
		if (currentTurn >= 3){
			currentRound.nextRound();//updates the round number
			playOrder = currentRound.calcTurn(player1, player2, player3, player4);
			currentTurn = 0;
			
			//System.out.println(parent);
			//System.out.println(parent.getTsui());
			parent.getTsui().setFire(0);
			//System.out.println("playOrder");
			//System.out.println(playOrder);
			ArrayList playEffect = currentRound.RandomRoundEvent(playOrder, parent.getTsui());
			int food = 0;
			int energy = 0;
			int ore = 0;
			if (playEffect.get(0) != null && (int)playEffect.get(0) == 6){	//saving resources to be set to
				food = ((Player)playEffect.get(0)).getFoodQuantity();
				energy = ((Player)playEffect.get(0)).getEnergyQuantity();
				ore = ((Player)playEffect.get(0)).getOreQuantity();
			}
			if((int)playEffect.get(1) != 3){
				for(Tile tile : gameMap.getMapArray()){
					tile.processProduction();
				}
			}
			if (playEffect.get(0) != null && (int)playEffect.get(0) == 6){ //reseting resources to before production
				((Player)playEffect.get(0)).setFoodQuantity(food);
				((Player)playEffect.get(0)).setEnergyQuantity(energy);
				((Player)playEffect.get(0)).setOreQuantity(ore);
			}
			if( (int)playEffect.get(1) == 1){
				store.setOreQuantity(0);
			}
			
		} else {
			currentTurn++;
		}
		currentPlayer = playOrder[currentTurn];
		StatPanel.getInstance().updateStats(currentPlayer);
	}
	
	public  void calcTurnOrder(){
		playOrder = currentRound.calcTurn(player1, player2, player3, player4);
	}

	public void save(String filename){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Game load(String filename){
		Game game = null;
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			game = (Game) in.readObject();
		} 
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		
		return game;
	}
	
	/**
	 * determines play order based off of score
	 * in the case of a tie in score the person who acted last in the previous turn has priority
	 * @param players
	 */
	
	
	//TODO make a real score heuristic
	public  int scorePlayer(Player playerToRate){
		return playerToRate.getMoney()/100; //currently just keeps reversing turn order
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
	
	public void setMap(Map m){
		gameMap = m;
	}
	
	public void setMapType(MapType type){
		gameMap.setMapType(type);
	}
	
	/*public  MapUI getMapUI(){
		return gameMapUI;
	}*/
	
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
	
	public  GameScreenUI getParent(){
		return parent;
	}
	
	public  void setParent(GameScreenUI p){
		parent = p;
	}

	
	//player gets so their data can be updated by player class getters and setters
	public  Player getPlayer1(){
		return player1;
	}
	public  Player getPlayer2(){
		return player2;
	}
	public  Player getPlayer3(){
		return player3;
	}
	public  Player getPlayer4(){
		return player4;
	}

	public  Store getStore() {
		return store;
	}
}
