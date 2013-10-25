package edu.gatech.spamr.model;

public class Round {

	private int roundNumber = 0;
	private int[] foodRequirement = {3,3,3,3,4,4,4,4,5,5,5,5};
	private int[] gamblingBonus = {50,50,50,100,100,100,100,150,150,150,150,200};
	
	public int getRoundNumber(){
		return roundNumber;
	}
	
	public void nextRound(){
		roundNumber++;
	}
	
	public int getFoodRequirement(int round){
		return foodRequirement[round];
	}
	
	public int getGamblingBonus(int round){
		return gamblingBonus[round];
	}
}
