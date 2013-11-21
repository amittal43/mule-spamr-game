package edu.gatech.spamr.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The PubTest class represents a test in which we the developers can determine
 * if the player can gamble his or her resources and time remaining within the
 * turn
 * 
 * @author Sean Lachenberg
 * @version 1.0 11/20/2013
 */

public class PubTest {

	@Test
	public void testNoTimeRemaining() {
		Pub pub = new Pub();
		Round round = new Round();
		round.setRoundNumber(0);

		// if there is no time left, the gambling winnings is equal to the
		// round's gambling bonus
		for (int i = 0; i < 11; i++) {
			assertEquals(round.getGamblingBonus(), pub.calcGamble(round, 0));
			round.nextRound();
		}
	}

	/*
	 * Since there is a random element involved in calculating the winnings, we
	 * must test that they fall within a specific range. We will test 100 cases
	 * per each time remaining tested, in order to make sure the random
	 */

	@Test
	public void test10secRange() {
		Pub pub = new Pub();
		Round round = new Round();
		round.setRoundNumber(0);
		long timeleft = 10000; // 10 seconds

		for (int i = 0; i < 100; i++) {
			assertTrue(pub.calcGamble(round, timeleft) >= round
					.getGamblingBonus());
			assertTrue(pub.calcGamble(round, timeleft) < round
					.getGamblingBonus() + 44); // 44 extra should be ceiling

			// check method functions properly no matter what round it is
			if (round.getRoundNumber() == 11) {
				round.setRoundNumber(0);
			} else {
				round.nextRound();
			}
		}
	}

	@Test
	public void test20secRange() {
		Pub pub = new Pub();
		Round round = new Round();
		round.setRoundNumber(0);
		long timeleft = 20000; // 20 seconds

		for (int i = 0; i < 100; i++) {
			assertTrue(pub.calcGamble(round, timeleft) >= round
					.getGamblingBonus());
			assertTrue(pub.calcGamble(round, timeleft) < round
					.getGamblingBonus() + 88); // 88 extra should be ceiling

			// check method functions properly no matter what round it is
			if (round.getRoundNumber() == 11) {
				round.setRoundNumber(0);
			} else {
				round.nextRound();
			}
		}

	}

	@Test
	public void test30secRange() {
		Pub pub = new Pub();
		Round round = new Round();
		round.setRoundNumber(0);
		long timeleft = 30000; // 30 seconds

		for (int i = 0; i < 100; i++) {
			assertTrue(pub.calcGamble(round, timeleft) >= round
					.getGamblingBonus());
			assertTrue(pub.calcGamble(round, timeleft) < round
					.getGamblingBonus() + 132); // 132 extra should be ceiling

			// check method functions properly no matter what round it is
			if (round.getRoundNumber() == 11) {
				round.setRoundNumber(0);
			} else {
				round.nextRound();
			}
		}
	}

	@Test
	public void test40secRange() {
		Pub pub = new Pub();
		Round round = new Round();
		round.setRoundNumber(0);
		long timeleft = 40000; // 40 seconds

		for (int i = 0; i < 100; i++) {
			assertTrue(pub.calcGamble(round, timeleft) >= round
					.getGamblingBonus());
			assertTrue(pub.calcGamble(round, timeleft) < round
					.getGamblingBonus() + 176); // 176 extra should be ceiling

			// check method functions properly no matter what round it is
			if (round.getRoundNumber() == 11) {
				round.setRoundNumber(0);
			} else {
				round.nextRound();
			}
		}
	}

	@Test
	public void test50secRange() {
		Pub pub = new Pub();
		Round round = new Round();
		round.setRoundNumber(0);
		long timeleft = 50000; // 50 seconds

		for (int i = 0; i < 100; i++) {
			assertTrue(pub.calcGamble(round, timeleft) >= round
					.getGamblingBonus());
			assertTrue(pub.calcGamble(round, timeleft) < round
					.getGamblingBonus() + 220); // 220 extra should be ceiling

			// check method functions properly no matter what round it is
			if (round.getRoundNumber() == 11) {
				round.setRoundNumber(0);
			} else {
				round.nextRound();
			}
		}
	}

	// original test to check the method was functioning properly

	/*
	 * @Test public void testCalcGamble() { Pub pub = new Pub(); Round round =
	 * new Round(); round.setRoundNumber(11); long timeLeft = 23332; // 23.331
	 * secs System.out.println(round.getGamblingBonus()); for(int i=0; i<1000;
	 * i++){ System.out.println(pub.calcGamble(round, timeLeft)); } }
	 */

}
