package com.vishrosh.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vishrosh.tileengine.TileEngine;
import com.vishrosh.ui.utils.Utilities;

public class Button extends UIContainerChild{
	
	public Button(String registryName) {
		super(registryName);
	}
	
	@Override
	public void load() {
		this.setPosition(100, 20);
		this.setSize(50, 10);
		this.setTexture(new Sprite(new Texture("resources/textures/tiles/water.png")));
		this.setHasCustomRender(false);
	}

	@Override
	public void update() {
		this.isMousePressedOn();
	}

	@Override
	public void render() {
		TileEngine.batch.draw(this.getTexture(), this.getPosition().x, this.getPosition().y, this.getSize().x, this.getSize().y);
	}

	public boolean isMouseOver() {
		if(Gdx.input.getX() >= this.getPosition().x && Gdx.input.getX() <= this.getPosition().x+ this.getSize().x) {
			float newY = Utilities.mapYUp2YDown(this.getPosition().y);
			if(Gdx.input.getY() <= newY && Gdx.input.getY() >= newY-this.getSize().y) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isMousePressedOn() {
		if(isMouseOver()) {
			if(Gdx.input.isButtonPressed(0)) {
				System.out.println("Button Pressed!");
			}
		}
		return false;
	}

}
