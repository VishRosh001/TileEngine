package com.vishrosh.tileengine.gameobjects;

import com.vishrosh.registry.core.ObjectRegistryEntry;

public abstract class GameObject<T> extends ObjectRegistryEntry<T>{
	
	private String unlocalisedName;
	private String localisedName;
	
	public GameObject() {
		//this.setUnlocalisedName(this.getRegistryName().getRegistryName());
	}
	
	public String getUnlocalisedName() {
		return this.unlocalisedName;
	}
	
	public String getLocalisedName() {
		return this.localisedName;
	}
	
	public void setUnlocalisedName(String name) {
		this.unlocalisedName = "tile.seed." + name;
		this.setLocalisedName(this.unlocalisedName);
	}
	
	public void setLocalisedName(String name) {
		this.localisedName = name;
	}
	
}
