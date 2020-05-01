package com.vishrosh.tileengine.tile;

import com.vishrosh.tileengine.tile.Tile;
import com.vishrosh.tileengine.utils.registry.TileRegistry;

public class Tiles {
	
	public static final int TILE_SIZE = 16;
	
	public static Tile UNKNOWN = new Tile("unknown");
	
	public final static TileRegistry tileRegistry = new TileRegistry();
	
	static {
		Tiles.getTileRegistry().registerAll(
			new Tile("air"),
			new Tile("dirt"),
			new Tile("grass"),
			new Tile("water"),
			new Tile("snow")
		);
	}
	
	public static TileRegistry getTileRegistry() {
		return Tiles.tileRegistry;
	}
	
}
