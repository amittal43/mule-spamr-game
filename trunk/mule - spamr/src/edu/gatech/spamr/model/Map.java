package edu.gatech.spamr.model;


public class Map {
	private MapType mapType;
	private Tile[] properties = new Tile[45];
	
	//TODO - Create Map ARRAY (45 TileType enums)
	
	public enum MapType{DEFAULT, OTHER};
	
	public MapType getMapType(){
		return mapType;
	}
	
	public void setMapType(MapType type){
		mapType = type;
	}

}
