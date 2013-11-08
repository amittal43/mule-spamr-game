package edu.gatech.spamr.model;

public class Store {
	
	private int foodQuantity = Game.getDifficulty().getStoreFood();
	private int energyQuantity = Game.getDifficulty().getStoreEnergy();
	private int oreQuantity = Game.getDifficulty().getStoreOre();
	private int muleQuantity = Game.getDifficulty().getStoreMULES();
	//public Resource selected;
	
	// starting prices
	private int foodPrice = 30;
	private int energyPrice = 25;
	private int orePrice = 50;
	private int mulePrice = 100; // base price
	
	// mule price addons
	private final int foodFee = 25;
	private final int energyFee = 50;
	private final int oreFee = 75;
	
	public enum Resource{FOOD, ENERGY, ORE}
	
	public void buyResource(Player p, Resource r, int number){ // still need to implement money differences
		if(r==Resource.FOOD){
			p.setFood(p.getFood() + number);
			foodQuantity -= number;
			p.updateMoney(-(foodPrice * number));
		}
		
		if(r==Resource.ENERGY){
			p.setEnergy(p.getEnergy() + number);
			energyQuantity -= number;
			p.updateMoney(-(energyPrice * number));
		}
		
		if(r==Resource.ORE){
			p.setOre(p.getOre() + number);
			oreQuantity -= number;
			p.updateMoney(-(orePrice * number));
		}
	}
	
	public void buyMULE(Resource type, Player player, Tile tile){
		muleQuantity--;
		
		if(type == Resource.FOOD){
			player.updateMoney(-(mulePrice + foodFee));
		}
		
		if(type == Resource.ENERGY){
			player.updateMoney(-(mulePrice + energyFee));
		}
		
		if(type == Resource.ORE){
			player.updateMoney(-(mulePrice + oreFee));
		}
		
		tile.setMule(type);
	}
	
	public void sellResource(Player p, Resource r, int number){
		if(r == Resource.FOOD){
			p.setFood(p.getFood() - number);
			foodQuantity += number;
			p.updateMoney(foodPrice/2);
		}
		
		if(r == Resource.ENERGY){
			p.setEnergy(p.getEnergy() - number);
			energyQuantity += number;
			p.updateMoney(energyPrice/2);
		}
		
		if(r == Resource.ORE){
			p.setOre(p.getOre() - number);
			oreQuantity += number;
			p.updateMoney(orePrice/2);
		}
	}
	
}
