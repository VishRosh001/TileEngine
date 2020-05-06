package com.vishrosh.tileengine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
	
	GameStateManager stateManager;
	FPSLogger loggerFps = new FPSLogger();
	
	@Override
	public void create () {
		
		GameStateRegistry.getRegistry().registerGameState(new LoadGameState());
		GameStateRegistry.getRegistry().registerGameState(new PlayGameState());
		
		stateManager = GameStateManager.getManager();
		stateManager.setCurrentState(State.Load);
		stateManager.loadCurrentState();
		
		TileEngine.batch = new SpriteBatch();
		TileEngine.camera = new OrthoCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		loggerFps.log();
		
		stateManager.updateCurrentState(Gdx.graphics.getDeltaTime());
		stateManager.renderCurrentState();
		
		TileEngine.batch.begin();
		Gdx.graphics.setTitle(""+Gdx.graphics.getFramesPerSecond());
		TileEngine.batch.end();
		
	}
	
	@Override
	public void dispose () {
		TextureLoader.disposeAtlas();
		//stateManager.exitCurrentState(false);
	}
}
