package com.vishrosh.tileengine.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vishrosh.tileengine.utils.camera.OrthoCamera;
public class MapGenerator {
	public MapNoiseInitialiser mapNoise;
	public ChunksGenerator chunkGen;
	public ChunkManager chunkManager;
	
	public MapGenerator() {
		this.mapNoise = new MapNoiseInitialiser();
		this.chunkGen = new ChunksGenerator(this.mapNoise.simplexNoise);
		this.chunkManager = new ChunkManager();
		this.chunkManager.setChunkGen(this.chunkGen);
	}
	
	public void loadChunks() {
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
	
	/*public void chunkSystem(Vector2 playerPos) {
		int xRenderDistance = 2;
		int yRenderDistance = 1;
		
		List<String> chunksToGen = new ArrayList<>();
		
		for(int i = -(xRenderDistance-1); i < xRenderDistance; ++i) {
			for(int j = -(yRenderDistance-1); j < yRenderDistance; ++j) {
				String chunkToGen = MathUtilities.gridPoint2String(new GridPoint2((int)chunkPos.x+i, (int)chunkPos.y+j));
				System.out.println(i + ": " + chunkToGen);
				chunksToGen.add(chunkToGen);
				this.chunkGen.loadChunk(chunkToGen);
			}
		}
		this.chunkGen.loadedChunks.forEach((key, value) -> {if(!chunksToGen.contains(key)) {value.unloadChunk();}});
	}*/
	
	
}
