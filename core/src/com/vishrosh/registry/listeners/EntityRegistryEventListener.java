package com.vishrosh.registry.listeners;

import com.vishrosh.eventsystem.core.DefaultEventHandler;
import com.vishrosh.eventsystem.core.EventBus;
import com.vishrosh.eventsystem.core.IEventListener;
import com.vishrosh.registry.events.EntityRegistryEvent;

public class EntityRegistryEventListener implements IEventListener<EntityRegistryEvent>{

	@Override
	public void onEvent(EntityRegistryEvent event) {
		EventBus.publishEvent(event, new DefaultEventHandler<EntityRegistryEvent>());
	}

}
