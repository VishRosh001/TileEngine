package com.vishrosh.statemachine.core;

public abstract class GameState{
	
	private boolean isLoaded;
	private State state;
	
	public GameState(State state) {
		this.setLoaded(false);
		this.setState(state);
	}
	
	public abstract void onLoad();
	
	public abstract void onResize(int width, int height);
	
	public abstract void update(float deltaTime);
	
	public abstract void render();
	
	public abstract void input();
	
	public abstract void onExit();

	public boolean isLoaded() {
		return isLoaded;
	}

	public void setLoaded(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public GameState getGameState() {
		return this;
	}
	
}
