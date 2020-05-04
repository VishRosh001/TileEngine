package com.vishrosh.registry.core;

import java.util.Objects;

public class ResourceLocation {
		
	String registryName;

	public ResourceLocation(String registryName) {
		//this.registryName = registryName;
		this.registryName = registryName;
		
	}
	
	public String getTexturePath() {
		//this.setTexture();
		return this.registryName + ".png";
	}
	
	public String getRegistryName() {
		return this.registryName;
	}
	
	@Override
	public boolean equals(Object resourceLocation) {
		if(resourceLocation == null || resourceLocation.getClass() != this.getClass())return false;
		if(resourceLocation == this)return true;
		
		if(this.getRegistryName() == ((ResourceLocation) resourceLocation).getRegistryName())return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return hash();
		
	}
	
	public int hash() {
		return Objects.hash(this.getRegistryName());
	}
	
	

}
