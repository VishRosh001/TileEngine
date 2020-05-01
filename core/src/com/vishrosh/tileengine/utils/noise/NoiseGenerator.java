package com.vishrosh.tileengine.utils.noise;

import com.badlogic.gdx.math.MathUtils;

import com.vishrosh.tileengine.utils.maths.MathUtilities;

public class NoiseGenerator {
	
	private int noiseSeed;
	
	private SimplexNoise simplexNoise;
	
	private int lacunarity;
	private float persistence;
	
	
	public NoiseGenerator(){
		this.noiseSeed = 1;
		this.lacunarity = 2;
		this.persistence = 0.5f;
		
		this.simplexNoise = new SimplexNoise(this.lacunarity, this.persistence, this.noiseSeed);
	}
	
	public void setSeed(int seed) {
		this.noiseSeed = seed;
	}
	
	public void setRandomSeed() {
		this.noiseSeed = MathUtils.random(1, Integer.MAX_VALUE);
	}
	
	public void setLacunarity(int lacunarity) {
		if(!(lacunarity <= 0))this.lacunarity = lacunarity;
	}
	
	public void setPersistance(float persistance) {
		if(!((persistance < 0f) || (persistance > 1f)))this.persistence = persistance;
	}
	
	public void generateSimplexNoise() {
		this.simplexNoise = new SimplexNoise(this.lacunarity, this.persistence, this.noiseSeed);
	}
	
	public int getNoiseSeed() {
		return this.noiseSeed;
	}
	
	public double getNoise(int x, int y) {
		return MathUtilities.normalise(this.simplexNoise.getNoise(x, y), -1, 1);
	}
	
	
}
