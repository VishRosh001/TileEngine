package com.vishrosh.eventsystem.core;

import com.vishrosh.eventsystem.utils.EventHelpers;

public class DefaultEventHandler<T extends Event> implements IEventHandler<T>{
	
	public boolean handle(T event) {
		EventHelpers.defaultEventHandler(event);
		return false;
	}
}
