package com.vishrosh.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Test extends UIContainerChild{

	public Test(String registryName) {
		super(registryName);
		
	}

	@Override
	public void load() {
		this.setPosition(-100, 0);
		this.setSize(100, 100);
		this.setTexture(new Sprite(new Texture("resources/textures/tiles/dirt.png")));
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render() {
		
	}

}
