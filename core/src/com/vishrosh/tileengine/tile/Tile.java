package com.vishrosh.tileengine.tile;

import com.vishrosh.registry.core.ObjectRegistryEntry;

public class Tile extends ObjectRegistryEntry<Tile>{
	
	int tileID;
	
	String unlocalisedName;
	String localisedName;
	
	public Tile() {
		//this.setUnlocalisedName(this.getRegistryName().getRegistryName());
	}
	
	public int getTileID() {
		return this.tileID;
	}
	
	public void setTileID(int id) {
		this.tileID = id;
	}
	
	public String getUnlocalisedName() {
		return this.unlocalisedName;
	}
	
	public String getLocalisedName() {
		return this.localisedName;
	}
	
	public void setUnlocalisedName(String name) {
		this.unlocalisedName = "tile.seed." + name;
		this.setLocalisedName(this.unlocalisedName);
	}
	
	public void setLocalisedName(String name) {
		this.localisedName = name;
	}
	
}
