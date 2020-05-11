package com.vishrosh.font;

import java.io.File;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.vishrosh.resourceloader.FontLoader;

public class FontRenderer {
	
	private FontLoader fontLoader = null;
	private SpriteBatch batch = null;
	
	public FontRenderer() {
		this(new File("resources/fonts/Standard.json"));
	}
	
	public FontRenderer(SpriteBatch batch) {
		this(new File("resources/fonts/Standard.json"), batch);
	}
	
	public FontRenderer(File file) {
		this(file, null);
	}
	
	public FontRenderer(File file, SpriteBatch batch) {
		if(this.getFontLoader() == null)this.setFontLoader(new FontLoader());
		this.setSpriteBatch(batch);
		this.getFontLoader().loadFontSpriteSheet(file);
	}
	
	public void setFontLoader(FontLoader fontLoader) {
		this.fontLoader = fontLoader;
	}
	
	public FontLoader getFontLoader() {
		return this.fontLoader;
	}
	
	public void setSpriteBatch(SpriteBatch batch) {
		this.batch = batch;
	}
	
	public SpriteBatch getSpriteBatch() {
		return this.batch;
	}
	
	public void renderText(String text, int x, int y) {
		this.getSpriteBatch().begin();
		
		int Xoffset = x;
		for(char c : text.toCharArray()) {
			if(c == ' ') {Xoffset+= 10;continue;}
			
			TextureRegion fontTexture = this.getFontLoader().getCharacter(c);
			this.getSpriteBatch().draw(fontTexture, Xoffset, y);
			Xoffset += fontTexture.getRegionWidth()+2;
		}
		this.getSpriteBatch().end();
		
	}
	
}
