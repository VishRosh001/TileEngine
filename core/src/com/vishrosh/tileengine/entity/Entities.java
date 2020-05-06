package com.vishrosh.tileengine.entity;

import com.vishrosh.eventsystem.core.EventTypes;
import com.vishrosh.eventsystem.core.SubscribeEvent;
import com.vishrosh.registry.events.ObjectRegistryEvent;

public class Entities {
	
	@SubscribeEvent(event=EventTypes.EntityRegistry)
	public void registerVanillaEntities(ObjectRegistryEvent<Entity> event) {
		event.getRegistry().registerAll(
				new Player().setRegistryName("player"),
				new Entity().setRegistryName("enemy"));
	}
	
}
