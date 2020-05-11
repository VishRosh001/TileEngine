package com.vishrosh.font;

import com.badlogic.gdx.math.Vector2;
import com.google.gson.annotations.SerializedName;

public class Character {
	
	@SerializedName("representation")
	private char character;
	@SerializedName("offset")
	private Vector2 offset;
	@SerializedName("size")
	private Vector2 size;
	
	public Character(char character, Vector2 offset, Vector2 size) {
		this.character = character;
		this.offset = offset;
		this.size = size;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public Vector2 getOffset() {
		return offset;
	}

	public void setOffset(Vector2 offset) {
		this.offset = offset;
	}

	public Vector2 getSize() {
		return size;
	}

	public void setSize(Vector2 size) {
		this.size = size;
	}
}
