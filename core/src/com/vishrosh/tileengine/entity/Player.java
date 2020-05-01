package com.vishrosh.tileengine.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Entity{
	
	public Player() {
		super("player");
		
		this.setSpriteTexture(new Texture("player.png"));
		this.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
	}
	
	public void playerMovement() {
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			this.getAcceleration().y = 0.05f;
			System.out.println("moved player");
		}else if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			this.getAcceleration().x = -0.05f;
		}else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			this.getAcceleration().y = -0.05f;
		}else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			this.getAcceleration().x = 0.05f;
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
