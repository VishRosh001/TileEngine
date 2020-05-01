package com.vishrosh.tileengine.gamestates;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vishrosh.logger.core.Logger;
import com.vishrosh.statemachine.core.GameState;
import com.vishrosh.statemachine.core.State;
import com.vishrosh.tileengine.TileEngine;
import com.vishrosh.tileengine.entity.Player;
import com.vishrosh.tileengine.utils.camera.OrthoCamera;
import com.vishrosh.tileengine.world.MapGenerator;

public class PlayGameState extends GameState{

	public static Texture[] imgs;
	MapGenerator map;
	SpriteBatch batch;
	OrthoCamera camera;
	
	Player player;
	
	Logger logger;
	
	public PlayGameState() {
		super(State.Play);
		logger = Logger.getLogger(this.getClass());
	}
	
	@Override
	public void onResize(int width, int height) {
		this.map.loadChunks(this.batch);
		this.map.keepOrderr();
	}

	@Override
	public void onLoad() {
		this.batch = TileEngine.batch;
		this.camera = TileEngine.camera;
		
		this.map = new MapGenerator();
		
		imgs = new Texture[4];
		imgs[0] = new Texture("water.png");
		imgs[1] = new Texture("dirt.png");
		imgs[2] = new Texture("grass.png");
		imgs[3] = new Texture("snow.png");
		
		this.map.loadChunks(batch);
		this.map.keepOrderr();
		
		this.player = new Player();
		
		this.setLoaded(true);
	}

	@Override
	public void update(float deltaTime) {
		player.playerMovement(deltaTime);
	}

	@Override
	public void render() {
		this.renderTileMap();
		this.map.keepOrderr();
		logger.logInfo("World Gen", "Genning Tiles");
		
		player.drawEntity(this.batch);
		
		camera.setCameraTarget(player.getPosition().x, player.getPosition().y);
	}

	@Override
	public void input() {
		
	}

	@Override
	public void onExit() {
		batch.dispose();
		player.destoryEntity();
		for(Texture img : imgs) {
			img.dispose();
		}
	}
	
	void renderTileMap() {
		this.map.renderChunks(this.camera, this.batch);
	}

}