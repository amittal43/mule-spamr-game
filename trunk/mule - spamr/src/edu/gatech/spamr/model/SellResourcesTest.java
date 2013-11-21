package edu.gatech.spamr.model;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.spamr.model.Store.Resource;

public class SellResourcesTest {


	@Test
	public final void testSellNoFood(){
		
		//initialize scenario
		Store testStore = new Store();
		Player testPlayer = new Player();
		testPlayer.setFood(0);
		testPlayer.setMoney(0);
		Resource testResource = Resource.FOOD;
		int testQuantity = 5;
		
		
		//run the function
		testStore.sellResource(testPlayer, testResource, testQuantity);
		
		//check the results
		assertEquals(0, testPlayer.getMoney());		
		assertEquals(0, testPlayer.getFood());
		assertEquals(16, testStore.getFoodQuantity());
		
	}
	
	@Test
	public final void testSellSomeFood(){
		
		//initialize scenario
		Store testStore = new Store();
		Player testPlayer = new Player();
		testPlayer.setFood(5);
		testPlayer.setMoney(0);
		Resource testResource = Resource.FOOD;
		int testQuantity = 3;
		
		
		//run the function
		testStore.sellResource(testPlayer, testResource, testQuantity);
		
		//check the results		
		assertEquals(45, testPlayer.getMoney());		
		assertEquals(2, testPlayer.getFood());
		assertEquals(19, testStore.getFoodQuantity());
		
	}
	
	@Test
	public final void testSellAllFood(){
		
		//initialize scenario
		Store testStore = new Store();
		Player testPlayer = new Player();
		testPlayer.setFood(5);
		testPlayer.setMoney(0);
		Resource testResource = Resource.FOOD;
		int testQuantity = 5;
		
		
		//run the function
		testStore.sellResource(testPlayer, testResource, testQuantity);
		
		//check the results		
		assertEquals(75, testPlayer.getMoney());		
		assertEquals(0, testPlayer.getFood());
		assertEquals(21, testStore.getFoodQuantity());
		
	}

	@Test
	public final void testSellNoEnergy(){
		
		//initialize scenario
		Store testStore = new Store();
		Player testPlayer = new Player();
		testPlayer.setEnergy(0);
		testPlayer.setMoney(0);
		Resource testResource = Resource.ENERGY;
		int testQuantity = 5;
		
		
		//run the function
		testStore.sellResource(testPlayer, testResource, testQuantity);
		
		//check the results
		assertEquals(0, testPlayer.getMoney());		
		assertEquals(0, testPlayer.getEnergy());
		assertEquals(16, testStore.getEnergyQuantity());
		
	}
	
	@Test
	public final void testSellSomeEnergy(){
		
		//initialize scenario
		Store testStore = new Store();
		Player testPlayer = new Player();
		testPlayer.setEnergy(5);
		testPlayer.setMoney(0);
		Resource testResource = Resource.ENERGY;
		int testQuantity = 3;
		
		
		//run the function
		testStore.sellResource(testPlayer, testResource, testQuantity);
		
		//check the results		
		assertEquals(37, testPlayer.getMoney());		
		assertEquals(2, testPlayer.getEnergy());
		assertEquals(19, testStore.getEnergyQuantity());
		
	}
	
	@Test
	public final void testSellAllEnergy(){
		
		//initialize scenario
		Store testStore = new Store();
		Player testPlayer = new Player();
		testPlayer.setEnergy(5);
		testPlayer.setMoney(0);
		Resource testResource = Resource.ENERGY;
		int testQuantity = 5;
		
		
		//run the function
		testStore.sellResource(testPlayer, testResource, testQuantity);
		
		//check the results		
		assertEquals(62, testPlayer.getMoney());		
		assertEquals(0, testPlayer.getEnergy());
		assertEquals(21, testStore.getEnergyQuantity());
		
	}
	
	@Test
	public final void testSellNoOre(){
		
		//initialize scenario
		Store testStore = new Store();
		Player testPlayer = new Player();
		testPlayer.setOre(0);
		testPlayer.setMoney(0);
		Resource testResource = Resource.ORE;
		int testQuantity = 5;
		
		
		//run the function
		testStore.sellResource(testPlayer, testResource, testQuantity);
		
		//check the results
		assertEquals(0, testPlayer.getMoney());		
		assertEquals(0, testPlayer.getOre());
		assertEquals(0, testStore.getOreQuantity());
		
	}
	
	@Test
	public final void testSellSomeOre(){
		
		//initialize scenario
		Store testStore = new Store();
		Player testPlayer = new Player();
		testPlayer.setOre(5);
		testPlayer.setMoney(0);
		Resource testResource = Resource.ORE;
		int testQuantity = 3;
		
		
		//run the function
		testStore.sellResource(testPlayer, testResource, testQuantity);
		
		//check the results		
		assertEquals(75, testPlayer.getMoney());		
		assertEquals(2, testPlayer.getOre());
		assertEquals(3, testStore.getOreQuantity());
		
	}
	
	@Test
	public final void testSellAllOre(){
		
		//initialize scenario
		Store testStore = new Store();
		Player testPlayer = new Player();
		testPlayer.setOre(5);
		testPlayer.setMoney(0);
		Resource testResource = Resource.ORE;
		int testQuantity = 5;
		
		
		//run the function
		testStore.sellResource(testPlayer, testResource, testQuantity);
		
		//check the results		
		assertEquals(125, testPlayer.getMoney());		
		assertEquals(0, testPlayer.getOre());
		assertEquals(5, testStore.getOreQuantity());
		
	}
	
	
	@Test
	public final void testBadQuantity(){
		//initialize scenario
		Store testStore = new Store();
		Player testPlayer = new Player();
		testPlayer.setOre(5);
		testPlayer.setMoney(0);
		Resource testResource = Resource.ORE;
		int testQuantity = -1;
		
		//run the function
		testStore.sellResource(testPlayer, testResource, testQuantity);
		
		//check the results		
		assertEquals(0, testPlayer.getMoney());		
		assertEquals(5, testPlayer.getOre());
		assertEquals(0, testStore.getOreQuantity());
	}
	
}
