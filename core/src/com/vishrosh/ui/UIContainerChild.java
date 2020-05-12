package com.vishrosh.ui;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.GridPoint2;
import com.vishrosh.resourceloader.ResourceLocation;

public abstract class UIContainerChild {
	
	private ResourceLocation name;
	
	private GridPoint2 position;
	private GridPoint2 size;
	private Sprite texture;
	
	private boolean hascustomRender;
	
	public UIContainerChild(String registryName) {
		this.name = new ResourceLocation(registryName);
		this.position = new GridPoint2(0, 0);
		this.size = new GridPoint2(0, 0);
		this.hascustomRender = false;
		this.texture = null;
	}
	
	public abstract void load();
	public abstract void update();
	public abstract void render();
	
	public void setPosition(int x, int y) {
		this.position.set(x, y);
	}
	
	public GridPoint2 getPosition() {
		return this.position;
	}
	
	public void setSize(int width, int height) {
		this.size.set(width, height);
	}
	
	public GridPoint2 getSize() {
		return this.size;
	}
	
	public void setTexture(Sprite texture) {
		this.texture = texture;
	}
	
	public Sprite getTexture() {
		return this.texture;
	}
	
	public ResourceLocation getRegistryName() {
		return this.name;
	}
	
	public void setHasCustomRender(boolean customRender) {
		this.hascustomRender = customRender;
	}
	
	public boolean getHasCustomRender() {
		return this.hascustomRender;
	}
	
}
