package com.vishrosh.resourceloader;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

public class TextureLoader {
	
	static HashMap<String, Texture> textures = new HashMap<String, Texture>(5);
	
	public static void loadTexture(ResourceLocation resourceLocation) {
		TextureLoader.textures.put(resourceLocation.getRegistryName(), new Texture(resourceLocation.getTexturePath()));
	}
	
	public static Texture getTexture(ResourceLocation resourceLocation) {
		if(TextureLoader.textures.containsKey(resourceLocation.getRegistryName()))return TextureLoader.textures.get(resourceLocation.getRegistryName());
		return null;
	}
	
}
