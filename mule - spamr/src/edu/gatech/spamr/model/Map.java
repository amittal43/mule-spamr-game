package edu.gatech.spamr.model;

import java.util.ArrayList;

import edu.gatech.spamr.model.Tile.TileType;


public class Map {
	private MapType mapType;
	private Tile[] properties = new Tile[45];
	
	//Default Map Array for M.U.L.E.
	private TileType[] defaultMap = new TileType[]{TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN1, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.MOUNTAIN3, TileType.PLAIN, TileType.PLAIN,
			TileType.PLAIN, TileType.MOUNTAIN1, TileType.PLAIN, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN3,
			TileType.MOUNTAIN3, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.TOWN, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN1,
			TileType.PLAIN, TileType.MOUNTAIN2, TileType.PLAIN, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.MOUNTAIN2, TileType.PLAIN, TileType.PLAIN,
			TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN2, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN2 };

	
	public enum MapType{DEFAULT, OTHER};
	
	public MapType getMapType(){
		return mapType;
	}
	
	public void setMapType(MapType type){
		mapType = type;
	}

}
