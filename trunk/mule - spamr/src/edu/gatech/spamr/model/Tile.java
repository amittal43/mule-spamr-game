package edu.gatech.spamr.model;

public class Tile {

	private int ownerNumber;
	private boolean owned;
	private TileType type;
	
	public enum TileType{MOUNTAIN1(1,1,2), MOUNTAIN2(1,1,3), MOUNTAIN3(1,1,4), PLAIN(2,3,1), RIVER(4,2,0);
	
	private final int foodProduction;
	private final int energyProduction;
	private final int oreProduction;
	
	TileType(int fProd, int eProd, int oProd){
		foodProduction = fProd;
		energyProduction = eProd;
		oreProduction = oProd;
	}
	
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
	
	public int getOwnerNumber(){
		return ownerNumber;
	}
	
	public void setOwnerNumber(int num){
		ownerNumber = num;
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
