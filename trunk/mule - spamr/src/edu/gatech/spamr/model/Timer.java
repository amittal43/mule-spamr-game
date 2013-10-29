package edu.gatech.spamr.model;

public class Timer {
	
	private long turnTime = 0;
	private long turnEnd = 0;
	private long timeLeft = 0;
	boolean endTurn = false;

	public long calcTurnTime(Player player, Round round){
		if(player.getFood() >= round.getFoodRequirement()){ // no food shortage
			return 50000; //50.00 seconds
		}
		else if(player.getFood()==0){// complete food shortage
			return 5000; //5.00 seconds
		}
		else{ // partial food shortage
			return 30000; // 30.00 seconds
		}
	}
	
	public long getTurnTime(){
		return turnTime;
	}
	
	public void setTurnTime(Player player, Round round){
		turnTime = calcTurnTime(player,round);
	}
	
	public void setTurnEndTime(Player player, Round round){ // must setTurnTime before this is called
		long start = System.currentTimeMillis();
		turnEnd = start + turnTime;
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
		setTurnTime(player,round);
		setTurnEndTime(player,round);
		while(System.currentTimeMillis()<turnEnd && endTurn==false){
			System.out.println(getSecondsRemaining()); // just to check
		}
		setTimeLeft(getTimeRemaining());
		System.out.println("Turn is over with " + ((double)timeLeft/1000) + " seconds left");
	}
	
}
