package com.vishrosh.tileengine.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.vishrosh.eventsystem.core.EventBus;
import com.vishrosh.eventsystem.core.EventBusSubscribers;
import com.vishrosh.logger.core.Logger;
import com.vishrosh.registry.core.Registries;
import com.vishrosh.registry.events.TileRegistryEvent;
import com.vishrosh.registry.listeners.TileRegistryEventListener;
import com.vishrosh.resourceloader.TextureLoader;
import com.vishrosh.statemachine.core.GameState;
import com.vishrosh.statemachine.core.GameStateManager;
import com.vishrosh.statemachine.core.State;
import com.vishrosh.tileengine.tile.Tiles;

public class LoadGameState extends GameState{
	
	TextureLoader loader = new TextureLoader();

	public LoadGameState() {
		super(State.Load);
	}

	@Override
	public void onLoad() {
		this.setLoaded(true);
	}

	@Override
	public void onResize(int width, int height) {
		
	}

	@Override
	public void update(float deltaTime) {
		boolean loadingGame = true;
		
		EventBusSubscribers.RegisterToEventBus(new Tiles());
		EventBus.registerMethodsToEvents();
		
		TileRegistryEventListener tileRegistryEvent = new TileRegistryEventListener();
		
		//Logger.getLogger(this.getClass()).logInfo("Object Registry", "Registering tiles...");
		tileRegistryEvent.onEvent(new TileRegistryEvent(Registries.getRegistries().TILES));
		
		loader.createTextureAtlas();
		loader.loadTextureAtlas();
		
		loadingGame = false;
		
		if(loadingGame == false) {
			GameStateManager.getManager().setNextState(State.Play);
			GameStateManager.getManager().exitCurrentState(true);
			return;
		}
	}

	@Override
	public void render() {
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void input() {
		
	}

	@Override
	public void onExit() {
		System.out.println("Exitingdf");
		//loader.disposeAtlas();
	}

}
