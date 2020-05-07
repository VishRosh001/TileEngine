package com.vishrosh.tileengine.world;

import java.util.ArrayList;
import java.util.List;

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
		int xRenderDistance = 1;
		int yRenderDistance = 1;
		
		Vector2 chunkPos = ChunkUtils.mapWorldPosToChunkPos(playerPos);
		this.chunkGen.addChunk(chunkPos);
		String chunkPosAsString = MathUtilities.combineVector2String(chunkPos);
		this.chunkGen.loadChunk(chunkPosAsString);
		
		List<String> chunksToGen = new ArrayList<>();
		
		for(int i = -(xRenderDistance-1); i < xRenderDistance; ++i) {
			for(int j = -(yRenderDistance-1); j < yRenderDistance; ++j) {
				String chunkToGen = MathUtilities.combineVector2String(new Vector2(chunkPos.x+i, chunkPos.y+j));
				System.out.println(i + ": " + chunkToGen);
				chunksToGen.add(chunkToGen);
				this.chunkGen.loadChunk(chunkToGen);
			}
		}
		this.chunkGen.loadedChunks.forEach((key, value) -> {if(!chunksToGen.contains(key)) {value.unloadChunk();}});
	}
	
	
}
