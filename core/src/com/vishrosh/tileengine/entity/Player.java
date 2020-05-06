package com.vishrosh.tileengine.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends Entity{
	
	public Player() {
		super();
		this.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
	}
	
	public void playerMovement(float deltaTime) {
		float speed = 5.0f;
		
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			this.getAcceleration().y = speed*deltaTime;
		}else if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			this.getAcceleration().x = -speed*deltaTime;
		}else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			this.getAcceleration().y = -speed*deltaTime;
		}else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			this.getAcceleration().x = speed*deltaTime;
		}else{
			this.getAcceleration().set(0, 0);
			this.getVelocity().set(0, 0);
		}
		
		playerMover();
	}
	
	public void playerMover() {
		this.getAcceleration().limit(0.1f);
		this.getVelocity().add(this.getAcceleration());
		this.getPosition().add(this.getVelocity());
		this.getVelocity().limit(1f);
		this.updatePlayerBounds();
	}
	
	
	
}
