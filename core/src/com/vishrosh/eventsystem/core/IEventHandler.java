package com.vishrosh.eventsystem.core;

import com.vishrosh.eventsystem.core.Event;

public interface IEventHandler<T extends Event>{
	
	public boolean handle(T event);
	
}
