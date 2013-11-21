package edu.gatech.spamr.model;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/*
 * This JUnit tests the calcTurn() method in Round. 
 * Score is calculate by (Money/100) + Ore + Food + Energy. 
 * The method should return a player array in increasing score order.
 *  
 * @author Raj Prateek Kosaraju
 */
public class RoundTest {

	@Test
	public void calcTurnMoneyTest1() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Player p3 = new Player("p3");
		Player p4 = new Player("p4");
		
		//Only money is set. Food,Energy and Ore are set to 0. 
		p1.setMoney(1000);
		p2.setMoney(800);
		p3.setMoney(600);
		p4.setMoney(400);
		
		//Score is calculate by (Money/100) + Ore + Food + Energy.
		//expected sorted player array
		Player sorted[] = {p4,p3,p2,p1};

		//Initializing a round and setting it to a random Round number.
		Round round = new Round();
		round.setRoundNumber((new Random()).nextInt(15));
		
		//result from calcTurn() method.
		Player calcResult[] = round.calcTurn(p1, p2, p3, p4);

		assertTrue(calcResult[0]==sorted[0] && calcResult[1]==sorted[1] && 
				calcResult[2]==sorted[2] && calcResult[3]==sorted[3]);
	}
	
	@Test
	public void calcTurnOreTest2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Player p3 = new Player("p3");
		Player p4 = new Player("p4");
		
		//Only Ore is set. Food,Energy and Ore are set to 0.
		p1.setOre(1000);
		p2.setOre(800);
		p3.setOre(600);
		p4.setOre(400);

		//Score is calculate by (Money/100) + Ore + Food + Energy.
		//expected sorted player array :
		Player sorted[] = {p4,p3,p2,p1};

		//Initializing a round and setting it to a random Round number.
		Round round = new Round();
		round.setRoundNumber((new Random()).nextInt(15));

		//result from calcTurn() method.
		Player calcResult[] = round.calcTurn(p1, p2, p3, p4);

		assertTrue(calcResult[0]==sorted[0] && calcResult[1]==sorted[1] && 
				calcResult[2]==sorted[2] && calcResult[3]==sorted[3]);
	}
	
	@Test
	public void calcTurnFoodTest3() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Player p3 = new Player("p3");
		Player p4 = new Player("p4");
		
		//Only Food is set. Food,Energy and Ore are set to 0.
		p1.setFood(1000);
		p2.setFood(800);
		p3.setFood(600);
		p4.setFood(400);
		
		//Score is calculate by (Money/100) + Ore + Food + Energy.
		//expected sorted player array :
		Player sorted[] = {p4,p3,p2,p1};

		//Initializing a round and setting it to a random Round number.
		Round round = new Round();
		round.setRoundNumber((new Random()).nextInt(15));

		//result from calcTurn() method.
		Player calcResult[] = round.calcTurn(p1, p2, p3, p4);

		assertTrue(calcResult[0]==sorted[0] && calcResult[1]==sorted[1] && 
				calcResult[2]==sorted[2] && calcResult[3]==sorted[3]);
	}
	
	@Test
	public void calcTurnEnergyTest4() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Player p3 = new Player("p3");
		Player p4 = new Player("p4");
		
		//Only Energy is set. Food,Energy and Ore are set to 0.
		p1.setEnergy(1000);
		p2.setEnergy(800);
		p3.setEnergy(600);
		p4.setEnergy(400);

		//Score is calculate by (Money/100) + Ore + Food + Energy.
		//expected sorted player array :		
		Player sorted[] = {p4,p3,p2,p1};

		//Initializing a round and setting it to a random Round number.
		Round round = new Round();
		round.setRoundNumber((new Random()).nextInt(15));

		//result from calcTurn() method.
		Player calcResult[] = round.calcTurn(p1, p2, p3, p4);

		assertTrue(calcResult[0]==sorted[0] && calcResult[1]==sorted[1] && 
				calcResult[2]==sorted[2] && calcResult[3]==sorted[3]);
	}
	
	@Test
	public void calcTurnOverallTest5() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Player p3 = new Player("p3");
		Player p4 = new Player("p4");
		
		// Energy, Food, Ore and Money are set for all players.
		p1.setEnergy(400);
		p2.setEnergy(600);
		p3.setEnergy(800);
		p4.setEnergy(1000);
		
		p1.setFood(400);
		p2.setFood(600);
		p3.setFood(800);
		p4.setFood(1000);
		
		p1.setOre(400);
		p2.setOre(600);
		p3.setOre(800);
		p4.setOre(1000);
		
		p1.setMoney(4000);
		p2.setMoney(3000);
		p3.setMoney(2000);
		p4.setMoney(1000);
		
		//Score is calculate by (Money/100) + Ore + Food + Energy.
		//p1=1240. p2=1830. p3=2420. p4= 3010. 
		//Expected sorted array :
		Player correctSort[] = {p1,p2,p3,p4};
		
		//If player scores are ordered in decreasing order of scores
		Player wrongSort[] = {p4,p3,p2,p1};

		//Initializing a round and setting it to a random Round number.
		Round round = new Round();
		round.setRoundNumber((new Random()).nextInt(15));
		
		//result from calcTurn() method.
		Player calcResult[] = round.calcTurn(p1, p2, p3, p4);
		
		//asserting if the returned order is not in decreasing order of score.
		assertFalse(calcResult[0]==wrongSort[0] && calcResult[1]==wrongSort[1] && 
				calcResult[2]==wrongSort[2] && calcResult[3]==wrongSort[3]);
	}
	
	@Test
	public void calcTurnOverallTest6() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Player p3 = new Player("p3");
		Player p4 = new Player("p4");
		
		//Only Energy is set. Two players have 0 energy so that their scores are also 0.
		p1.setEnergy(1000);
		p2.setEnergy(800);
		p3.setEnergy(0);
		p4.setEnergy(0);

		//Score is calculate by (Money/100) + Ore + Food + Energy.
		//expected sorted player arrays :		
		Player sorted1[] = {p4,p3,p2,p1};
		Player sorted2[] = {p3,p4,p2,p1};

		//Initializing a round and setting it to a random Round number.
		Round round = new Round();
		round.setRoundNumber((new Random()).nextInt(15));

		//result from calcTurn() method. 
		Player calcResult[] = round.calcTurn(p1, p2, p3, p4);

		//checking whether calcTurn() returns either one of sorted1 or sorted2.
		assertTrue((calcResult[0]==sorted1[0] ||calcResult[0]==sorted2[0]) && 
				(calcResult[1]==sorted1[1] ||calcResult[1]==sorted2[1]) && 
				(calcResult[2]==sorted1[2] ||calcResult[2]==sorted2[2]) &&  
				(calcResult[3]==sorted1[3] ||calcResult[3]==sorted2[3]));
	}
	
	

}
