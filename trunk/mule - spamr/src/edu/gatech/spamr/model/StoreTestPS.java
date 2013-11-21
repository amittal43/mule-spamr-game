package edu.gatech.spamr.model;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gatech.spamr.model.Store.Resource;

/**
 * StoreTestPS is a JUnit file to check if the buyResource method works.
 * There are two different tests to check for 1. player money and
 * 2. resource quantity. 
 * 
 * @author Puja Sheth
 * @version 1.0 11/20/2013
 */

public class StoreTestPS {

	@Test
	public void testPlayerMoney() {
		// initialize fake players
		Player Bob = new Player();
		Player Sue = new Player();
		Player Ben = new Player();

		// give players fake amount of money
		Bob.setMoney(340);
		Sue.setMoney(750);
		Ben.setMoney(101);

		// set the amount of money of each fake player to a variable
		int bobMoney = Bob.getMoney();
		int sueMoney = Sue.getMoney();
		int benMoney = Ben.getMoney();

		// initialize more variables needed for test
		Store test = new Store();
		test.getFoodPrice();
		test.getEnergyPrice();
		test.getOrePrice();

		// create some hypothetical scenarios for players
		test.buyResource(Bob, Resource.FOOD, 3);
		assertEquals(Bob.getMoney(), bobMoney - (3 * (test.getFoodPrice())));

		test.buyResource(Sue, Resource.ENERGY, 2);
		assertEquals(Sue.getMoney(), sueMoney - (2 * (test.getEnergyPrice())));

		test.buyResource(Ben, Resource.ORE, 4);
		assertEquals(Ben.getMoney(), benMoney - (4 * (test.getOrePrice())));

	}

	@Test
	public void testStoreQuantity() {
		// initialize fake players
		Player Bob = new Player();
		Player Sue = new Player();
		Player Ben = new Player();

		// initialize more variables needed for test
		Store test = new Store();
		int fvalue = test.getFoodQuantity();
		int evalue = test.getEnergyQuantity();
		int ovalue = test.getOreQuantity();

		// create some hypothetical scenarios for the store test
		test.buyResource(Bob, Resource.FOOD, 1);
		test.buyResource(Bob, Resource.FOOD, 3);
		test.buyResource(Bob, Resource.FOOD, 5);
		test.buyResource(Sue, Resource.ENERGY, 2);
		test.buyResource(Sue, Resource.ENERGY, 4);
		test.buyResource(Ben, Resource.ORE, 4);

		assertEquals(test.getFoodQuantity(), fvalue - 9);
		assertEquals(test.getEnergyQuantity(), evalue - 6);
		assertEquals(test.getOreQuantity(), ovalue - 4);
	}

}