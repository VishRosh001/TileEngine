package com.vishrosh.registry.events;

import com.vishrosh.eventsystem.core.EventTypes;
import com.vishrosh.registry.core.CoreRegistry;
import com.vishrosh.tileengine.item.Item;

public class ItemRegistryEvent extends ObjectRegistryEvent<Item> {
	
	public ItemRegistryEvent(CoreRegistry<Item> itemRegistry) {
		super(EventTypes.ItemRegistry, itemRegistry);
	}
	
	public CoreRegistry<Item> getRegistry() {
		return super.getRegistry();
	}

}
