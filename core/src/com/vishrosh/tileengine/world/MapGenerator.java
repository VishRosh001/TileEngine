package com.vishrosh.tileengine.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.vishrosh.tileengine.utils.camera.OrthoCamera;

public class MapGenerator {
	public MapNoiseInitialiser mapNoise;
	public ChunksGenerator chunkGen;
	
	
	public MapGenerator() {
		this.mapNoise = new MapNoiseInitialiser();
		this.chunkGen = new ChunksGenerator(this.mapNoise.simplexNoise);
	}
	
	public void loadChunks(SpriteBatch batch) {
		this.chunkGen.setup();
		this.chunkGen.loadChunk("0.0/0.0");
		this.chunkGen.loadChunk("0.0/1.0");
	}
	
	public void keepOrderr() {
		this.chunkGen.keepOrder();
	}
	
	public void renderChunks(OrthoCamera camera, SpriteBatch batch) {
		this.chunkGen.loadedChunks.forEach((key, value) -> {value.drawChunk(camera, batch);});
	}
	
	
	
}
