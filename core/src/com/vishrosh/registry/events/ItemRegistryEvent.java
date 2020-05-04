package com.vishrosh.registry.events;

import com.vishrosh.eventsystem.core.EventTypes;
import com.vishrosh.registry.core.ObjectRegistry;
import com.vishrosh.tileengine.item.Item;

public class ItemRegistryEvent extends ObjectRegistryEvent<Item> {
	
	public ItemRegistryEvent(ObjectRegistry<Item> itemRegistry) {
		super(EventTypes.ItemRegistry, itemRegistry);
	}
	
	public ObjectRegistry<Item> getRegistry() {
		return super.getRegistry();
	}

}
