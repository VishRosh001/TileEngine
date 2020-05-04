package com.vishrosh.registry.listeners;

import com.vishrosh.eventsystem.core.DefaultEventHandler;
import com.vishrosh.eventsystem.core.EventBus;
import com.vishrosh.eventsystem.core.IEventListener;
import com.vishrosh.registry.events.ItemRegistryEvent;

public class ItemRegistryEventListener implements IEventListener<ItemRegistryEvent>{

	@Override
	public void onEvent(ItemRegistryEvent event) {
		EventBus.publishEvent(event, new DefaultEventHandler<ItemRegistryEvent>());
	}

}
