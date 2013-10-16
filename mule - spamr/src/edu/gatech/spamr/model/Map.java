package edu.gatech.spamr.model;

public class Map {
	private MapType mapType;
	
	public enum MapType{DEFAULT, OTHER};
	
	public MapType getMapType(){
		return mapType;
	}
	
	public void setMapType(MapType type){
		mapType = type;
	}

}
