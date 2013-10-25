package edu.gatech.spamr.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimerTest {

	@Test
	public void testCalcTurnTime() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetTurnEndTime() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTimeRemaining() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testStartTurn() {
		Player p1 = new Player();
		p1.setFood(5);
		Round round = new Round();
		round.setRoundNumber(11);
		Timer timer = new Timer();
		timer.startTurn(p1, round);
	}

}
