package edu.gatech.spamr.model;

import java.io.Serializable;

public class Store implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8447124918015466998L;
	
	//beginner Difficulty starting food
	private int foodQuantity = 16;
	private int energyQuantity = 16;
	private int oreQuantity = 0;
	private int muleQuantity = 25;

	
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
	
	//getters and setters
	public int getFoodQuantity(){
		return foodQuantity;
	}
	
	public void setFoodQuantity(int f){
		foodQuantity = f;
	}
	
	public int getOreQuantity(){
		return oreQuantity;
	}
	
	public void setOreQuantity(int o){
		oreQuantity = o;
	}
	
	public int getEnergyQuantity(){
		return energyQuantity;
	}
	
	public void setEnergyQuantity(int e){
		energyQuantity = e;
	}
	
	public int getMuleQuantity(){
		return muleQuantity;
	}
	
	public void setMuleQuantity(int m){
		muleQuantity = m;
	}
	
	public int getFoodPrice(){
		return foodPrice;
	}
	
	public int getEnergyPrice(){
		return energyPrice;
	}
	
	public int getOrePrice(){
		return orePrice;
	}
	
	public int getMulePrice(Resource r) {
		if (r.equals(Resource.FOOD))
			return mulePrice + foodFee;
		if (r.equals(Resource.ENERGY))
			return mulePrice + energyFee;
		if (r.equals(Resource.ORE))
			return mulePrice + oreFee;
		
		System.out.println("not a valid Resource ENUM!");
		return -1;
	}

	
}
