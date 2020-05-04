package com.vishrosh.tileengine.tile;

import com.vishrosh.eventsystem.core.EventTypes;
import com.vishrosh.eventsystem.core.SubscribeEvent;
import com.vishrosh.registry.events.ObjectRegistryEvent;

public class Tiles {
	
	@SubscribeEvent(event=EventTypes.TileRegistry)
	public void registerVanillaTiles(ObjectRegistryEvent<Tile> event) {
		event.getRegistry().registerAll(
				new Tile().setRegistryName("dirt"),
				new Tile().setRegistryName("grass"),
				new Tile().setRegistryName("water"),
				new Tile().setRegistryName("snow"));
	}
	
}
