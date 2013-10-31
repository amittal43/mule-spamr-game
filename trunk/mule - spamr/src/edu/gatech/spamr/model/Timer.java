package edu.gatech.spamr.model;

public class Timer {
	
	private static long turnTime = 0;
	private static long turnEnd = 0;
	private static long timeLeft = 0;
	static boolean endTurn = false;

	public static long calcTurnTime(Player player, Round round){
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
	
	public static void setTurnTime(Player player, Round round){
		turnTime = calcTurnTime(player,round);
	}
	
	public static void setTurnEndTime(Player player, Round round){ // must setTurnTime before this is called
		long start = System.currentTimeMillis();
		turnEnd = start + turnTime;
	}
	
	public static long getTimeRemaining(){
		return turnEnd - System.currentTimeMillis();
	}
	
	public static double getSecondsRemaining(){
		return (double)getTimeRemaining()/1000;
	}
	
	public static void setTimeLeft(long time){
		timeLeft = time;
	}
	
	public void setEndTurn(){
		endTurn = true;
	}
	
	public static void startTurn(Player player, Round round){
		setTurnTime(player,round);
		setTurnEndTime(player,round);
		while(System.currentTimeMillis()<turnEnd && endTurn==false){
			System.out.println(getSecondsRemaining()); // just to check
		}
		setTimeLeft(getTimeRemaining());
		System.out.println("Turn is over with " + ((double)timeLeft/1000) + " seconds left");
	}
	
}
