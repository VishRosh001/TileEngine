package com.vishrosh.tileengine.gamestates.listeners;

import com.vishrosh.eventsystem.core.DefaultEventHandler;
import com.vishrosh.eventsystem.core.EventBus;
import com.vishrosh.eventsystem.core.IEventListener;
import com.vishrosh.tileengine.gamestates.events.LoadStateExitEvent;

public class LoadStateExitEventListener implements IEventListener<LoadStateExitEvent>{

	@Override
	public void onEvent(LoadStateExitEvent event) {
		EventBus.publishEvent(event, new DefaultEventHandler<LoadStateExitEvent>());
	}
}
