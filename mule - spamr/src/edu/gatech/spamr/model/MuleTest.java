package edu.gatech.spamr.model;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gatech.spamr.model.Map.MapType;
import edu.gatech.spamr.model.Store.Resource;

/**
 * MuleTest is a JUnit file to check if the buyMule method works.
 * There are three different tests to check for 1. player money
 * 2. tile type and 3. store quantity. 
 * 
 * @author Aditya Mittal
 * @version 1.0 11/20/2013
 */

public class MuleTest {

	@Test
	public void testMoney() {
		//initialize variables
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		
		//set money
		p1.setMoney(600);
		p2.setMoney(500);
		p3.setMoney(700);
		p4.setMoney(1000);

		int money1 = p1.getMoney();
		int money2 = p2.getMoney();
		int money3 = p3.getMoney();

		int money4 = p4.getMoney();
		

		Store store = new Store();
		store.getMulePrice(Resource.ENERGY);
		store.getMulePrice(Resource.FOOD);
		store.getMulePrice(Resource.ORE);

		Map map = new Map(MapType.DEFAULT);
		Tile[] tileArray = map.getMapArray();

		
		System.out.println(p1.getMoney());


		//create scenarios

		store.buyMULE(Resource.ENERGY, p1, tileArray[10]);

		System.out.println(p1.getMoney());
		assertEquals(p1.getMoney(), money1-(store.getMulePrice(Resource.ENERGY)));
		
		assertFalse(p1.getMoney() ==  money1-(store.getMulePrice(Resource.FOOD)));
		
		assertFalse(p1.getMoney() == money1-(store.getMulePrice(Resource.FOOD)));
		
		assertEquals(p1.getMoney(),
				money1 - (store.getMulePrice(Resource.ENERGY)));

		assertFalse(p1.getMoney() == money1
				- (store.getMulePrice(Resource.FOOD)));

		assertFalse(p1.getMoney() == money1
				- (store.getMulePrice(Resource.FOOD)));


		store.buyMULE(Resource.FOOD, p2, tileArray[12]);
		assertEquals(p2.getMoney(), money2
				- (store.getMulePrice(Resource.FOOD)));
		store.buyMULE(Resource.ORE, p3, tileArray[14]);

		assertEquals(p3.getMoney(), money3 -(store.getMulePrice(Resource.ORE)));
		
		store.buyMULE(Resource.ORE, p1, tileArray[17]);
		store.buyMULE(Resource.ORE, p1, tileArray[17]);
		store.buyMULE(Resource.ENERGY, p1, tileArray[17]);
		store.buyMULE(Resource.ORE, p1, tileArray[17]);
		
		store.buyMULE(Resource.ENERGY, p4, tileArray[13]);
		assertEquals(p4.getMoney(), money4 -(store.getMulePrice(Resource.ENERGY)));
		
		//assertEquals(p1.getMoney(), money1-(store.getMulePrice(Resource.ENERGY) + 5*store.getMulePrice(Resource.FOOD)));
		
		System.out.println(p1.getMoney());
			

		assertEquals(p3.getMoney(), money3 - (store.getMulePrice(Resource.ORE)));


	}

	@Test
	public void tileTest() {
		//initialize variables
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();

		p1.setMoney(900);
		p2.setMoney(600);
		p3.setMoney(500);
		

		Store store = new Store();
		store.getMuleQuantity();
		store.getMulePrice(Resource.ENERGY);
		store.getMulePrice(Resource.FOOD);
		store.getMulePrice(Resource.ORE);

		Map map = new Map(MapType.DEFAULT);
		Tile[] tileArray = map.getMapArray();
		
		//test conditions
		store.buyMULE(Resource.ENERGY, p1, tileArray[10]);
		store.buyMULE(Resource.FOOD, p2, tileArray[12]);
		store.buyMULE(Resource.ORE, p3, tileArray[35]);

		assertEquals(tileArray[10].getMule(), Resource.ENERGY);
		assertEquals(tileArray[12].getMule(), Resource.FOOD);
		assertEquals(tileArray[35].getMule(), Resource.ORE);
		assertFalse(tileArray[12].getMule() == Resource.ENERGY);

	}

	@Test
	public void storeTest() {
		//initialize variables
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();

		p1.setMoney(9000);
		p2.setMoney(700);
		p3.setMoney(600);
		
		Store store = new Store();
		store.getMuleQuantity();

		int numMules = store.getMuleQuantity();
		System.out.println(numMules);

		Map map = new Map(MapType.DEFAULT);
		Tile[] tileArray = map.getMapArray();
		

		store.buyMULE(Resource.FOOD, p1, tileArray[29]);
		store.buyMULE(Resource.ENERGY, p2, tileArray[35]);
		store.buyMULE(Resource.ORE, p3, tileArray[30]);
		
		assertEquals(store.getMuleQuantity(), numMules-3);

		//test conditions
		store.buyMULE(Resource.FOOD, p1, tileArray[10]);
		store.buyMULE(Resource.ENERGY, p2, tileArray[15]);
		store.buyMULE(Resource.ORE, p3, tileArray[20]);

		
		for(int i=0;i<23;i++){
			store.buyMULE(Resource.FOOD, p1, tileArray[i]);
		}
		assertEquals(store.getMuleQuantity(), 0);
	

		assertEquals(store.getMuleQuantity(), numMules - 3);


	}
	

}
