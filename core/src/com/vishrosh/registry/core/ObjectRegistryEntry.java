package com.vishrosh.registry.core;

import com.vishrosh.registry.core.IObjectEntry;
import com.vishrosh.resourceloader.ResourceLocation;

public class ObjectRegistryEntry<T> implements IObjectEntry<T>{
	
	private ResourceLocation registryName;
	
	@SuppressWarnings("unchecked")
	@Override
	public T setRegistryName(ResourceLocation resourceLocation) {
		this.registryName = resourceLocation;
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T setRegistryName(String name) {
		this.registryName = new ResourceLocation(name);
		return (T)this;
	}

	@Override
	public ResourceLocation getRegistryName() {
		return this.registryName == null ? null : this.registryName;
	}

}
