package com.vishrosh.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vishrosh.tileengine.TileEngine;

public class Button extends UIContainerChild{
	
	public Button(String registryName) {
		super(registryName);
	}
	
	@Override
	public void load() {
		this.setPosition(10, 20);
		this.setSize(50, 10);
		this.setTexture(new Sprite(new Texture("resources/textures/tiles/water.png")));
		this.setHasCustomRender(false);
	}

	@Override
	public void update() {
		this.isLeftButtonClickedOn();
	}

	@Override
	public void render() {
		TileEngine.batch.draw(this.getTexture(), this.getPosition().x, this.getPosition().y, this.getSize().x, this.getSize().y);
	}
	
	

}
