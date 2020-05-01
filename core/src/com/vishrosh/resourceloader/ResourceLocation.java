package com.vishrosh.resourceloader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ResourceLocation {
	
	String registryName;
	
	Sprite texture;
	boolean isTextureAnimated;
	
	String textureLocation;
	
	public ResourceLocation(String registryName) {
		this.registryName = registryName;
		this.texture = null;
		this.textureLocation = this.registryName + ".png";
	}
	
	public Sprite getTexture() {
		this.setTexture();
		return this.texture;
	}
	
	public void setTexture() {
		this.destroyTexture();
		
		if(Gdx.files.internal(this.textureLocation).exists()) {
			this.texture = new Sprite(new Texture(Gdx.files.internal(this.textureLocation)));
		}else {
			this.texture = new Sprite(new Texture(Gdx.files.internal("unknown.png")));
		}
	}
	
	public String getRegistryName() {
		return this.registryName;
	}
	
	public void destroyTexture() {
		if(this.texture != null) this.texture.getTexture().dispose();
	}
	
	public void setIsTextureAnimated(boolean isAnimated) {
		
	}
	
	
}
