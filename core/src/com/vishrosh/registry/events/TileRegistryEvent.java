package com.vishrosh.registry.events;

import com.vishrosh.eventsystem.core.EventTypes;
import com.vishrosh.registry.core.CoreRegistry;
import com.vishrosh.tileengine.tile.Tile;

public class TileRegistryEvent extends ObjectRegistryEvent<Tile>{
	
	public TileRegistryEvent(CoreRegistry<Tile> itemRegistry) {
		super(EventTypes.TileRegistry, itemRegistry);
	}
	
	public CoreRegistry<Tile> getItemRegistry() {
		return super.getRegistry();
	}
}
