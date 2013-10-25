package edu.gatech.spamr.model;

public class Timer {
	
	private long turnEnd = 0;
	private long timeLeft = 0;
	boolean endTurn = false;

	public long calcTurnTime(Player player, Round round){
		if(player.getFood() >= round.getFoodRequirement()){ // no food shortage
			return 47130; //47.13 seconds
		}
		else if(player.getFood()==0){// complete food shortage
			return 4670; //4.67 seconds
		}
		else{ // partial food shortage
			double foodRatio = (double)player.getFood()/ (double)round.getFoodRequirement();
			return 4670 + (long) (42455 * foodRatio); // 4.67 + 42.455 secs * ratio of food to requirement
		}
	}
	
	public void setTurnEndTime(Player player, Round round){
		long start = System.currentTimeMillis();
		turnEnd = start + calcTurnTime(player, round);
	}
	
	public long getTimeRemaining(){
		return turnEnd - System.currentTimeMillis();
	}
	
	public double getSecondsRemaining(){
		return (double)getTimeRemaining()/1000;
	}
	
	public void setTimeLeft(long time){
		timeLeft = time;
	}
	
	public void setEndTurn(){
		endTurn = true;
	}
	
	public void startTurn(Player player, Round round){
		setTurnEndTime(player,round);
		while(System.currentTimeMillis()<turnEnd && endTurn==false){
			System.out.println(getSecondsRemaining()); // just to check
		}
		setTimeLeft(getTimeRemaining());
		System.out.println("Turn is over with " + ((double)timeLeft/1000) + " seconds left");
	}
	
}
