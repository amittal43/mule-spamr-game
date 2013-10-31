package edu.gatech.spamr.model;

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
	
	public static int getRoundNumber(){
		return roundNumber;
	}
	
	public static void setRoundNumber(int round){ // for debugging purposes
		roundNumber = round;
	}
	
	public static void nextRound(){
		roundNumber++;
	}
	
	public static int getFoodRequirement(){
		return foodRequirement[roundNumber];
	}
	
	public static int getGamblingBonus(){
		return gamblingBonus[roundNumber];
	}

}
