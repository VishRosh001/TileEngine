package com.vishrosh.tileengine.gamestates.events;

import com.vishrosh.eventsystem.core.Event;
import com.vishrosh.eventsystem.core.EventTypes;

public class LoadStateExitEvent extends Event{
	
	public LoadStateExitEvent() {
		super(EventTypes.LoadStateExit);
	}

}
