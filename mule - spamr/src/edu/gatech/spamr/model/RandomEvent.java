package edu.gatech.spamr.model;

import java.util.Random;

/** 
 * The RandomEvent class represents a class in which the list of events mandated
 * on the T-Square site can be randomized and then used in either a good or bad 
 * way to the player's resources.
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 11/12/2013 
 */

public class RandomEvent {
	
	Random random = new Random();
	
	
	
	int num = random.nextInt(7) + 1;
	 

}
