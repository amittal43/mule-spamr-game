package edu.gatech.spamr.model;

public interface Resource {
	
	
	public int getFoodQuantity();
	
	public void setFoodQuantity(int food);
	
	public int getOreQuantity();
	
	public void setOreQuantity(int ore);
	
	public int getEnergyQuantity();
	
	public void setEnergyQuantity(int energy);
	
	public int getMuleQuantity();
	
	public void setMuleQuantity(int mule);
	
	public int getFood();
	
	public int getEnergy();
	
	public int getOre();
	
	public int getMoney();
	
	public void setMoney(int m);
	
	public int calcScore();
	
	

}
