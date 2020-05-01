package com.vishrosh.tileengine.world;

import com.vishrosh.tileengine.utils.noise.NoiseGenerator;

public class MapNoiseInitialiser {
	public NoiseGenerator simplexNoise;
	
	public MapNoiseInitialiser() {
		this.simplexNoise = new NoiseGenerator();
		this.simplexNoise.setSeed(5);
		this.simplexNoise.setLacunarity(400);
		this.simplexNoise.setPersistance(0.8f);
		this.simplexNoise.generateSimplexNoise();
	}
	
	public void setMapSeed(int seed) {
		this.simplexNoise.setSeed(seed);
	}
	
	public int getMapSeed() {
		return this.simplexNoise.getNoiseSeed();
	}
}
