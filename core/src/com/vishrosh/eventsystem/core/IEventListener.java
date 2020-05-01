package com.vishrosh.eventsystem.core;

public interface IEventListener <T extends Event>{
		
	public void onEvent(T event);
	
}
