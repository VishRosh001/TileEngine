package com.vishrosh.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.vishrosh.statemachine.core.State;
import com.vishrosh.ui.utils.Utilities;

public class Button {
	
	Vector3 position;
	Vector2 size;
	Sprite sprite;
	State state;
	
	
	public Button(State state, int x, int y) {
		this.position = new Vector3(x, y, 0);
		this.size = new Vector2(150, 25);
		this.sprite = new Sprite(new Texture("resources/textures/tiles/water.png"));
		this.state = state;
	}
	
	public void render(SpriteBatch batch) {
		batch.begin();
		batch.draw(this.sprite, this.position.x, this.position.y, this.size.x, this.size.y);
		batch.end();
		this.update();
	}
	
	public boolean isMouseOver() {
		if(Gdx.input.getX() >= this.position.x && Gdx.input.getX() <= this.position.x + this.size.x) {
			float newY = Utilities.mapYUp2YDown(this.position.y);
			if(Gdx.input.getY() <= newY && Gdx.input.getY() >= newY-this.size.y) {
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
	
	public void update() {
		isMousePressedOn();
	}
	
}
