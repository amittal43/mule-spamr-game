package edu.gatech.spamr.model;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.spamr.model.Store.Resource;

public class SellResourcesTest {

	Store s1;
	Player p1;
	Player p2;
	Player p3;
	
	@Before
	public void setUp() {
		
		//initalizing the store
		s1 = new Store();
		
		//players for certain cases
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();
		
		//no resources
		p1.setFood(0);
	    p1.setEnergy(0);
	    p1.setOre(0);
	    p1.setMoney(100);
	    
	    //single resources
	    p2.setFood(1);
	    p2.setEnergy(1);
	    p2.setOre(1);
	    p2.setMoney(100);
	    
	    //correct non singluar input
	    p3.setFood(5);
	    p3.setEnergy(5);
	    p3.setOre(5);
	    p3.setMoney(100);    
	}

	@Test
	public final void testSellResource() {
		
		//player owns no resources and tries to sell them
		//attempts to sell 5 Food when the player owns nothing
		setUp();
		s1.sellResource(p1, Resource.FOOD, 5);
		
		//attempts to sell 5 Energy when the player owns nothing
		setUp();
		s1.sellResource(p1, Resource.ENERGY, 5);
		
		//attempts to sell 5 Ore when the player owns nothing
		setUp();
		s1.sellResource(p1, Resource.ORE, 5);
		
		
		//player owns a resource but sells more than they have
		//attempts to sell 5 Food when the player owns 1
		setUp();
		s1.sellResource(p2, Resource.FOOD, 5);
		
		//attempts to sell 5 Energy when the player owns 1
		setUp();
		s1.sellResource(p2, Resource.ENERGY, 5);
		
		//attempts to sell 5 Ore when the player owns 1
		setUp();
		s1.sellResource(p2, Resource.ORE, 5);
		
		
		//player sells the exact number of a resource that they have
		//attempts to sell 5 Food when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.FOOD, 5);
		
		//attempts to sell 5 Energy when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.ENERGY, 5);
		
		//attempts to sell 5 Ore when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.ORE, 5);
		
		
		//player sells less of a resource than they have
		//attempts to sell 3 Food when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.FOOD, 3);
		
		//attempts to sell 3 Energy when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.ENERGY, 3);
		
		//attempts to sell 3 Ore when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.ORE, 3);
		
		
		//player attempts to sell nothing
		//attempts to sell 0 Food when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.FOOD, 0);
		
		//attempts to sell 0 Energy when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.ENERGY, 0);
		
		//attempts to sell 0 Ore when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.ORE, 0);
		
		
		//player attempts to sell a single negative quantity of a resource
		//attempts to sell -1 Food when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.FOOD, -1);
		
		//attempts to sell -1 Energy when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.ENERGY, -1);
		
		//attempts to sell -1 Ore when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.ORE, -1);
		
		
		//player attempts to sell a negative amount of a resource
		//attempts to sell -2 Food when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.FOOD, -2);
		
		//attempts to sell -2 Energy when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.ENERGY, -2);
		
		//attempts to sell -2 Ore when the player owns 5
		setUp();
		s1.sellResource(p3, Resource.ORE, -2);

		
		
		
		fail("Not yet implemented"); // TODO
	}

}
