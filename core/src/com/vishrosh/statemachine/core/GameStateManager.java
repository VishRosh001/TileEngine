package com.vishrosh.statemachine.core;

public class GameStateManager {
	
	private State currentState;
	
	private State nextState;
	
	public GameStateManager() {
		this.setCurrentState(State.Start);
		this.nextState = null;
	}
	
	public void loadCurrentState() {
		if(GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).isLoaded())return;
		GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).onLoad();
	}
	
	public void updateCurrentState(double deltaTime) {
		if(!GameStateRegistry.getRegistry().getRegisteredGameState(currentState).isLoaded())return;
		GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).update(deltaTime);
	}
	
	public void renderCurrentState() {
		if(!GameStateRegistry.getRegistry().getRegisteredGameState(currentState).isLoaded())return;
		GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).render();
	}
	
	public void handleCurrentStateInput() {
		
	}
	
	public void exitCurrentState(boolean loadNextState) {
		GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).onExit();
		GameStateRegistry.getRegistry().getRegisteredGameState(currentState).setLoaded(false);
		if(this.nextState != null && loadNextState)this.setCurrentState(this.nextState);
	}
	
	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		if(this.getCurrentState() == currentState)return;
		this.currentState = currentState;
		if(this.getCurrentState() == this.getNextState())this.setNextState(null);
	}

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		if(this.getNextState() == nextState)return;
		this.nextState = nextState;
	}
	
	
}
