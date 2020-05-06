package com.vishrosh.tileengine.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.vishrosh.logger.core.Logger;
import com.vishrosh.statemachine.core.GameState;
import com.vishrosh.statemachine.core.State;
import com.vishrosh.tileengine.TileEngine;
import com.vishrosh.tileengine.entity.Player;
import com.vishrosh.tileengine.utils.camera.OrthoCamera;
import com.vishrosh.tileengine.world.ChunksGenerator;
import com.vishrosh.tileengine.world.MapGenerator;

public class PlayGameState extends GameState{
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
		//this.map.loadChunks();
		//this.map.keepOrderr();
	}

	@Override
	public void onLoad() {
		this.batch = TileEngine.batch;
		this.camera = TileEngine.camera;
		
		this.map = new MapGenerator();
		
		this.map.loadChunks();
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
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		this.renderTileMap();
		this.map.keepOrderr();
		
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
		for(Sprite r: ChunksGenerator.worldGenTiles)r.getTexture().dispose();
	}
	
	void renderTileMap() {
		this.map.renderChunks(this.camera, this.batch);
	}

}