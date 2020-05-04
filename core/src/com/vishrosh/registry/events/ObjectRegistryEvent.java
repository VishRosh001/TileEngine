package com.vishrosh.registry.events;

import com.vishrosh.eventsystem.core.Event;
import com.vishrosh.eventsystem.core.EventTypes;
import com.vishrosh.registry.core.ObjectRegistry;
import com.vishrosh.registry.core.ObjectRegistryEntry;

public class ObjectRegistryEvent<T extends ObjectRegistryEntry<T>> extends Event{
	
	private ObjectRegistry<T> registry;
	
	public ObjectRegistryEvent(EventTypes type, ObjectRegistry<T> registry) {
		super(type);
		this.registry = registry;
	}
	
	public ObjectRegistry<T> getRegistry() {
		return this.registry;
	}

}
