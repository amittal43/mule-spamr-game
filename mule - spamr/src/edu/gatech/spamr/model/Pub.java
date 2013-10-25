package edu.gatech.spamr.model;

import java.util.Random;

public class Pub {
	
	public int calcGamble(Round round, long timeLeft){
		Random rand = new Random();
		double secondsLeft = (double) timeLeft/1000;
		return (int)(round.getGamblingBonus() + rand.nextInt((int)(2 * (2.14 * secondsLeft)+1))); // convert seconds to BTU then double
	}

}
