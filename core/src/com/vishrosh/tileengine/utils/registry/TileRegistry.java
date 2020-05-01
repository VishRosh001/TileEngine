package com.vishrosh.tileengine.utils.registry;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;

import com.vishrosh.tileengine.tile.Tile;

public class TileRegistry implements SEEDRegistry<Tile>{
	
	public static Logger logger = null;
	
	private final HashMap<Integer, Tile> TilesMap;
	
	private final TileRegistry instance;
	
	public TileRegistry() {
		logger = new Logger("Tile Registry");
		this.instance = this;
		this.TilesMap = new HashMap<Integer, Tile>();
	}
	
	@Override
	public void register(Tile tile) {
		boolean registerTile = true;
		for(Tile t : this.TilesMap.values()) {
			if(t.getUnlocalisedName().equalsIgnoreCase(tile.getUnlocalisedName())) {
				Gdx.app.error("Tile Registry", "The name already exists!");
				registerTile = false;
				break;
			}
		}
		
		if(registerTile == true) {
			tile.setTileID(this.getNewTileID());
			this.TilesMap.put(tile.getTileID(), tile);
		}
	}
	
	public void registerAll(Tile ...tiles){
		for(Tile tile : tiles) {
			this.register(tile);
		}
	}
	
	public HashMap<Integer, Tile> getTiles(){
		return this.TilesMap;
	};

	@Override
	public TileRegistry getReigstry() {
		return this.instance;
	}
	
	private int getNewTileID() {
		int newID = 0;
		if(!this.getTiles().isEmpty()) {
			return this.getTiles().size();
		}
		return newID;
	}
}
