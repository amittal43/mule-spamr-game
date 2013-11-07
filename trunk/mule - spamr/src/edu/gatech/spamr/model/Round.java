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
		Player[] turn = new Player[4];
		int score1 = Game.getPlayer1().calcScore();
		int score2 = Game.getPlayer2().calcScore();
		int score3 = Game.getPlayer3().calcScore();
		int score4 = Game.getPlayer4().calcScore();
		
//		int score1 = player1.calcScore();
//		int score2 = player2.calcScore();
//		int score3 = player3.calcScore();
//		int score4 = player4.calcScore();
		

		int array[] = {score1, score2, score3, score4}; //least score goes first
		Arrays.sort(array);
		for(int i =0;i<4;i++){
			if (array[i] == score1)
				turn[i]=Game.getPlayer1();
			else if(array[i] == score2)
				turn[i]=Game.getPlayer2();
			else if (array[i] == score3)
				turn[i]=Game.getPlayer3();
			else if (array[i] == score4)
				turn[i]=Game.getPlayer4();
//			if (array[i] == score1)
//				turn[i]= player1;
//			else if(array[i] == score2)
//				turn[i]= player2;
//			else if (array[i] == score3)
//				turn[i]= player3;
//			else if (array[i] == score4)
//				turn[i]= player4;
		}
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