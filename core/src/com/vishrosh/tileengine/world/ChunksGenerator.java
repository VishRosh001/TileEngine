package com.vishrosh.tileengine.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.vishrosh.resourceloader.TextureLoader;
import com.vishrosh.tileengine.tile.Tiles;
import com.vishrosh.tileengine.utils.maths.MathUtilities;
import com.vishrosh.tileengine.utils.noise.NoiseGenerator;

public class ChunksGenerator {
	private NoiseGenerator noise;
	public ArrayList<HashMap<String, Chunk>> chunks;
	
	public HashMap<String, Chunk> addedChunks;
	public HashMap<String, Chunk> loadedChunks;
	public HashMap<String, Chunk> unloadedChunks;
	
	public static Texture[] worldGenTiles;
	
	public ChunksGenerator(NoiseGenerator noise){
		this.noise = noise;
		
		ChunksGenerator.worldGenTiles = new Texture[4];
		this.addWorldGenTiles();
		
		this.addedChunks = new HashMap<String, Chunk>();
		this.loadedChunks = new HashMap<String, Chunk>();
		this.unloadedChunks = new HashMap<String, Chunk>();
		
		this.chunks = new ArrayList<HashMap<String, Chunk>>();
		this.chunks.add(this.addedChunks);
		this.chunks.add(this.loadedChunks);
		this.chunks.add(this.unloadedChunks);
	}
	
	public void setup() {
		this.addChunk(new Vector2(0, 0));
		this.addChunk(new Vector2(0, 1));
		this.addChunk(new Vector2(1, 1));
		this.addChunk(new Vector2(-1, 0));
	}
	
	public void addWorldGenTiles() {
		
		/*TextureLoader.loadTexture(Tiles.getTileRegistry().getTileFromRegistryName("water").resourceLocation);
		TextureLoader.loadTexture(Tiles.getTileRegistry().getTileFromRegistryName("dirt").resourceLocation);
		TextureLoader.loadTexture(Tiles.getTileRegistry().getTileFromRegistryName("grass").resourceLocation);
		TextureLoader.loadTexture(Tiles.getTileRegistry().getTileFromRegistryName("snow").resourceLocation);
		
		System.out.println(Tiles.getTileRegistry().getTileFromRegistryName("water"));
		ChunksGenerator.worldGenTiles[0] = TextureLoader.getTexture(Tiles.getTileRegistry().getTileFromRegistryName("water").resourceLocation);
		ChunksGenerator.worldGenTiles[1] = TextureLoader.getTexture(Tiles.getTileRegistry().getTileFromRegistryName("dirt").resourceLocation);
		ChunksGenerator.worldGenTiles[2] = TextureLoader.getTexture(Tiles.getTileRegistry().getTileFromRegistryName("grass").resourceLocation);
		ChunksGenerator.worldGenTiles[3] = TextureLoader.getTexture(Tiles.getTileRegistry().getTileFromRegistryName("snow").resourceLocation);
		*/
		//System.out.println(ChunksGenerator.worldGenTiles[2].toString());
	}
	
	public void addChunk(Vector2 position) {
		this.addedChunks.put(MathUtilities.combineVector2String(position), new Chunk(position, this.noise));
		System.out.println(MathUtilities.combineVector2String(position));
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
