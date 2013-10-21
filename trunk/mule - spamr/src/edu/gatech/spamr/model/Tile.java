package edu.gatech.spamr.model;

import edu.gatech.spamr.model.Player.PlayerColor;

public class Tile {

	private int tileIndex;
	private Player owner;
	private Player.PlayerColor tileColor;
	private boolean owned;
	private TileType type;
	
	//Tile Constructor
	Tile(int index, TileType t){
		tileIndex = index;
		type = t;
		owned = false;
		owner = null;
		tileColor = PlayerColor.BLUE; // default
	}
	
	//description of TileTypes available
	public enum TileType{MOUNTAIN1(1,1,2), MOUNTAIN2(1,1,3), MOUNTAIN3(1,1,4), PLAIN(2,3,1), RIVER(4,2,0), TOWN(0,0,0);
	
	//variables
	private final int foodProduction;
	private final int energyProduction;
	private final int oreProduction;
	
	//TileType Constructor
	TileType(int fProd, int eProd, int oProd){
		foodProduction = fProd;
		energyProduction = eProd;
		oreProduction = oProd;
	}
	
	//getters and setters
	public int getFoodProduction(){
		return foodProduction;
	}
	
	public int getEnergyProduction(){
		return energyProduction;
	}
	
	public int getOreProduction(){
		return oreProduction;
	}
	}
	
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
	
	
	
	
}
