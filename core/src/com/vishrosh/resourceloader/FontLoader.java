package com.vishrosh.resourceloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.google.gson.Gson;
import com.vishrosh.font.Font;

public class FontLoader {
	Texture fontSpriteSheet;
	Font fontObj;
	
	public void loadFontSpriteSheet(File fontJsonFile) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fontJsonFile);
			bufferedReader = new BufferedReader(fileReader);
			fontObj = new Gson().fromJson(bufferedReader, Font.class);
			
			FileHandle fileHandle = new FileHandle(new File("resources/fonts/" + fontObj.spritePath + ".png"));
			
			this.fontSpriteSheet = new Texture(fileHandle);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Font getFontObject() {
		return this.fontObj;
	}
	
	public com.vishrosh.font.Character[] getCharacterArray() {
		return this.getFontObject().characters;
	}
	
	public TextureRegion getCharacter(char rep) {
		com.vishrosh.font.Character charObj = null;
		com.vishrosh.font.Character[] characterArray = this.getCharacterArray();
		Vector2 charOffset, charSize;
		
		for(com.vishrosh.font.Character c : characterArray) {
			if(c.getCharacter() == rep) {charObj = c;break;}
		}
		
		if(charObj == null) {
			charOffset = characterArray[0].getOffset();
			charSize = characterArray[0].getSize();
		}else {
			charOffset = charObj.getOffset();
			charSize = charObj.getSize();
		}
		
		return new TextureRegion(this.fontSpriteSheet, (int)charOffset.x, (int)charOffset.y, (int)charSize.x, (int)charSize.y);
	}
	
}
