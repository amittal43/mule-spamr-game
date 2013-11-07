package edu.gatech.spamr.model;

public class Store {
	
	private int foodQuantity = Game.getDifficulty().getStoreFood();
	private int energyQuantity = Game.getDifficulty().getStoreEnergy();
	private int oreQuantity = Game.getDifficulty().getStoreOre();
	private int muleQuantity = Game.getDifficulty().getStoreMULES();
	
	public enum Resource{FOOD, ENERGY, ORE}
	
	public void buyResource(Player p, Resource r, int number){ // still need to implement money differences
		if(r==Resource.FOOD){
			p.setFood(p.getFood() + number);
			foodQuantity -= number;
		}
		
		if(r==Resource.ENERGY){
			p.setEnergy(p.getEnergy() + number);
			energyQuantity -= number;
		}
		
		if(r==Resource.ORE){
			p.setOre(p.getOre() + number);
			oreQuantity -= number;
		}
	}
	
	public void buyMULE(Resource type, Player player, Tile tile){ // under construction
		muleQuantity--;
		//tile.setMule(type);
	}
	
}
