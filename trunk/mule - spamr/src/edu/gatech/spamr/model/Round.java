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

	public Player[] calcTurn(Player p1, Player p2, Player p3, Player p4){
		Player[] turn = new Player[4];	//stores players in order of score
		boolean[] notUsed = {true, true, true, true};
		//calculates score
		int score1 = p1.calcScore();
		int score2 = p2.calcScore();
		int score3 = p3.calcScore();
		int score4 = p4.calcScore();
		
		//sorts scores
		int array[] = {score1, score2, score3, score4};
		Arrays.sort(array);
		
		//matches score placement with player [
		for(int i =0;i<4;i++){
			if (array[i] == score1 && notUsed[0]) {
				turn[i]=p1;
				notUsed[0] = false;
			} else if(array[i] == score2 && notUsed[1]) {
				turn[i]=p2;
				notUsed[1] = false;
			} else if (array[i] == score3 && notUsed[2]) {
				turn[i]=p3;
				notUsed[2] = false;
			} else if (array[i] == score4 && notUsed[3]) {
				turn[i]=p4;
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
		
		if (eventID == 1){ //1,2,3,4 good events
			currPlayer.setFood(currPlayer.getFood() +3);
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
			currPlayer.setFood(currPlayer.getFood() - currPlayer.getEnergy()/2);
			System.out.println("MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD");
		}
		else if(eventID == 7){
			currPlayer.setMoney(currPlayer.getMoney() - 2*randomNumber[roundNumber]);
			System.out.println("YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN");
		} else {
			System.out.println("no event occured, eventID = " + eventID);
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
