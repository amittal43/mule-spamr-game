package edu.gatech.spamr.model;

import java.io.Serializable;

public class Store implements Resource, Serializable {
	
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
	
	public void buyResource(Player currentPlayer, Resource relevantResource, int quantity){ // still need to implement money differences
		if(relevantResource==Resource.FOOD){
			currentPlayer.setFoodQuantity(currentPlayer.getFoodQuantity() + quantity);
			foodQuantity -= quantity;
			currentPlayer.updateMoney(-(foodPrice * quantity));
		}
		
		if(relevantResource==Resource.ENERGY){
			currentPlayer.setEnergyQuantity(currentPlayer.getEnergy() + quantity);
			energyQuantity -= quantity;
			currentPlayer.updateMoney(-(energyPrice * quantity));
		}
		
		if(relevantResource==Resource.ORE){
			currentPlayer.setOreQuantity(currentPlayer.getOre() + quantity);
			oreQuantity -= quantity;
			currentPlayer.updateMoney(-(orePrice * quantity));
		}
	}
	
	public void buyMULE(Resource type, Player currentPlayer, Tile tile){
		if(muleQuantity != 0){
			muleQuantity--;
		}	
		if(type == Resource.FOOD){
			if(currentPlayer.getMoney() < (mulePrice + foodFee)){
				System.out.println("Player doesn't have enough money!");
			}	
			else	
				currentPlayer.updateMoney(-(mulePrice + foodFee));
		}		
		if(type == Resource.ENERGY){

			if(currentPlayer.getMoney() < (mulePrice + energyFee)){
				System.out.println("Player doesn't have enough money!");
			}	
			else
				currentPlayer.updateMoney(-(mulePrice + energyFee));
		}		
		if(type == Resource.ORE){
			if(currentPlayer.getMoney() < (mulePrice + oreFee)){
				System.out.println("Player doesn't have enough money!");
			}	
			else
				currentPlayer.updateMoney(-(mulePrice + oreFee));
		}		
		tile.setMule(type);
	}
	
	public void sellResource(Player currentPlayer, Resource relevantResource, int quantity){
		if(quantity > 0){
			if(relevantResource == Resource.FOOD){
				if (currentPlayer.getFoodQuantity() >= quantity){
					currentPlayer.setFoodQuantity(currentPlayer.getFoodQuantity() - quantity);
					foodQuantity += quantity;
					currentPlayer.updateMoney(foodPrice*quantity/2);
				}else {
					System.out.println("Player doesn't have " + quantity + " Food to sell");
				}
			} else if(relevantResource == Resource.ENERGY){
				if (currentPlayer.getEnergy() >= quantity) {
					currentPlayer.setEnergyQuantity(currentPlayer.getEnergy() - quantity);
					energyQuantity += quantity;
					currentPlayer.updateMoney(energyPrice*quantity/2);
				} else {
					System.out.println("Player doesn't have " + quantity + " Energy to sell");
				}
			} else if(relevantResource == Resource.ORE){
				if (currentPlayer.getOre() >= quantity){
					currentPlayer.setOreQuantity(currentPlayer.getOre() - quantity);
					oreQuantity += quantity;
					currentPlayer.updateMoney(orePrice*quantity/2);
				} else {
					System.out.println("Player doesn't have " + quantity + " Ore to sell");
				}
			} else {
				//should not be possible to reach because there are only the 3 above enums defined
				System.out.println(relevantResource + " is not a valid resource to sell this way.");
			}
		} else {
			System.out.println(quantity + " is not a valid quantity to sell");
		}
	}
	
	//getters and setters
	public int getFoodQuantity(){
		return foodQuantity;
	}
	
	public void setFoodQuantity(int food){
		foodQuantity = food;
	}
	
	public int getOreQuantity(){
		return oreQuantity;
	}
	
	public void setOreQuantity(int ore){
		oreQuantity = ore;
	}
	
	public int getEnergyQuantity(){
		return energyQuantity;
	}
	
	public void setEnergyQuantity(int energy){
		energyQuantity = energy;
	}
	
	public int getMuleQuantity(){
		return muleQuantity;
	}
	
	public void setMuleQuantity(int mule){
		muleQuantity = mule;
	}
	
	public int getFood(){
		return foodPrice;
	}
	
	public int getEnergy(){
		return energyPrice;
	}
	
	public int getOre(){
		return orePrice;
	}
	
	public int getMulePrice(Resource type) {
		int toReturn = -1;
		
		if (type.equals(Resource.FOOD)){
			toReturn = mulePrice + foodFee;
			
		} else if (type.equals(Resource.ENERGY)){
			toReturn = mulePrice + energyFee;
			
		} else if (type.equals(Resource.ORE)){
			toReturn = mulePrice + oreFee;
			
		} else {
			System.out.println("not a valid Resource ENUM!");
		}
		return toReturn;
	}

	@Override
	public int getMoney() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMoney(int m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calcScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
