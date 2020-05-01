package com.vishrosh.statemachine.core;

import java.util.HashMap;

public class GameStateRegistry {

	private static GameStateRegistry stateRegistry = null;
	
	private HashMap<State, GameState> registeredStates = null;
	
	private GameStateRegistry() {
		this.registeredStates = new HashMap<>(5);
	}
	
	public static GameStateRegistry getRegistry() {
		if(GameStateRegistry.stateRegistry == null)GameStateRegistry.stateRegistry = new GameStateRegistry();
		return GameStateRegistry.stateRegistry;
	}
	
	public void registerGameState(GameState state) {
		if(!this.doesGameStateExist(state.getState())) {
			this.getRegisteredStates().put(state.getState(), state);
		}else {
			System.out.println("[GameState Registry] The state " + state.getState() + " is already registered");
		}
	}
	
	public boolean doesGameStateExist(State state) {
		return this.getRegisteredStates().containsKey(state);
	}
	
	public GameState getRegisteredGameState(State state) {
		if(this.getRegisteredStates().containsKey(state)) {
			return this.getRegisteredStates().get(state);
		}
		System.out.println("[GameState Registry] The state " + state + " is not registered");
		return null;
	}
	
	public HashMap<State, GameState> getRegisteredStates(){
		return this.registeredStates;
	}
	
	
}
