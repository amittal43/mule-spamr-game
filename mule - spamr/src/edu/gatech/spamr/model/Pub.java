package edu.gatech.spamr.model;

import java.util.Random;

/** 
 * The Pub class represents a location in which the player can
 * gamble his or her resources and time remaining within the turn
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/22/2013 
 */

public class Pub {
	
	private static Pub instance = null;
	private Pub(){} // Singleton -> private constructor
	
	public static Pub getInstance(){
		if(instance == null){
			instance = new Pub();
		}
		
		return instance;
	}
	

	/**
	 * calcGamble method to calculate the amount a player can gamble in terms of time
	 * 
	 * @param round
	 * @param timeLeft
	 * @return time lost from player's turn
	 */
	public static int calcGamble(Round round, long timeLeft){
		Random rand = new Random();
		double secondsLeft = (double) timeLeft/1000;
		
		//currently there is a bug where turn sometimes doesn't end and we don't know why yet.
		if (secondsLeft < 0){
			secondsLeft = 0;
		}
		
		//System.out.println("Seconds left = " + secondsLeft);
		return (int)(round.getGamblingBonus() + rand.nextInt((int)(2 * (2.14 * secondsLeft)+1))); // convert seconds to BTU then double
	}

}
