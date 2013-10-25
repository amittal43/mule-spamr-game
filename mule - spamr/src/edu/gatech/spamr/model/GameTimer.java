package edu.gatech.spamr.model;

/** 
 * The GameTimer class represents a method in keeping track of 
 * whose turn it is in the game
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/22/2013 
 */


public class GameTimer {
	
	public static void main(String[] args){
		//instance variables
		long now = System.currentTimeMillis();
		long end = now + 1 * 3000; //this is for 3 seconds;
		//however, i think that it should "n" and n can be whatever time we want
		long current = System.currentTimeMillis();
			
		/**
		 * The while loop is to run the timer until a set time is met.
		 * By constantly setting a long variable to the current time it
		 * will eventually pass the end variable quitting the loop and
		 * letting the next player have its turn.
		 */
			
		while(current < end){
			System.out.println("Yes time in increasing"); //just to see if it works
			current = System.currentTimeMillis();
		}
	}
}