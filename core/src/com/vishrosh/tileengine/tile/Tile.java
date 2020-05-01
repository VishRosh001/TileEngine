package com.vishrosh.tileengine.tile;

public class Tile {
	
	int tileID;
	
	String unlocalisedName;
	String localisedName;
	
	public Tile(String name) {
		this.setUnlocalisedName(name);
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
