package edu.gatech.spamr.model;

import java.util.Random;

/** 
 * The RandomEvent class represents a class in which the list of events mandated
 * on the T-Square site can be randomized and then used in either a good or bad 
 * way to the player's resources.
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 11/12/2013 
 */

public class RandomEvent {
	
	String message;
	boolean badEvent;
	Player player;
	int id;
	public final int[] randomNumber = {25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75, 100};
	
	Random random = new Random();
	int num = random.nextInt(7) + 1;
	
	public RandomEvent(String message, boolean badEvent, Player player, int id){
		this.message = message;
		this.badEvent = badEvent;
		this.player = player;
		this.id = id;
		
	}
	
	RandomEvent event1 = new RandomEvent("YOU JUST RECEIVED A PACKAGE "
			+ "FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS", false, player, 1);
	
	RandomEvent event2 = new RandomEvent("A WANDERING TECH STUDENT REPAID YOUR "
			+ "HOSPITALITY BY LEAVING TWO BARS OF ORE", false, player, 2);
	
	RandomEvent event3 = new RandomEvent("THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER", false, player, 3);
	
	RandomEvent event4 = new RandomEvent("YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE", false, player, 4);
	
	RandomEvent event5 = new RandomEvent("FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE", true, player, 5);
	
	RandomEvent event6 = new RandomEvent("MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE "
			+ "SHED AND STOLE HALF YOUR FOOD", true, player, 6);
	
	RandomEvent event7 = new RandomEvent("YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN", true, player, 7);
	
	
	public void ProcessEvent(int RoundNum){
		if (id == 1){
			player.setFood(player.getFood() +3);
			player.setEnergy(player.getEnergy() +2);
		}
		
		if(id == 2){
			player.setOre(player.getOre() +2);
		}
		if(id == 3)
			player.setMoney(player.getMoney() + 8*randomNumber[RoundNum]) ;
		if(id == 4)
			player.setMoney(player.getMoney() + 2*randomNumber[RoundNum]) ;
		if (id == 5)
			player.setMoney(player.getMoney() + 4*randomNumber[RoundNum]);
		if(id == 6)
			player.setFood(player.getFood() - player.getEnergy()/2);
		if(id == 7)
			player.setMoney(player.getMoney() - 2*randomNumber[RoundNum]);
		
	}
	
	public RandomEvent getEvent(int num){
		if(num ==1)
			return event1;
		return null;
	}

	
	
}
