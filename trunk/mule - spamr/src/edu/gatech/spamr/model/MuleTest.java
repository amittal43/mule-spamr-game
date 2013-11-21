package edu.gatech.spamr.model;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gatech.spamr.model.Map.MapType;
import edu.gatech.spamr.model.Store.Resource;

public class MuleTest {

	@Test
	public void testMoney() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		
		p1.setMoney(600);
		p2.setMoney(500);
		p3.setMoney(700);
		p4.setMoney(1000);
		
		int money1 = p1.getMoney();
		int money2 = p2.getMoney();
		int money3 = p3.getMoney();
		
		
		Store store = new Store();
		store.getMuleQuantity();
		store.getMulePrice(Resource.ENERGY);
		store.getMulePrice(Resource.FOOD);
		store.getMulePrice(Resource.ORE);
		
		Map map = new Map(MapType.DEFAULT);
		Tile[] tileArray = map.getMapArray();
		
	
		store.buyMULE(Resource.ENERGY, p1, tileArray[10]);
		assertEquals(p1.getMoney(), money1-(store.getMulePrice(Resource.ENERGY)));
		
		assertFalse(p1.getMoney() ==  money1-(store.getMulePrice(Resource.FOOD)));
		
		assertFalse(p1.getMoney() == money1-(store.getMulePrice(Resource.FOOD)));
		
		store.buyMULE(Resource.FOOD, p2, tileArray[12]);
		assertEquals(p2.getMoney(), money2-(store.getMulePrice(Resource.FOOD)));
		store.buyMULE(Resource.ORE, p3, tileArray[14]);
		assertEquals(p3.getMoney(), money3 -(store.getMulePrice(Resource.ORE)));
			
	}
	@Test
	public void tileTest(){
		
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();

		
		Store store = new Store();
		store.getMuleQuantity();
		store.getMulePrice(Resource.ENERGY);
		store.getMulePrice(Resource.FOOD);
		store.getMulePrice(Resource.ORE);
		
		Map map = new Map(MapType.DEFAULT);
		Tile[] tileArray = map.getMapArray();
		
		store.buyMULE(Resource.ENERGY, p1, tileArray[10]);
		store.buyMULE(Resource.FOOD, p2, tileArray[12]);
		store.buyMULE(Resource.ORE, p3, tileArray[35]);
		
		assertEquals(tileArray[10].getMule(), Resource.ENERGY);
		assertEquals(tileArray[12].getMule(), Resource.FOOD);
		assertEquals(tileArray[35].getMule(), Resource.ORE);
		assertFalse(tileArray[12].getMule() == Resource.ENERGY);
		
		
	}
	
	@Test
	public void storeTest(){
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		
		Store store = new Store();
		store.getMuleQuantity();
		
		int numMules = store.getMuleQuantity();

		Map map = new Map(MapType.DEFAULT);
		Tile[] tileArray = map.getMapArray();
		
		store.buyMULE(Resource.FOOD, p1, tileArray[10]);
		store.buyMULE(Resource.ENERGY, p2, tileArray[15]);
		store.buyMULE(Resource.ORE, p3, tileArray[20]);
		
		assertEquals(store.getMuleQuantity(), numMules-3); 
		

	}

}







