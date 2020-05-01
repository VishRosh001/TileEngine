package com.vishrosh.eventsystem.core;

public class Event{
	
	private EventTypes type;
	private boolean cancellable;
	
	public Event(EventTypes type) {
		this.type = type;
		this.setCancellable(false);
	}
	
	public EventTypes getType() {
		return this.type;
	}

	public boolean isCancellable() {
		return cancellable;
	}

	public void setCancellable(boolean cancellable) {
		this.cancellable = cancellable;
	}
}
