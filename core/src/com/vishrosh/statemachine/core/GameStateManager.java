package com.vishrosh.statemachine.core;

import com.vishrosh.logger.core.Logger;

public class GameStateManager {
	
	public static GameStateManager instance;
	
	private State currentState;
	
	private State nextState;
	
	public static GameStateManager getManager() {
		if(GameStateManager.instance == null)GameStateManager.instance = new GameStateManager();
		return GameStateManager.instance;
	}
	
	private GameStateManager() {
		this.setCurrentState(State.Start);
		this.nextState = null;
	}
	
	public void loadCurrentState() {
		if(GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).isLoaded())return;
		//Logger.getCurrentLogger().logInfo("StateManager", "Loading " + this.getCurrentState());
		GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).onLoad();
	}
	
	public void onResize(int width, int height) {
		if(GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).isLoaded())return;
		GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).onResize(width, height);
	}
	
	public void updateCurrentState(float deltaTime) {
		if(!GameStateRegistry.getRegistry().getRegisteredGameState(currentState).isLoaded())return;
		//Logger.getCurrentLogger().logInfo("StateManager", "Updating " + this.currentState);
		GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).update(deltaTime);
	}
	
	public void renderCurrentState() {
		if(!GameStateRegistry.getRegistry().getRegisteredGameState(currentState).isLoaded())return;
		//Logger.getCurrentLogger().logInfo("StateManager", "Rendering " + this.currentState);
		GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).render();
	}
	
	public void handleCurrentStateInput() {
		
	}
	
	public void exitCurrentState(boolean loadNextState) {
		//Logger.getCurrentLogger().logInfo("StateManager", "Exiting " + this.currentState);
		GameStateRegistry.getRegistry().getRegisteredGameState(this.getCurrentState()).onExit();
		GameStateRegistry.getRegistry().getRegisteredGameState(currentState).setLoaded(false);
		if(this.nextState != null && loadNextState) {
			this.setCurrentState(this.nextState);
			this.loadCurrentState();
		}
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
