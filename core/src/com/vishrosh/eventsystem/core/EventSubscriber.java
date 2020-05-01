package com.vishrosh.eventsystem.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Optional;

import com.vishrosh.eventsystem.utils.EventVector;

public class EventSubscriber {
	
	private ArrayList<EventVector> eventSubscribers = null;
	
	
	public EventSubscriber(int classID){
		this.getOrCreateEventVector(classID);
	}
	
	public EventSubscriber(int classID, Method method){
		this.addSubscriber(classID, method);
	}
	
	public void addSubscriber(int classID, Method method) {
		EventVector eventVector = this.getOrCreateEventVector(classID);
		
		if(!(eventVector.doesMethodExist(method))) {
			eventVector.addMethod(method);
			return;
		}
		System.out.println("[Event Registry] The method " + method + " is already registered");
	}
	
	public EventVector getOrCreateEventVector(int classID) {
		if(this.eventSubscribers == null)this.createArrayList();
		Optional<EventVector> a  = this.getEventSubscribers().stream().filter((e) -> e.getClassID()== classID).findFirst();
		
		if(a.isPresent()) return a.get();
		EventVector e = new EventVector(classID);
		this.eventSubscribers.add(e);
		return e;
			 
	}
	
	public ArrayList<EventVector> getEventSubscribers(){
		return this.eventSubscribers;
	}
	
	public boolean removeSubscriber(Method m) {
		for(int i = 0; i < this.eventSubscribers.size(); i++) {
			if(this.eventSubscribers.get(i).doesMethodExist(m)) {
				this.eventSubscribers.get(i).removeMethod(m);
				return true;
			}
		}
		return false;
		
	}
	
	private void createArrayList() {
		this.eventSubscribers = new ArrayList<>(5);
	}
	
}
