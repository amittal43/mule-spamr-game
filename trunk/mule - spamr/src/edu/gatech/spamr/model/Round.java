package edu.gatech.spamr.model;

import java.util.Arrays;

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

public class Round {

	private static int roundNumber = 0;
	private static final int[] foodRequirement = {3,3,3,3,4,4,4,4,5,5,5,5};
	private static final int[] gamblingBonus = {50,50,50,100,100,100,100,150,150,150,150,200};

	/**
	 * getRoundNumber method
	 * 
	 * @return roundNumber
	 */
	
	public static int getRoundNumber(){
		return roundNumber;
	}
	
	/**
	 * calcTurn method which calculates the players' turns based off the players' scores
	 * 
	 * @return turn of the player that should be starting
	 */

	public Player[] calcTurn(){
		Player[] turn = new Player[4];	//stores players in order of score
		boolean[] notUsed = {true, true, true, true};
		//calculates score
		int score1 = Game.getPlayer1().calcScore();
		int score2 = Game.getPlayer2().calcScore();
		int score3 = Game.getPlayer3().calcScore();
		int score4 = Game.getPlayer4().calcScore();
		
		//sorts scores
		int array[] = {score1, score2, score3, score4};
		Arrays.sort(array);
		
		//matches score placement with player [
		for(int i =0;i<4;i++){
			if (array[i] == score1 && notUsed[0]) {
				turn[i]=Game.getPlayer1();
				notUsed[0] = false;
			} else if(array[i] == score2 && notUsed[1]) {
				turn[i]=Game.getPlayer2();
				notUsed[1] = false;
			} else if (array[i] == score3 && notUsed[2]) {
				turn[i]=Game.getPlayer3();
				notUsed[2] = false;
			} else if (array[i] == score4 && notUsed[3]) {
				turn[i]=Game.getPlayer4();
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

	/**
	 * setRoundNumber used for debugging purposes to round the number
	 * @param round
	 */
	
	public static void setRoundNumber(int round){ // for debugging purposes
		roundNumber = round;
	}

	/**
	 * nextRound method increases roundNumber variable
	 */
	
	public static void nextRound(){
		roundNumber++;
	}

	/**
	 * getFoodRequirement method to obtain food of player
	 * 
	 * @return foodRequirement
	 */
	
	public static int getFoodRequirement(){
		return foodRequirement[roundNumber];
	}

	/**
	 * getGambingBonus method to obtain bonus based on round
	 * 
	 * @return gamblingBonus
	 */
	
	public static int getGamblingBonus(){
		return gamblingBonus[roundNumber];
	}

}
