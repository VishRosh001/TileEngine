package com.vishrosh.eventsystem.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.vishrosh.eventsystem.core.SubscribeEvent;
import com.vishrosh.eventsystem.core.Event;
import com.vishrosh.eventsystem.core.EventBus;
import com.vishrosh.eventsystem.core.EventBusSubscribers;
import com.vishrosh.eventsystem.core.EventSubscriber;
import com.vishrosh.eventsystem.core.EventTypes;

public class EventHelpers {
	
	public static void defaultEventHandler(Event event) {
		EventSubscriber map = EventBus.getEventSubscriber(event.getType());
		
		map.getEventSubscribers().forEach(eventVector ->{
			eventVector.getMethodList().forEach(method -> {
				try {
					method.invoke(EventBusSubscribers.getEventBusSubscibers().get(eventVector.getClassID()), event);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			});
		});
	}
	
	public static Method stringToMethod(String methodName, Event event, Class<?> clazz) {
		try {
			return clazz.getMethod(methodName, event.getClass());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static boolean isMethodVaild(Method m) {
		boolean isValid = false;
		
		if(m.isAnnotationPresent(SubscribeEvent.class)) {
			if(Modifier.isPublic(m.getModifiers())) {
				if(m.getParameterCount() == 1) {
					isValid = true;
				}
			}
		}
		
		return isValid;
	}
	
	public static boolean isMethodAnnotationValid(Method method) {
		return  method.getAnnotation(SubscribeEvent.class) == null ? false : true;
	}
	
	public static EventTypes getEventTypeFromMethod(Method method) {
		if(EventHelpers.isMethodAnnotationValid(method))return method.getAnnotation(SubscribeEvent.class).event();
		return EventTypes.Null;
	}
}
