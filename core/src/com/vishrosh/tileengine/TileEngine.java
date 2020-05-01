package com.vishrosh.tileengine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.vishrosh.tileengine.entity.Player;
import com.vishrosh.tileengine.utils.camera.OrthoCamera;
import com.vishrosh.tileengine.world.MapGenerator;

public class TileEngine extends Game {
	SpriteBatch batch;
	public static Texture[] imgs;
	
	Player player;
	
	MapGenerator map;
	
	private OrthoCamera camera;
	float seconds = 0f;
	
	@Override
	public void create () {	
		
		batch = new SpriteBatch();
		player = new Player();
		imgs = new Texture[4];
		imgs[0] = new Texture("water.png");
		imgs[1] = new Texture("dirt.png");
		imgs[2] = new Texture("grass.png");
		imgs[3] = new Texture("snow.png");
		
		camera = new OrthoCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		this.map = new MapGenerator();
	}
	
	void renderTileMap() {
		this.map.renderChunks(this.camera, this.batch);
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		this.map.loadChunks(this.batch);
		this.map.keepOrderr();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.map.keepOrderr();
		
		this.renderTileMap();
		player.playerMovement();
		
		batch.begin();
		player.getSprite().draw(batch);
		batch.end();
		
		camera.setCameraTarget(player.getPosition().x, player.getPosition().y);
		System.out.println("FPS: " + Gdx.graphics.getFramesPerSecond());
		System.out.println("Delta Time: " + Gdx.graphics.getDeltaTime());
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.destoryEntity();
		for(Texture img : imgs) {
			img.dispose();
		}
	}
}
