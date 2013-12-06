package edu.gatech.spamr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import edu.gatech.spamr.view.StatPanel;
import edu.gatech.spamr.view.TownScreenUI;

/** 
 * The Round class represents turns that all 4 players go through 
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/22/2013 
 */

public class Round implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3247528578074538411L;
	public int roundNumber = 0;
	public final int[] foodRequirement = {3,3,3,3,4,4,4,4,5,5,5,5};
	public final int[] gamblingBonus = {50,50,50,100,100,100,100,150,150,150,150,200};
	public final int[] randomNumber = {25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75, 100};

	//randomRoundEvent data
	private int eventsLeft = 20;
	private int[] rEventProb = {15,10,15,15,15,10,10,10};
	private int[] rEventMax = {3,2,3,3,3,2,2,2};
	private int[] rEventOccured = new int[7];
	
	
	/**
	 * getRoundNumber method
	 * 
	 * @return roundNumber
	 */
	
	public int getRoundNumber(){
		return roundNumber;
	}
	
	public int getRandomNumber(){
		return randomNumber[roundNumber];
	}
	
	/**
	 * calcTurn method which calculates the players' turns based off the players' scores
	 * 
	 * @return turn of the player that should be starting
	 */

	public Player[] calcTurn(Player player1, Player player2, Player player3, Player player4){
		Player[] turn = new Player[4];	//stores players in order of score
		boolean[] notUsed = {true, true, true, true};
		//calculates score
		int score1 = player1.calcScore();
		int score2 = player2.calcScore();
		int score3 = player3.calcScore();
		int score4 = player4.calcScore();
		
		//sorts scores
		int array[] = {score1, score2, score3, score4};
		Arrays.sort(array);
		
		//matches score placement with player [
		for(int i =0;i<4;i++){
			if (array[i] == score1 && notUsed[0]) {
				turn[i]=player1;
				notUsed[0] = false;
			} else if(array[i] == score2 && notUsed[1]) {
				turn[i]=player2;
				notUsed[1] = false;
			} else if (array[i] == score3 && notUsed[2]) {
				turn[i]=player3;
				notUsed[2] = false;
			} else if (array[i] == score4 && notUsed[3]) {
				turn[i]=player4;
				notUsed[3] = false;
			}
		}
		
		System.out.println("");//space for visibility
		System.out.println("Round: " + roundNumber);
		System.out.println("Player Order should be: "); // prints out turn order
		System.out.println("First: " + turn[0].getName());
		System.out.println("Second: " + turn[1].getName());
		System.out.println("Third: " + turn[2].getName());
		System.out.println("Last: " + turn[3].getName());
		
		return turn;
	}

	
	//executes a random event
	public void RandomEvent(Player currPlayer,boolean first){
		Random random = new Random();
		int eventID;
		if(first){
			eventID = random.nextInt(4) + 1;
		} else {
			eventID = random.nextInt(7) + 1;
		}
		
		System.out.println("Food Before Event: " + currPlayer.getFoodQuantity());
		System.out.println("Energy Before Event: " + currPlayer.getEnergyQuantity());
		System.out.println("Ore Before Event: " + currPlayer.getOreQuantity());
		System.out.println("Money Before Event: " + currPlayer.getMoney());
		
		if (eventID == 1){ //1,2,3,4 good events
			currPlayer.setFoodQuantity(currPlayer.getFoodQuantity() +3);
			currPlayer.setEnergyQuantity(currPlayer.getEnergyQuantity() +2);
			//StatPanel.getInstance().queueMsg("YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS");
		}
		else if(eventID == 2){
			currPlayer.setOreQuantity(currPlayer.getOreQuantity() +2);
			//StatPanel.getInstance().queueMsg("A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE");
		}
		else if(eventID == 3){
			currPlayer.setMoney(currPlayer.getMoney() + 8*randomNumber[roundNumber]);
			//StatPanel.getInstance().queueMsg("THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER");
		}
		else if(eventID == 4){
			currPlayer.setMoney(currPlayer.getMoney() + 2*randomNumber[roundNumber]);
			//StatPanel.getInstance().queueMsg("YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE");
		}
		else if (eventID == 5){ //5,6,7 bad events
			currPlayer.setMoney(currPlayer.getMoney() + 4*randomNumber[roundNumber]);
			//StatPanel.getInstance().queueMsg("FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE");
		}
		else if(eventID == 6){
			currPlayer.setFoodQuantity(currPlayer.getFoodQuantity() - currPlayer.getFoodQuantity()/2);
			//StatPanel.getInstance().queueMsg("MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD");
		}
		else if(eventID == 7){
			currPlayer.setMoney(currPlayer.getMoney() - 2*randomNumber[roundNumber]);
			//StatPanel.getInstance().queueMsg("YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN");
		} else {
			//StatPanel.getInstance().queueMsg("no event occured, eventID = " + eventID);
		}
		
		System.out.println("Food After Event: " + currPlayer.getFoodQuantity());
		System.out.println("Energy After Event: " + currPlayer.getEnergyQuantity());
		System.out.println("Ore After Event: " + currPlayer.getOreQuantity());
		System.out.println("Money After Event: " + currPlayer.getMoney());
	}
	
	
	public ArrayList RandomRoundEvent(Player[] players, TownScreenUI tsui){ // may need to pass in a store object
		if(eventsLeft == 0) return null;
		
		System.out.println("RoundRandomEvent happened!");
		System.out.println(players[3].getName());
		
		Random rand = new Random();
		int num = Math.abs(rand.nextInt()%100) + 1;
		
		System.out.println("event number");
		System.out.println(num);
		
		Player playerAffected = null;
		int effect = 0;
		
		//choses event
		if (num > rEventProb[0] + rEventProb[1] + rEventProb[2] + rEventProb[3] + rEventProb[4] + rEventProb[5] + rEventProb[6]) {
			//event #7 occurs
			
			System.out.println("event 7");
			
			StatPanel.getInstance().queueMsg("Fire in Store occured. The store is closed this round.");
			tsui.setFire(1);
			rEventOccured[7] ++;
			//make players not able to enter the store this round
			//need to add int onFire to class with button for store and make it default 0
			//if this happens then make it 1
			//if it is 1 then disable button functionality
			//every round reinitalize onFire to 0
			
		} else if (num > rEventProb[0] + rEventProb[1] + rEventProb[2] + rEventProb[3] + rEventProb[4] + rEventProb[5]) {
			//event #6 occurs
			int pick = Math.abs(rand.nextInt()%2);
			
			System.out.println("event 6");
			System.out.println(pick);
			
			//players[pick] has what his production would be subtracted from his current resources
			//will be like he had no production
			StatPanel.getInstance().queueMsg("Radiation occured. " + players[pick].getName() + " has no production this turn.");
			playerAffected = players[pick];
			effect = 6;
			rEventOccured[6] ++;
			
		} else if (num > rEventProb[0] + rEventProb[1] + rEventProb[2] + rEventProb[3] + rEventProb[4]) {
			//event #5 occurs
			//redefining as random player loses 5 food and gains 2 ore
			int pick = Math.abs(rand.nextInt()%4);
			
			System.out.println("event 5");
			System.out.println(pick);
			
			players[pick].setFoodQuantity(players[pick].getFoodQuantity() - 5);
			players[pick].setOreQuantity(players[pick].getOreQuantity() + 2);
			StatPanel.getInstance().queueMsg("Meteorite Strike occured. "+ players[pick].getName() + " loses 5 food and gains 2 ore.");
			rEventOccured[5] ++;
			
		} else if (num > rEventProb[0] + rEventProb[1] + rEventProb[2] + rEventProb[3]){
			//event #4 occurs
			
			System.out.println("event 4");
			
			StatPanel.getInstance().queueMsg("Sunspot Activity occured all players gain 3 energy");
			for(int i = 0; i < 4; i++){
				players[i].setFoodQuantity(players[i].getFoodQuantity() + 3);
			}
			rEventOccured[4] ++;
			
		} else if (num > rEventProb[0] + rEventProb[1] + rEventProb[2]){
			//event #3 occurs
			StatPanel.getInstance().queueMsg("Planetquake occured. Production is randomized.");
			//redefine as randomizing production this turn
			//20 resources are randomly distributed between the players
			for(int i = 0; i < 20; i++){
				int playerind = Math.abs(rand.nextInt()%4);
				int resourceind = Math.abs(rand.nextInt()%3);
				
				System.out.println("event 3");
				System.out.println(playerind + " " + resourceind);
				
				if (resourceind == 0){
					players[playerind].setFoodQuantity(players[playerind].getFoodQuantity() + 1);
				} else if (resourceind == 1) {
					players[playerind].setEnergyQuantity(players[playerind].getEnergyQuantity() + 1);
				} else {
					players[playerind].setOreQuantity(players[playerind].getOreQuantity() + 1);
				}
			}
			effect = 3;
			rEventOccured[3] ++;
			
		} else if (num > rEventProb[0] + rEventProb[1]) {
			//event #2 occurs
			StatPanel.getInstance().queueMsg("Acid Rain Storm occured. Additional Food is found at the cost of your Energy");
			//add 4 or 2 to food and remove 2 or 1 from energy
			for(int i = 0; i < 4; i++){
				int pick = Math.abs(rand.nextInt()%2);
				
				
				System.out.println("event 2");
				System.out.println(pick);
				
				if(pick == 0){
					players[i].setFoodQuantity(players[i].getFoodQuantity() + 4);
					players[i].setEnergyQuantity(players[i].getEnergyQuantity() - 2);
				} else {
					players[i].setFoodQuantity(players[i].getFoodQuantity() + 2);
					players[i].setEnergyQuantity(players[i].getEnergyQuantity() - 1);
				}
			}
			
			rEventOccured[2] ++;
			
		} else if (num > rEventProb[0]) {
			//event #1 occurs
			
			System.out.println("event 1");
			
			StatPanel.getInstance().queueMsg("Pirate Ship occured. The Ore is gone. Why is the Ore always gone?");
			for(int i = 0; i < 4; i++){
				players[i].setOreQuantity(0);
			}
			//set the store's ore to 0
			effect = 1;
			rEventOccured[1] ++;
			
			
			
		} else {
			//event #0 occurs
			//redefining as player 1 or 2 has 1 of each resource removed
			int pick = Math.abs(rand.nextInt()%2);
			
			System.out.println("event 0");
			System.out.println(pick);
			
			players[pick].setFoodQuantity(players[pick].getFoodQuantity() - 1);
			players[pick].setEnergyQuantity(players[pick].getEnergyQuantity() - 1);
			players[pick].setOreQuantity(players[pick].getOreQuantity() - 1);
			StatPanel.getInstance().queueMsg("Pest Attack occured. " + players[pick].getName() + " has lost one of each resource");
			
			rEventOccured[0] ++;
			
		}
		//updates probability after an event occurs
		roundEventProbUpdater();
		ArrayList ret = new ArrayList(2);
		ret.add(0,playerAffected);
		ret.add(1,effect);
		
		return ret;
	}
	
	private void roundEventProbUpdater(){
		for(int i = 0; i < 7; i++){
			rEventProb[i] = 100 * (rEventMax[i]-rEventOccured[i]) / eventsLeft;
		}
	}
	
	
	
	/**
	 * setRoundNumber used for debugging purposes to round the number
	 * @param round
	 */
	
	public void setRoundNumber(int round){ // for debugging purposes
		roundNumber = round;
	}

	/**
	 * nextRound method increases roundNumber variable
	 */
	
	public void nextRound(){
		roundNumber++;
	}

	/**
	 * getFoodRequirement method to obtain food of player
	 * 
	 * @return foodRequirement
	 */
	
	public int getFoodRequirement(){
		return foodRequirement[roundNumber];
	}
	

	/**
	 * getGambingBonus method to obtain bonus based on round
	 * 
	 * @return gamblingBonus
	 */
	
	public int getGamblingBonus(){
		return gamblingBonus[roundNumber];
	}

}
