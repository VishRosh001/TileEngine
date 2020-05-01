package com.vishrosh.tileengine.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Entity {
	
	private int entityID;
	private String unlocalisedName;
	private String localisedName;
	
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	private Vector2 size;
	
	private Sprite entitySprite;
	
	public Entity(String name) {
		this.setUnlocalisedName(name);
		
		this.position = new Vector2(0, 0);
		this.velocity = new Vector2(0, 0);
		this.acceleration = new Vector2(0, 0);
		this.size = new Vector2(16, 16);
		
		this.entitySprite = new Sprite();
		this.entitySprite.setRegion(new Texture("unknown.png"));;
	}
	
	public void setSpriteTexture(Texture t) {
		this.entitySprite.getTexture().dispose();
		this.entitySprite.setRegion(t);
	}
	
	public void setSize(float width, float height) {
		this.size.x = width;
		this.size.y = height;
		this.updatePlayerBounds();
	}
	
	public void setPosition(float x, float y) {
		this.position.x = x;
		this.position.y = y;
		this.updatePlayerBounds();
	}
	
	public Sprite getSprite() {
		return this.entitySprite;
	}
	
	public Vector2 getPosition() {
		return this.position;
	}
	
	public Vector2 getVelocity() {
		return this.velocity;
	}
	
	public Vector2 getAcceleration() {
		return this.acceleration;
	}
	
	public int getEntityID() {
		return this.entityID;
	}
	
	public void setEntityID(int id) {
		this.entityID = id;
	}
	
	public String getUnlocalisedName() {
		return this.unlocalisedName;
	}
	
	public String getLocalisedName() {
		return this.localisedName;
	}
	
	public void setUnlocalisedName(String name) {
		this.unlocalisedName = "entity.seed." + name;
		this.setLocalisedName(this.unlocalisedName);
	}
	
	public void setLocalisedName(String name) {
		this.localisedName = name;
	}
	
	public void entityMovement() {
		this.acceleration.limit(0);
		this.velocity.add(this.acceleration);
		this.position.add(this.velocity);
		this.velocity.limit(0);
	}
	
	public void updatePlayerBounds() {
		this.entitySprite.setBounds(this.position.x, this.position.y, this.size.x, this.size.y);
	}
	
	public void destoryEntity() {
		this.entitySprite.getTexture().dispose();
	}
}