package com.vishrosh.resourceloader;

import java.util.Objects;

public class ResourceLocation {
	
	String simpleRegistryName;
	String pathRegistryName;

	public ResourceLocation(String registryName) {
		this.simpleRegistryName = registryName;
		
	}
	
	public String getTexturePath() {
		return "textures/this." + simpleRegistryName + ".png";
	}
	
	public String getRegistryName() {
		return this.simpleRegistryName;
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
