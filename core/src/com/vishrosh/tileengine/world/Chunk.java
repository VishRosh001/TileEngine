package com.vishrosh.tileengine.world;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import com.vishrosh.tileengine.utils.camera.OrthoCamera;
import com.vishrosh.tileengine.utils.maths.MathUtilities;
import com.vishrosh.tileengine.utils.noise.NoiseGenerator;
import com.vishrosh.tileengine.world.utils.ChunkUtils;

public class Chunk{
	public final static int CHUNK_SIZE = 16;
	
	public NoiseGenerator noiseGen;
	public Vector2 position;
	
	public boolean isLoaded;
	int[] tileMap;
	
	public Chunk(Vector2 chunkPos, NoiseGenerator noise) {
		this.tileMap = new int[Chunk.CHUNK_SIZE*Chunk.CHUNK_SIZE];
		this.position = chunkPos;
		this.noiseGen = noise;
		isLoaded = false;
	}
	
	public void loadChunk() {
		for(int i = 0; i < Chunk.CHUNK_SIZE*Chunk.CHUNK_SIZE; i++) {
			Vector2 coords = new Vector2(MathUtilities.map1DIndexTo2DIndex(i, Chunk.CHUNK_SIZE));
			coords = this.mapChunkBlocksToWorld(coords);
			double noise = noiseGen.getNoise((int)coords.x, (int)coords.y);
			tileMap[i] = this.getTileFromHeight(noise);
		}
		isLoaded = true;
	}
	
	private Vector2 mapChunkBlocksToWorld(Vector2 coords) {
		Vector2 worldCoords = new Vector2(0, 0);
		Vector2 chunkCoords = ChunkUtils.mapChunkPosToWorldPos(this.position);
		worldCoords.x = chunkCoords.x + (16* coords.x);
		worldCoords.y = chunkCoords.y + (16* coords.y);
		
		return worldCoords;
		
	}
	
	public void drawChunk(OrthoCamera camera, SpriteBatch batch, Sprite[] tiles) {
		batch.setProjectionMatrix(camera.getCamera().combined);
		
		for(int i = 0; (i < Chunk.CHUNK_SIZE*Chunk.CHUNK_SIZE) && isLoaded; i++) {
			Vector2 coords = new Vector2(MathUtilities.map1DIndexTo2DIndex(i, Chunk.CHUNK_SIZE));
			coords = this.mapChunkBlocksToWorld(coords);
			batch.begin();
			batch.draw(tiles[this.getTileMap()[i]], coords.x, coords.y);
			batch.end();
		}
	}
	
	public boolean isLoaded() { 
		return this.isLoaded;
	}
	
	public int[] getTileMap() {
		return this.tileMap;
	}
	
	public void unloadChunk() {
		//this.tileMap = null;
		this.isLoaded = false;
	}
	
	public void removeChunk() {
		this.unloadChunk();
		this.tileMap = null;
	}
	
	private int getTileFromHeight(double value) {
		int tile;
		
		if(value < 0.4) {
			tile = 0; 
		}else if(value >= 0.4 && value < 0.44) {
			tile = 1;
		}else if(value >= 0.44 && value < 0.7) {
			tile = 2;
		}else {
			tile = 3;
		}
		return tile;
	}
	
}
