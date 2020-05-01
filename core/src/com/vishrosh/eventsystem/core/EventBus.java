package com.vishrosh.eventsystem.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

import com.vishrosh.eventsystem.utils.EventHelpers;
import com.vishrosh.eventsystem.core.EventSubscriber;
import com.vishrosh.eventsystem.core.EventTypes;

public class EventBus {
	private static HashMap<EventTypes, EventSubscriber> eventsSubscribersMap = new HashMap<>();
	
	public static  HashMap<EventTypes, EventSubscriber> getSubscribersMap() {
		return EventBus.eventsSubscribersMap;
	}
	
	public static EventSubscriber getEventSubscriber(EventTypes eventType){
		return EventBus.eventsSubscribersMap.get(eventType);
	}
	
	public static EventSubscriber getOrCreateEventSubscriber(EventTypes eventType, int objectID) {
		ReentrantLock lock = new ReentrantLock(true);
		lock.lock();
		
		EventSubscriber a = EventBus.getEventSubscriber(eventType);
		if(a != null) return a;
		
		a = new EventSubscriber(objectID);
		EventBus.getSubscribersMap().put(eventType, a);
		lock.unlock();
		
		return a;
	}
	
	private static void addMethodToMap(EventTypes eventType, Method method, int objectID) {
		EventSubscriber eventSub = EventBus.getOrCreateEventSubscriber(eventType, objectID);
		eventSub.addSubscriber(objectID, method);
	}
	
	public static void subscribeToEvent(Method method, int objectID) {
		if(!EventHelpers.isMethodVaild(method)) {
			System.out.println("[Event Registry] The method " + method.getName() + " is invalid");
			return;
		}
		EventTypes eventType = EventHelpers.getEventTypeFromMethod(method);
		if(eventType == EventTypes.Null)return;
		EventBus.addMethodToMap(eventType, method, objectID);
	}
	
	public static void unsubscribeToEvent(Method method) {
		EventTypes a = EventHelpers.getEventTypeFromMethod(method);
		
		if(a == EventTypes.Null) {
			System.err.println("[Event Registry] The method " + method.getName() + " does not subscribe to any event");
			return;
		}
		
		boolean b = EventBus.getSubscribersMap().get(a).removeSubscriber(method);
		if(!b)System.err.println("[Event Registry] The method " + method.toString() + " is not subscribed to the eventType " + a);
	}
	
	public static void registerMethodsToEvents() {
		for(int i = 0; i < EventBusSubscribers.getEventBusSubscibers().size(); ++i) {
			try {
				Object cs = EventBusSubscribers.getEventBusSubscibers().get(i);
				
				for(final Method m : cs.getClass().getDeclaredMethods()) {
					EventBus.subscribeToEvent(m, i);
				}
			}catch(Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Event> void publishEvent(Event event, IEventHandler<T> handler) { 
		if(EventBus.getSubscribersMap().isEmpty()) {System.out.println("[Event Registry] No Events to publish!"); return;}
		handler.handle((T)event);
	}
	
}
