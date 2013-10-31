package edu.gatech.spamr.model;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * The PubTest class represents a test in which we the developers can
 * determine if the player can gamble his or her resources and time 
 * remaining within the turn
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/22/2013 
 */

public class PubTest {

	@Test
	public void testCalcGamble() {
		Pub pub = new Pub();
		Round round = new Round();
		round.setRoundNumber(11);
		long timeLeft = 23332; // 23.331 secs
		System.out.println(round.getGamblingBonus());
		for(int i=0; i<1000; i++){
			System.out.println(pub.calcGamble(round, timeLeft));
		}
	}


}
