package com.vishrosh.tileengine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vishrosh.font.FontRenderer;
import com.vishrosh.resourceloader.TextureLoader;
import com.vishrosh.statemachine.core.GameStateManager;
import com.vishrosh.statemachine.core.GameStateRegistry;
import com.vishrosh.statemachine.core.State;
import com.vishrosh.tileengine.gamestates.LoadGameState;
import com.vishrosh.tileengine.gamestates.PlayGameState;
import com.vishrosh.tileengine.utils.camera.OrthoCamera;
import com.vishrosh.ui.Button;
import com.vishrosh.ui.Text;

public class TileEngine extends Game {
	public static SpriteBatch batch;
	public static SpriteBatch batch2;
	public static OrthoCamera camera;
	
	GameStateManager stateManager;
	Button btn;
	
	@Override
	public void create () {
		TileEngine.batch = new SpriteBatch();
		TileEngine.batch2 = new SpriteBatch();
		TileEngine.camera = new OrthoCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		FontRenderer fontRenderer = new FontRenderer(TileEngine.batch2);
		Text.setRenderer(fontRenderer);
		
		GameStateRegistry.getRegistry().registerGameState(new LoadGameState());
		GameStateRegistry.getRegistry().registerGameState(new PlayGameState());
		
		stateManager = GameStateManager.getManager();
		stateManager.setCurrentState(State.Load);
		stateManager.loadCurrentState();
		
		btn = new Button(State.Play, 10, 20);
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		TileEngine.camera.setCameraSize(width, height);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stateManager.updateCurrentState(Gdx.graphics.getDeltaTime());
		stateManager.renderCurrentState();
		
		Text.renderText("FPS: " + Gdx.graphics.getFramesPerSecond(), 2, Gdx.graphics.getHeight()-18);
		String sizeText = "SIZE: " + Gdx.graphics.getWidth() + " X " + Gdx.graphics.getHeight();
		Text.renderText(sizeText, 2, Gdx.graphics.getHeight()-35);
		btn.render(TileEngine.batch2);
	}
	
	@Override
	public void dispose () {
		TextureLoader.disposeAtlas();
		//stateManager.exitCurrentState(false);
	}
}
