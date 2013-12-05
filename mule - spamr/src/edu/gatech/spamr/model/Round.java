package edu.gatech.spamr.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

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
		System.out.println("Energy Before Event: " + currPlayer.getEnergy());
		System.out.println("Ore Before Event: " + currPlayer.getOre());
		System.out.println("Money Before Event: " + currPlayer.getMoney());
		
		if (eventID == 1){ //1,2,3,4 good events
			currPlayer.setFoodQuantity(currPlayer.getFoodQuantity() +3);
			currPlayer.setEnergy(currPlayer.getEnergy() +2);
			System.out.println("YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS");
		}
		else if(eventID == 2){
			currPlayer.setOre(currPlayer.getOre() +2);
			System.out.println("A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE");
		}
		else if(eventID == 3){
			currPlayer.setMoney(currPlayer.getMoney() + 8*randomNumber[roundNumber]);
			System.out.println("THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER");
		}
		else if(eventID == 4){
			currPlayer.setMoney(currPlayer.getMoney() + 2*randomNumber[roundNumber]);
			System.out.println("YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE");
		}
		else if (eventID == 5){ //5,6,7 bad events
			currPlayer.setMoney(currPlayer.getMoney() + 4*randomNumber[roundNumber]);
			System.out.println("FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE");
		}
		else if(eventID == 6){
			currPlayer.setFoodQuantity(currPlayer.getFoodQuantity() - currPlayer.getFoodQuantity()/2);
			System.out.println("MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD");
		}
		else if(eventID == 7){
			currPlayer.setMoney(currPlayer.getMoney() - 2*randomNumber[roundNumber]);
			System.out.println("YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN");
		} else {
			System.out.println("no event occured, eventID = " + eventID);
		}
		
		System.out.println("Food After Event: " + currPlayer.getFoodQuantity());
		System.out.println("Energy After Event: " + currPlayer.getEnergy());
		System.out.println("Ore After Event: " + currPlayer.getOre());
		System.out.println("Money After Event: " + currPlayer.getMoney());
	}
	
	
	public void RandomRoundEvent(Player[] players){ // may need to pass in a store object
		if(eventsLeft == 0) return;
		Random rand = new Random();
		int num = rand.nextInt()%100 + 1;
		
		//choses event
		if (num > rEventProb[0] + rEventProb[1] + rEventProb[2] + rEventProb[3] + rEventProb[4] + rEventProb[5] + rEventProb[6]) {
			//event #7 occurs
			System.out.println("Fire in Store occured. The store is closed this round.");
			//make players not able to enter the store this round
			//need to add int onFire to class with button for store and make it default 0
			//if this happens then make it 1
			//if it is 1 then disable button functionality
			//every round reinitalize onFire to 0
			
			rEventOccured[7] ++;
			
		} else if (num > rEventProb[0] + rEventProb[1] + rEventProb[2] + rEventProb[3] + rEventProb[4] + rEventProb[5]) {
			//event #6 occurs
			int pick = rand.nextInt()%2;
			//players[pick] has what his production would be subtracted from his current resources
			//will be like he had no production
			System.out.println("Radiation occured. " + players[pick].getName() + " has no production this turn.");
			
			rEventOccured[6] ++;
			
		} else if (num > rEventProb[0] + rEventProb[1] + rEventProb[2] + rEventProb[3] + rEventProb[4]) {
			//event #5 occurs
			//redefining as random player loses 5 food and gains 2 ore
			int pick = rand.nextInt()%4;
			players[pick].setFoodQuantity(players[pick].getFoodQuantity() - 5);
			players[pick].setOre(players[pick].getOre() + 2);
			System.out.println("Meteorite Strike occured. "+ players[pick].getName() + " loses 5 food and gains 2 ore.");
			
			rEventOccured[5] ++;
			
		} else if (num > rEventProb[0] + rEventProb[1] + rEventProb[2] + rEventProb[3]){
			//event #4 occurs
			System.out.println("Sunspot Activity occured all players gain 3 energy");
			for(int i = 0; i < 4; i++){
				players[i].setFoodQuantity(players[i].getFoodQuantity() + 3);
			}
			rEventOccured[4] ++;
			
		} else if (num > rEventProb[0] + rEventProb[1] + rEventProb[2]){
			//event #3 occurs
			System.out.println("Planetquake occured. Production is randomized.");
			//redefine as randomizing production this turn
			//where production is calculated add int isQuake = 0
			//if isQuake = 1 then (add a random calcuation)
			//if this happens then set isQuake to 1
			//at the beginning of the round set isQuake to 0
			
			rEventOccured[3] ++;
			
		} else if (num > rEventProb[0] + rEventProb[1]) {
			//event #2 occurs
			System.out.println("Acid Rain Storm occured. Additional Food is found at the cost of your Energy");
			//add 4 or 2 to food and remove 2 or 1 from energy
			for(int i = 0; i < 4; i++){
				int pick = rand.nextInt()%2;
				if(pick == 0){
					players[i].setFoodQuantity(players[i].getFoodQuantity() + 4);
					players[i].setEnergy(players[i].getEnergy() - 2);
				} else {
					players[i].setFoodQuantity(players[i].getFoodQuantity() + 2);
					players[i].setEnergy(players[i].getEnergy() - 1);
				}
			}
			
			rEventOccured[2] ++;
			
		} else if (num > rEventProb[0]) {
			//event #1 occurs
			System.out.println("Pirate Ship occured. The Ore is gone. Why is the Ore always gone?");
			for(int i = 0; i < 4; i++){
				players[i].setOre(0);
			}
			//set the store's ore to 0
			
			rEventOccured[1] ++;
			
		} else {
			//event #0 occurs
			//redefining as player 1 or 2 has 1 of each resource removed
			int pick = rand.nextInt()%2;
			players[pick].setFoodQuantity(players[pick].getFoodQuantity() - 1);
			players[pick].setEnergy(players[pick].getEnergy() - 1);
			players[pick].setOre(players[pick].getOre() - 1);
			System.out.println("Pest Attack occured. " + players[pick].getName() + " has lost one of each resource");
			
			rEventOccured[0] ++;
		}
		//updates probability after an event occurs
		roundEventProbUpdater();
		
	}
	
	private void roundEventProbUpdater(){
		for(int i = 0; i < 8; i++){
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
