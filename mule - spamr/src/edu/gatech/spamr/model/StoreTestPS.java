package edu.gatech.spamr.model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.gatech.spamr.model.Store.Resource;

public class StoreTestPS {


	@BeforeClass
	public static void testSetup() {
	}
	
	@AfterClass
	public static void testCleanup(){
		// Tear down for data used by the unit tests
	}
	
	@Test
	public void testBuyResource() {
		Store test1 = new Store();
		Store test2 = new Store();
		Store test3 = new Store();
		Player Bob = new Player();
		Player Sue = new Player();
		Player Ben = new Player();
		
		assertEquals("Input resource must be Food", "FOOD", test1.buyResource(Bob, FOOD, 3));
		assertEquals("Input resource must be Energy", "ENERGY", test2.buyResource(Sue, ENERGY, 2));
		assertEquals("Input resource must be Ore", "ORE", test3.buyResource(Ben, ORE, 1));
	}

}


//package edu.gatech.spamr.model;
//
//import java.io.Serializable;
//
//public class Store implements Serializable {
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -8447124918015466998L;
//	
//	//beginner Difficulty starting food
//	private int foodQuantity = 16;
//	private int energyQuantity = 16;
//	private int oreQuantity = 0;
//	private int muleQuantity = 25;
//
//	
//	// starting prices
//	private int foodPrice = 30;
//	private int energyPrice = 25;
//	private int orePrice = 50;
//	private int mulePrice = 100; // base price
//	
//	// mule price addons
//	private final int foodFee = 25;
//	private final int energyFee = 50;
//	private final int oreFee = 75;
//	
//	public enum Resource{FOOD, ENERGY, ORE}  ***THIS IS MY PROBLEM***
//	
//	public void buyResource(Player p, Resource r, int number){ // still need to implement money differences
//		if(r==Resource.FOOD){
//			p.setFood(p.getFood() + number);
//			foodQuantity -= number;
//			p.updateMoney(-(foodPrice * number));
//		}
//		
//		if(r==Resource.ENERGY){
//			p.setEnergy(p.getEnergy() + number);
//			energyQuantity -= number;
//			p.updateMoney(-(energyPrice * number));
//		}
//		
//		if(r==Resource.ORE){
//			p.setOre(p.getOre() + number);
//			oreQuantity -= number;
//			p.updateMoney(-(orePrice * number));
//		}
//	}
