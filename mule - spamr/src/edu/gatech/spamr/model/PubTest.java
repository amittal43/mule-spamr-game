package edu.gatech.spamr.model;

import static org.junit.Assert.*;

import org.junit.Test;

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
