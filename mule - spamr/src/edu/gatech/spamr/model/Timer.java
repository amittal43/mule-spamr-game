package edu.gatech.spamr.model;

import edu.gatech.spamr.view.GameScreenUI;

public class Timer implements Runnable {
	
	private static GameScreenUI parent;
	
	private volatile static boolean stop = false;
	private static long turnTime = 0;
	private static long turnEnd = 0;
	private static long timeLeft = 0;

	//Runnable method
	public void run() {
        System.out.println("Timer is running!");
        requestStart();
        //the while loop
        startTurn(Game.getCurrentPlayer(), Game.getCurrentRound());
    }
	
	
	/////////methods/////////
	public static long calcTurnTime(Player player, Round round){
		if(player.getFood() >= round.getFoodRequirement()){ // no food shortage
			System.out.println("The player has 50 seconds");
			return 50000; //50.00 seconds
		}
		else if(player.getFood()==0){// complete food shortage
			System.out.println("The player has 5 seconds");
			return 5000; //5.00 seconds
		}
		else{ // partial food shortage
			System.out.println("The player has 30 seconds");
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
	
	
	
	public static void startTurn(Player player, Round round) {
		setTurnTime(player,round);
		setTurnEndTime(player,round);
		while(System.currentTimeMillis()<turnEnd && !stop){
			//System.out.println(getSecondsRemaining()); // just to check

		}
		setTimeLeft(getTimeRemaining());
		if (timeLeft <= 0){
			System.out.println("Turn is over with " + ((double)timeLeft/1000) + " seconds left");
			//updates turn
			Game.updateTurn();
			System.out.println("Turn changes to " + Game.getCurrentPlayer().getName());
			//screen change
			parent.cardChangeTo("TurnScreen");
			//pop-up
			parent.getTurnScreenUI().getTurnDialog().setCurrentPlayerText(Game.getCurrentPlayer().getName());
			parent.getTurnScreenUI().getTurnDialog().setVisible(true);
			
			requestStop();
			
		}
		System.out.println("Turn is over with " + ((double)timeLeft/1000) + " seconds left");
	}
	
	public static void requestStop() {
        stop = true;
        //System.out.println("Thread should have stopped");
    }
	
	public static void requestStart() {
		stop = false;
		turnTime = 0;
		turnEnd = 0;
		timeLeft = 0;
		parent = Game.getParent();
        //System.out.println("Thread should be reset");
    }
	
}
