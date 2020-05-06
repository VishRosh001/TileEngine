package com.vishrosh.tileengine.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.vishrosh.tileengine.utils.camera.OrthoCamera;
import com.vishrosh.tileengine.utils.maths.MathUtilities;
import com.vishrosh.tileengine.world.utils.ChunkUtils;

public class MapGenerator {
	public MapNoiseInitialiser mapNoise;
	public ChunksGenerator chunkGen;
	
	public MapGenerator() {
		this.mapNoise = new MapNoiseInitialiser();
		this.chunkGen = new ChunksGenerator(this.mapNoise.simplexNoise);
	}
	
	public void loadChunks() {
		this.chunkGen.setup();
		this.chunkGen.loadChunk("0.0/0.0");
		//this.chunkGen.loadChunk("0.0/1.0");
		//this.chunkGen.loadChunk("1.0/1.0");
		//this.chunkGen.loadChunk("1.0/0.0");
	}
	
	public void keepOrderr() {
		this.chunkGen.keepOrder();
	}
	
	public void renderChunks(OrthoCamera camera, SpriteBatch batch) {
		this.chunkGen.loadedChunks.forEach((key, value) -> {value.drawChunk(camera, batch, ChunksGenerator.worldGenTiles);});
	}
	
	public void chunkSystem(Vector2 playerPos) {
		Vector2 chunkPos = ChunkUtils.mapWorldPosToChunkPos(playerPos);
		String chunkPosAsString = MathUtilities.combineVector2String(chunkPos);
		this.chunkGen.loadChunk(chunkPosAsString);
		this.chunkGen.loadedChunks.forEach((key, value) -> {if(!key.equals(chunkPosAsString)) {value.unloadChunk();}});
	}
	
	
}
