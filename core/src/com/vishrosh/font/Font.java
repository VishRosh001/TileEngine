package com.vishrosh.font;

import com.badlogic.gdx.math.Vector2;

public class Font {
	public String fontType;
	public String spritePath;
	public Vector2 size;
	public Character[] characters; 
	
	
	public Font(String fontType, String spriteBatch, Vector2 size, Character[] characters) {
		this.fontType = fontType;
		this.spritePath = spriteBatch;
		this.size = size;
		this.characters = characters;
	}
	
}
