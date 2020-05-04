package com.vishrosh.registry.events;

import com.vishrosh.eventsystem.core.EventTypes;
import com.vishrosh.registry.core.ObjectRegistry;
import com.vishrosh.tileengine.tile.Tile;

public class TileRegistryEvent extends ObjectRegistryEvent<Tile>{
	
	public TileRegistryEvent(ObjectRegistry<Tile> itemRegistry) {
		super(EventTypes.TileRegistry, itemRegistry);
	}
	
	public ObjectRegistry<Tile> getItemRegistry() {
		return super.getRegistry();
	}
}
