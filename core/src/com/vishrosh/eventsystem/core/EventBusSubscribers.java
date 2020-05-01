package com.vishrosh.eventsystem.core;

import java.util.ArrayList;

public class EventBusSubscribers {
	
	private static ArrayList<Object> eventBusSubscribers = new ArrayList<Object>();
	
	public static void RegisterToEventBus(Object obj) {
		if(EventBusSubscribers.eventBusSubscribers.contains(obj))return;
		EventBusSubscribers.eventBusSubscribers.add(obj);
	}
	
	public static int getObjectIdOf(Object object) {
		return EventBusSubscribers.getEventBusSubscibers().indexOf(object);
	}
	
	public static ArrayList<Object> getEventBusSubscibers(){
		return EventBusSubscribers.eventBusSubscribers;
	}
	
}
