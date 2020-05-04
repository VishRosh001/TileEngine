package com.vishrosh.registry.listeners;

import com.vishrosh.eventsystem.core.DefaultEventHandler;
import com.vishrosh.eventsystem.core.EventBus;
import com.vishrosh.eventsystem.core.IEventListener;
import com.vishrosh.registry.events.TileRegistryEvent;

public class TileRegistryEventListener implements IEventListener<TileRegistryEvent>{

	@Override
	public void onEvent(TileRegistryEvent event) {
		EventBus.publishEvent(event, new DefaultEventHandler<TileRegistryEvent>());
	}

}
