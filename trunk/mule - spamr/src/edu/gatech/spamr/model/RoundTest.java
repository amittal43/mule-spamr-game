package edu.gatech.spamr.model;
import static org.junit.Assert.*;
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
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		p1.setMoney(1000);
		p2.setMoney(800);
		p3.setMoney(600);
		p4.setMoney(400);

		Player sorted[] = {p4,p3,p2,p1};

		Round round = new Round();

		Player calcResult[] = round.calcTurn(p1, p2, p3, p4);

		assertTrue(calcResult[0]==sorted[0] && calcResult[1]==sorted[1] && 
				calcResult[2]==sorted[2] && calcResult[3]==sorted[3]);
	}
	
	@Test
	public void calcTurnOreTest2() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		p1.setOre(1000);
		p2.setOre(800);
		p3.setOre(600);
		p4.setOre(400);

		Player sorted[] = {p4,p3,p2,p1};

		Round round = new Round();

		Player calcResult[] = round.calcTurn(p1, p2, p3, p4);

		assertTrue(calcResult[0]==sorted[0] && calcResult[1]==sorted[1] && 
				calcResult[2]==sorted[2] && calcResult[3]==sorted[3]);
	}
	
	@Test
	public void calcTurnFoodTest3() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		p1.setFood(1000);
		p2.setFood(800);
		p3.setFood(600);
		p4.setFood(400);

		Player sorted[] = {p4,p3,p2,p1};

		Round round = new Round();

		Player calcResult[] = round.calcTurn(p1, p2, p3, p4);

		assertTrue(calcResult[0]==sorted[0] && calcResult[1]==sorted[1] && 
				calcResult[2]==sorted[2] && calcResult[3]==sorted[3]);
	}
	
	@Test
	public void calcTurnEnergyTest4() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		p1.setEnergy(1000);
		p2.setEnergy(800);
		p3.setEnergy(600);
		p4.setEnergy(400);

		Player sorted[] = {p4,p3,p2,p1};

		Round round = new Round();

		Player calcResult[] = round.calcTurn(p1, p2, p3, p4);

		assertTrue(calcResult[0]==sorted[0] && calcResult[1]==sorted[1] && 
				calcResult[2]==sorted[2] && calcResult[3]==sorted[3]);
	}
	
	@Test
	public void calcTurnOverallTest5() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
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
		Player correctSort[] = {p1,p2,p3,p4};

		Round round = new Round();

		Player calcResult[] = round.calcTurn(p1, p2, p3, p4);

		assertTrue(calcResult[0]==correctSort[0] && calcResult[1]==correctSort[1] && 
				calcResult[2]==correctSort[2] && calcResult[3]==correctSort[3]);
	}
	
	

}
