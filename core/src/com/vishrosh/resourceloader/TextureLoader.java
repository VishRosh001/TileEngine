package com.vishrosh.resourceloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.google.gson.Gson;

import com.vishrosh.registry.core.Registries;
import com.vishrosh.resourceloader.texturepacker.TexturePacker;

public class TextureLoader {
	Gson gson = new Gson();
	BufferedReader bufferedReader;
	FileReader fileReader;
	
	static TextureAtlas atlas;
	
	static HashMap<String, Texture> textureMap;
	
	public TextureLoader() {
		new File("resources/temp").mkdir();
		new File("resources/temp/textures").mkdir();
		new File("resources/temp/textures/atlas").mkdir();
		
		TextureLoader.textureMap = new HashMap<String, Texture>();
	}
	
	public void closeFiles() {
		try {
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadTextureAtlas() {
		 atlas = new TextureAtlas("resources/temp/textures/atlas/tiles.atlas");
	}
	
	public static Sprite getSprite(String registryName) {
	//	if(TextureLoader.textureMap.containsKey(registryName))return TextureLoader.textureMap.get(registryName)
		
		if(TextureLoader.atlas == null)TextureLoader.loadTextureAtlas();
		
		Sprite sprite = TextureLoader.atlas.createSprite(registryName);
		
		//Texture texture;
		
		if(sprite == null)sprite = new Sprite(new Texture("resources/textures/tiles/unknown.png"));
		//else texture = sprite.getTexture();
		
		//TextureLoader.textureMap.put(registryName, texture);
		return sprite;
	}
	
	public static Sprite getSprite(ResourceLocation resourceLocation) {
		return TextureLoader.getSprite(resourceLocation.getRegistryName());
	}
	
	public void createTextureAtlas() {
		ResourceLocation[] registryNames = Registries.getRegistries().TILES.getRegistry().getRegistryNames();
		List<File> filesToMove = new ArrayList<>();
		
		for(ResourceLocation r : registryNames) {
			String filePath = "resources/models/tiles/" + r.getRegistryName() + ".json";
			File file = new File(filePath);
			
			if(!file.exists())continue;
			
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				ObjectJson obj = gson.fromJson(bufferedReader, ObjectJson.class);
				
				if(obj == null) {
					closeFiles();
					continue;
				}
				System.out.println("Parent: " + obj.getParent() + " Path: " + obj.getTexturePath());
					
				file = new File("resources/textures/" + obj.getTexturePath() + ".png");
				
				if(file.exists()) {
					filesToMove.add(file);
				}
				closeFiles();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
				closeFiles();
			}
		}
		
		copyAndMoveFiles(filesToMove);
		
		TexturePacker.process("resources/temp/textures", "resources/temp/textures/atlas", "tiles");
		
		deleteUsedFiles(filesToMove);
		filesToMove = null;
	}
	
	public void deleteUsedFiles(List<File> files) {
		for(File file : files) {
			if(file.exists())file.delete();
		}
	}
	
	public void copyAndMoveFiles(List<File> files) {
		if(files.isEmpty())return;
		
		int i = 0;
		for(File file : files) {
			try {
				File tempFile = new File("resources/temp/textures/"+file.getName());
				
				Files.copy(file.toPath(), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				files.set(i, tempFile);
				++i;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void disposeAtlas() {
		if(atlas != null)atlas.dispose();
	}
	
}
