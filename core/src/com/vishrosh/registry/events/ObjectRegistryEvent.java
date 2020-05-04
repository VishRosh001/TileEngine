package com.vishrosh.registry.events;

import com.vishrosh.eventsystem.core.Event;
import com.vishrosh.eventsystem.core.EventTypes;
import com.vishrosh.registry.core.CoreRegistry;
import com.vishrosh.registry.core.ObjectRegistryEntry;

public class ObjectRegistryEvent<T extends ObjectRegistryEntry<T>> extends Event{
	
	private CoreRegistry<T> registry;
	
	public ObjectRegistryEvent(EventTypes type, CoreRegistry<T> registry) {
		super(type);
		this.registry = registry;
	}
	
	public CoreRegistry<T> getRegistry() {
		return this.registry;
	}

}
