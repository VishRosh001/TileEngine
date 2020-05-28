package com.vishrosh.tileengine.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.GridPoint2;
import com.vishrosh.resourceloader.TextureLoader;
import com.vishrosh.tileengine.utils.maths.MathUtilities;
import com.vishrosh.tileengine.utils.noise.NoiseGenerator;

public class ChunksGenerator {
	private NoiseGenerator noise;
	public ArrayList<HashMap<String, Chunk>> chunks;
	
	public HashMap<String, Chunk> addedChunks;
	public HashMap<String, Chunk> loadedChunks;
	public HashMap<String, Chunk> unloadedChunks;
	
	public static Sprite[] worldGenTiles;
	
	public ChunksGenerator(NoiseGenerator noise){
		this.noise = noise;
		
		ChunksGenerator.worldGenTiles = new Sprite[4];
		this.addToWorldGenTiles();
		
		this.addedChunks = new HashMap<String, Chunk>();
		this.loadedChunks = new HashMap<String, Chunk>();
		this.unloadedChunks = new HashMap<String, Chunk>();
		
		this.chunks = new ArrayList<HashMap<String, Chunk>>();
		this.chunks.add(this.addedChunks);
		this.chunks.add(this.loadedChunks);
		this.chunks.add(this.unloadedChunks);
	}
	

	public void addToWorldGenTiles() {
		ChunksGenerator.worldGenTiles[0] = TextureLoader.getSprite("water");
		ChunksGenerator.worldGenTiles[1] = TextureLoader.getSprite("dirt");
		ChunksGenerator.worldGenTiles[2] = TextureLoader.getSprite("grass");
		ChunksGenerator.worldGenTiles[3] = TextureLoader.getSprite("snow");
	}
	
	public void addChunk(GridPoint2 position) {
		this.addedChunks.put(MathUtilities.gridPoint2String(position), new Chunk(position, this.noise));
		System.out.println(MathUtilities.gridPoint2String(position));
	}
	
	public void loadLoadedChunks() {
		this.loadedChunks.forEach((key, value) -> value.loadChunk());
	}
	
	public void loadChunk(String key) {
		if(this.addedChunks.containsKey(key))this.addedChunks.get(key).loadChunk();
		if(this.unloadedChunks.containsKey(key))this.unloadedChunks.get(key).loadChunk();
	}
	
	public void unloadChunk(String key) {
		if(this.loadedChunks.containsKey(key))this.loadedChunks.get(key).unloadChunk();
	}
	
	public void removeUnloadedChunks() {
		this.unloadedChunks.clear();
	}
	
	public void keepOrder() {
		this.addedChunks.forEach((key, value) -> {if(value.isLoaded()) {this.loadedChunks.put(key, value);this.addedChunks.replace(key, null);}});
		this.unloadedChunks.forEach((key, value) -> {if(value.isLoaded()) {this.loadedChunks.put(key, value);this.unloadedChunks.replace(key, null);}});
		this.loadedChunks.forEach((key, value) -> {if(!value.isLoaded()) {this.unloadedChunks.put(key, value); this.loadedChunks.replace(key, null);}});
		
		this.removeNullEntries(this.addedChunks);
		this.removeNullEntries(this.unloadedChunks);
		this.removeNullEntries(this.loadedChunks);
		
	}
	
	public void removeNullEntries(HashMap<?, ?> map) {
		Set<String> nullKeys = new HashSet<>();
		map.forEach((key, value) -> {if(value == null)nullKeys.add((String) key);});
		
		nullKeys.forEach((key) -> map.remove(key));
	}
	
	public void setNoise(NoiseGenerator noise) {
		this.noise = noise;
	}
	
	
}
