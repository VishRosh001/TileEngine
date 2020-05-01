package com.vishrosh.tileengine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vishrosh.logger.core.Logger;
import com.vishrosh.statemachine.core.GameStateManager;
import com.vishrosh.statemachine.core.GameStateRegistry;
import com.vishrosh.statemachine.core.State;
import com.vishrosh.tileengine.utils.camera.OrthoCamera;
import com.vishrosh.tileengine.gamestates.PlayGameState;

public class TileEngine extends Game {
	public static SpriteBatch batch;
	public static  OrthoCamera camera;
	
	Logger logger;
	
	GameStateManager stateManager;
	
	@Override
	public void create () {	
		GameStateRegistry.getRegistry().registerGameState(new PlayGameState());
		
		TileEngine.batch = new SpriteBatch();
		TileEngine.camera = new OrthoCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		stateManager = new GameStateManager();
		stateManager.setCurrentState(State.Play);
		stateManager.loadCurrentState();
		
		logger = Logger.getLogger(this.getClass());
		logger.setIsDateTimePrinted(false);
		logger.setIsLoggerNamePrinted(false);
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		stateManager.onResize(width, height);
		//stateManager.loadCurrentState();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stateManager.updateCurrentState(Gdx.graphics.getDeltaTime());
		stateManager.renderCurrentState();
		
		logger.logInfo("FPS", Integer.toString(Gdx.graphics.getFramesPerSecond()));
		logger.logInfo("Delta Time", Float.toString(Gdx.graphics.getDeltaTime()));
		
	}
	
	@Override
	public void dispose () {
		stateManager.exitCurrentState(false);
	}
}
