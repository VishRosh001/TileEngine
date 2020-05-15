package com.vishrosh.tileengine;

import java.awt.Rectangle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Matrix4;
import com.vishrosh.font.FontRenderer;
import com.vishrosh.resourceloader.TextureLoader;
import com.vishrosh.statemachine.core.GameStateManager;
import com.vishrosh.statemachine.core.GameStateRegistry;
import com.vishrosh.statemachine.core.State;
import com.vishrosh.tileengine.gamestates.LoadGameState;
import com.vishrosh.tileengine.gamestates.PlayGameState;
import com.vishrosh.tileengine.utils.camera.OrthoCamera;
import com.vishrosh.ui.Button;
import com.vishrosh.ui.Label;
import com.vishrosh.ui.Text;
import com.vishrosh.ui.UIContainer;
import com.vishrosh.ui.UIContainerChild;
import com.vishrosh.ui.UIMatrix;

public class TileEngine extends Game {
	public static final GridPoint2 SIZE = new GridPoint2(1280, 720);
	public static SpriteBatch batch;
	public static OrthoCamera camera;
	
	public static GameStateManager stateManager;
	Matrix4 screenMatrix;
	
	UIContainer container;
	UIContainerChild btn;
	Label lbl;
	
	@Override
	public void create () {
		TileEngine.batch = new SpriteBatch();
		TileEngine.camera = new OrthoCamera(TileEngine.SIZE.x, TileEngine.SIZE.x);
		
		UIMatrix.setUIMatrix(TileEngine.batch.getProjectionMatrix().cpy().setToOrtho2D(0, 0, TileEngine.SIZE.x, TileEngine.SIZE.y));
		
		FontRenderer fontRenderer = new FontRenderer(TileEngine.batch);
		Text.setRenderer(fontRenderer);
		GameStateRegistry.getRegistry().registerGameState(new LoadGameState());
		GameStateRegistry.getRegistry().registerGameState(new PlayGameState());
		
		stateManager = GameStateManager.getManager();
		stateManager.setCurrentState(State.Load);
		stateManager.loadCurrentState();
		
		container = new UIContainer("test", State.Play, new Rectangle(400, 100, 10, 10));
		btn = new Button("hell");
		lbl = new Label("tree");
		Label.setFontRenderer(fontRenderer);
		lbl.setLabelText("Hello");
		//container.addToContainer(btn);
		container.addToContainer(lbl);
		
		container.load();
		
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		TileEngine.SIZE.set(width, height);
		TileEngine.camera.setCameraSize(width, height);
		UIMatrix.getUIMatrix().setToOrtho2D(0, 0, width, height);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stateManager.updateCurrentState(Gdx.graphics.getDeltaTime());
		stateManager.renderCurrentState();
		
		TileEngine.batch.flush();
		TileEngine.batch.setProjectionMatrix(UIMatrix.getUIMatrix());
		
		container.render();
		
		TileEngine.batch.begin();
		Text.renderText("FPS: " + Gdx.graphics.getFramesPerSecond(), 2, Gdx.graphics.getHeight()-18);
		String sizeText = "SIZE: " + Gdx.graphics.getWidth() + " X " + Gdx.graphics.getHeight();
		Text.renderText(sizeText, 2, Gdx.graphics.getHeight()-35);
		TileEngine.batch.end();
		
	}
	
	@Override
	public void dispose () {
		TextureLoader.disposeAtlas();
		container.destroyChildren();
		//stateManager.exitCurrentState(false);
	}
}
