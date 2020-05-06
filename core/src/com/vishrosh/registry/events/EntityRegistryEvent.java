package com.vishrosh.registry.events;

import com.vishrosh.eventsystem.core.EventTypes;
import com.vishrosh.registry.core.CoreRegistry;
import com.vishrosh.tileengine.entity.Entity;

public class EntityRegistryEvent extends ObjectRegistryEvent<Entity>{

	public EntityRegistryEvent(CoreRegistry<Entity> registry) {
		super(EventTypes.EntityRegistry, registry);
	}
	
	public CoreRegistry<Entity> getRegistry() {
		return super.getRegistry();
	}

}
