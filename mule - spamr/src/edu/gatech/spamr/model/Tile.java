package edu.gatech.spamr.model;

import java.awt.Color;
import java.io.Serializable;

import edu.gatech.spamr.model.Player.PlayerColor;
import edu.gatech.spamr.model.Store.Resource;

/** 
 * The Tile class represents the an array in which the map is represented
 * using the images from the resources folder
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/22/2013 
 */

public class Tile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7801672119397358752L;
	
	//tile Variables
	private int tileIndex;
	private Player owner;
	private Player.PlayerColor tileColor;
	private boolean owned;
	private TileType type;
	private Color c;
	private Resource mule = null;
	
	//Tile Constructor
	Tile(int index, TileType t){
		tileIndex = index;
		type = t;
		owned = false;
		owner = null;
		tileColor = PlayerColor.BLUE; // default
	}
	
	public enum TileColor{BLUE, GREEN, RED, YELLOW, BLACK }
	
	//description of TileTypes available
	public enum TileType{MOUNTAIN1(1,1,2,"/edu/gatech/spamr/resources/mountain1.gif"),
							MOUNTAIN2(1,1,3,"/edu/gatech/spamr/resources/mountain2.gif"),
							 MOUNTAIN3(1,1,4, "/edu/gatech/spamr/resources/mountain1.gif"), 
							  PLAIN(2,3,1, "/edu/gatech/spamr/resources/potter/snow.jpg"),
							   RIVER(4,2,0, "/edu/gatech/spamr/resources/riverTest2-2.gif"),
							   RIVER2(4,2,0, "/edu/gatech/spamr/resources/riverTest3.gif"),
							    TOWN(0,0,0, "/edu/gatech/spamr/resources/potter/Hogwarts_night_tile.jpg");
	
		//variables for TileType
		private final int foodProduction;
		private final int energyProduction;
		private final int oreProduction;
		private String iconLocation;
		
		//TileType Constructor
		TileType(int fProd, int eProd, int oProd, String icon){
			foodProduction = fProd;
			energyProduction = eProd;
			oreProduction = oProd;
			iconLocation = icon;
		}
		
		//getters and setters for TileType
		public int getFoodProduction(){
			return foodProduction;
		}
		
		public int getEnergyProduction(){
			return energyProduction;
		}
		 
		public int getOreProduction(){
			return oreProduction;
		}
		
		public String getIcon(){
			return iconLocation;
		}
	}
	
	//getters and setters for Tile
	public int getTileIndex(){
		return tileIndex;
	}
	
	public void setTileIndex(int i){
		tileIndex = i;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public void setOwner(Player p){
		owner = p;
		owned = true;
	}
	
	public TileType getTileType(){
		return type;
	}
	
	public void setTileType(TileType t){
		type = t;
	}
	
	public boolean isOwned(){
		return owned;
	}
	
	public void setOwned(boolean own){
		owned = own;
	}

	public void setBorderColor(Color color) {
		color = c;
	}
	
	public void setMule(Resource type){
		mule = type;
	}
	
	public Resource getMule(){
		return mule;
	}
	
	public void processProduction(){
		if(!isOwned() || mule==null)
			return;
		
		if(owner.getEnergy()==0){
			System.out.println("The MULE on Tile " + tileIndex + " doesn't have enough energy to produce");
		}

		owner.setEnergy(owner.getEnergy()-1); // one unit of energy used to produce
		
		if(mule==Resource.FOOD){
			System.out.println(owner.getName() + " produced " + type.getFoodProduction() + " Food on Tile " + tileIndex);
			owner.setFood(owner.getFood() + type.getFoodProduction());
		}
		
		else if(mule==Resource.ENERGY){
			System.out.println(owner.getName() + " produced " + type.getEnergyProduction() + " Energy on Tile " + tileIndex);
			owner.setEnergy(owner.getEnergy() + type.getEnergyProduction());
		}
		
		else if(mule==Resource.ORE){
			System.out.println(owner.getName() + " produced " + type.getOreProduction() + " Ore on Tile " + tileIndex);
			owner.setOre(owner.getOre() + type.getOreProduction());
		}
		
	}
	
}
