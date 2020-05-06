package com.vishrosh.tileengine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vishrosh.logger.core.Logger;
import com.vishrosh.registry.core.Registries;
import com.vishrosh.resourceloader.TextureLoader;
import com.vishrosh.statemachine.core.GameStateManager;
import com.vishrosh.statemachine.core.GameStateRegistry;
import com.vishrosh.statemachine.core.State;
import com.vishrosh.tileengine.gamestates.LoadGameState;
import com.vishrosh.tileengine.gamestates.PlayGameState;
import com.vishrosh.tileengine.utils.camera.OrthoCamera;

public class TileEngine extends Game {
	public static SpriteBatch batch;
	public static  OrthoCamera camera;
	
	Logger logger;
	GameStateManager stateManager;
	
	@Override
	public void create () {
		
		GameStateRegistry.getRegistry().registerGameState(new LoadGameState());
		GameStateRegistry.getRegistry().registerGameState(new PlayGameState());
		
		stateManager = GameStateManager.getManager();
		
		stateManager.setCurrentState(State.Load);
		stateManager.loadCurrentState();

		System.out.println(Registries.getRegistries().TILES.getRegistry().getRegistryObjects().size());
		
		TileEngine.batch = new SpriteBatch();
		TileEngine.camera = new OrthoCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		logger = Logger.getLogger(this.getClass());
		//logger.setIsDateTimePrinted(false);
		//logger.setIsLoggerNamePrinted(false);
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		//stateManager.onResize(width, height);
		//stateManager.loadCurrentState();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//logger.logInfo("State Manager", ""+stateManager.getCurrentState());
		stateManager.updateCurrentState(Gdx.graphics.getDeltaTime());
		stateManager.renderCurrentState();
		
		Sprite s = TextureLoader.getSprite("snow");
		
		TileEngine.batch.begin();
		s.draw(TileEngine.batch);
		TileEngine.batch.end();
		
		return;
		/*
		logger.logInfo("FPS", Integer.toString(Gdx.graphics.getFramesPerSecond()));
		logger.logInfo("Delta Time", Float.toString(Gdx.graphics.getDeltaTime()));*/
		
	}
	
	@Override
	public void dispose () {
		TextureLoader.disposeAtlas();
		//stateManager.exitCurrentState(false);
	}
}
