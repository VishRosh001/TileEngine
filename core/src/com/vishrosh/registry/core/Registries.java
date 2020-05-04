package com.vishrosh.registry.core;

import com.vishrosh.tileengine.item.Item;
import  com.vishrosh.tileengine.tile.Tile;

public class Registries{
	
	private static Registries instance = null;
	
	public CoreRegistry<Tile> TILES;
	public CoreRegistry<Item> ITEMS;
	
	@SuppressWarnings("unchecked")
	public void initialiseRegistries() {
		this.TILES = (CoreRegistry<Tile>) RegistryManager.getRegistry(Tile.class);
		this.ITEMS = (CoreRegistry<Item>) RegistryManager.getRegistry(Item.class);
	}
	
	private Registries() {
		RegistryManager.createRegistries();
		this.initialiseRegistries();
	}
	
	public static Registries getRegistries() {
		if(Registries.instance == null)return new Registries();
		return Registries.instance;
	}
	
}
