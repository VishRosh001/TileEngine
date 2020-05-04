package com.vishrosh.registry.core;

import com.vishrosh.tileengine.item.Item;
import  com.vishrosh.tileengine.tile.Tile;

public class Registeries{
	
	public static ObjectRegistry<Tile> TILES;
	public static ObjectRegistry<Item> ITEMS;
	
	@SuppressWarnings("unchecked")
	public void init() {
		Registeries.TILES = (ObjectRegistry<Tile>) RegistryManager.getRegistry(Tile.class);
		Registeries.ITEMS = (ObjectRegistry<Item>) RegistryManager.getRegistry(Item.class);
	}
	
	public Registeries() {
		RegistryManager.createRegistries();
		//this.init();
	}
	
}
