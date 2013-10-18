package edu.gatech.spamr.model;

import java.util.Random;

public class LandOffice {
	
	//TODO
	public void buyLand(Player p, Tile t, int roundNum){
		
	}
	
	//TODO
	public void sellLand(Player p, Tile t){
		
	}
	
	//returns the price the property can be bought at
	public int calcBuyPrice(int roundNum){
		Random rand = new Random();
		return ( (roundNum * rand.nextInt(100)) + 300 );
	}
	
	//returns the price the property is sold at
	public int calcSellPrice(){
		Random rand = new Random();
		return ( rand.nextInt(200) + 400 );
	}

}