package edu.gatech.spamr.model;

import java.util.ArrayList;

import edu.gatech.spamr.model.Tile.TileType;


public class Map {
	private MapType mapType;
	private Tile[] properties = new Tile[45];
	
	//Default Map Array for M.U.L.E.
	private static TileType[] defaultMap = new TileType[]{TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN1, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.MOUNTAIN3, TileType.PLAIN, TileType.PLAIN,
			TileType.PLAIN, TileType.MOUNTAIN1, TileType.PLAIN, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN3,
			TileType.MOUNTAIN3, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.TOWN, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN1,
			TileType.PLAIN, TileType.MOUNTAIN2, TileType.PLAIN, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.MOUNTAIN2, TileType.PLAIN, TileType.PLAIN,
			TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN2, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN2 };

	private static TileType[] otherMap = null; // not yet implemented
	
	public enum MapType{DEFAULT(defaultMap), OTHER(otherMap);
	
	private TileType[] mapLayout;
	
	MapType(TileType[] array){
		mapLayout = array;
	}
	
	public TileType[] getMapLayout(){
		return mapLayout;
	}
	}
	
	public Map(MapType m){
		mapType = m;
		TileType[] mapLayout = mapType.getMapLayout();
		for(int i=0; i<properties.length; i++){
			properties[i] = new Tile(i, mapLayout[i]);
		}
	}
	
	public MapType getMapType(){
		return mapType;
	}
	
	public void setMapType(MapType type){
		mapType = type;
	}
	
	public Tile[] getMapArray(){
		return properties;
	}

}
