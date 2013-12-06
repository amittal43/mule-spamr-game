package edu.gatech.spamr.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

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
	private Color colr;
	private Resource mule = null;
	
	//Tile Constructor
	Tile(int index, TileType ttype){
		tileIndex = index;
		type = ttype;
		owned = false;
		owner = null;
		tileColor = PlayerColor.BLUE; // default
	}
	
	public enum TileColor{BLUE, GREEN, RED, YELLOW, BLACK }
	
	//description of TileTypes available
	public enum TileType{MOUNTAIN1(1,1,2,"/edu/gatech/spamr/resources/mountain1.gif"),
							MOUNTAIN2(1,1,3,"/edu/gatech/spamr/resources/mountain2.gif"),
							 MOUNTAIN3(1,1,4, "/edu/gatech/spamr/resources/potter/mountain.gif"), 
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
		
		public static TileType getRandomTileType(){
			Random random = new Random();
			int randomNum = Math.abs(random.nextInt())%4;
			
			if(randomNum==0){
				return MOUNTAIN1;
			}
			else if(randomNum==1){
				return MOUNTAIN2;
			}
			else if(randomNum==2){
				return MOUNTAIN3;
			}
			else{
				return PLAIN;
			}
		}
	}
	
	//getters and setters for Tile
	public int getTileIndex(){
		return tileIndex;
	}
	
	public void setTileIndex(int indx){
		tileIndex = indx;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public void setOwner(Player play){
		owner = play;
		owned = true;
	}
	
	public TileType getTileType(){
		return type;
	}
	
	public void setTileType(TileType kind){
		type = kind;
	}
	
	public boolean isOwned(){
		return owned;
	}
	
	public void setOwned(boolean own){
		owned = own;
	}

	public void setBorderColor(Color color) {
		colr = color;
	}
	
	public void setMule(Resource type){
		mule = type;
	}
	
	public Resource getMule(){
		return mule;
	}
	
	public void processProduction(){
		if(!isOwned() || mule==null){
			return;
		}
		System.out.println("Food before Production: " + owner.getFoodQuantity());
		if(owner.getEnergyQuantity()==0){
			System.out.println("The MULE on Tile " + tileIndex + " doesn't have enough energy to produce");
		}else{

			owner.setEnergyQuantity(owner.getEnergyQuantity()-1); // one unit of energy used to produce
			
			if(mule==Resource.FOOD){
				System.out.println(owner.getName() + " produced " + type.getFoodProduction() + " Food on Tile " + tileIndex);
				
				owner.setFoodQuantity(owner.getFoodQuantity() + type.getFoodProduction());
				
			}
			
			else if(mule==Resource.ENERGY){
				System.out.println(owner.getName() + " produced " + type.getEnergyProduction() + " Energy on Tile " + tileIndex);
				owner.setEnergyQuantity(owner.getEnergyQuantity() + type.getEnergyProduction());
			}
			
			else if(mule==Resource.ORE){
				System.out.println(owner.getName() + " produced " + type.getOreProduction() + " Ore on Tile " + tileIndex);
				owner.setOreQuantity(owner.getOreQuantity() + type.getOreProduction());
			}
		}
		System.out.println("Food after Production: " + owner.getFoodQuantity());
	}
	
}
