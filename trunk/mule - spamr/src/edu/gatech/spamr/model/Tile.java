package edu.gatech.spamr.model;

import java.awt.Color;

import edu.gatech.spamr.model.Player.PlayerColor;

public class Tile {

	//tile Variables
	private int tileIndex;
	private Player owner;
	private Player.PlayerColor tileColor;
	private boolean owned;
	private TileType type;
	private Color c;
	
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
	public enum TileType{MOUNTAIN1(1,1,2,"/edu/gatech/spamr/resources/mountain1.png"),
							MOUNTAIN2(1,1,3,"/edu/gatech/spamr/resources/mountain2.png"),
							 MOUNTAIN3(1,1,4, "/edu/gatech/spamr/resources/mountain3.png"), 
							  PLAIN(2,3,1, "/edu/gatech/spamr/resources/plains.png"),
							   RIVER(4,2,0, "/edu/gatech/spamr/resources/river1.png"),
							    TOWN(0,0,0, "/edu/gatech/spamr/resources/town.png");
	
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
	
}
