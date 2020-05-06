package com.vishrosh.registry.core;

import com.vishrosh.resourceloader.ResourceLocation;

public interface IObjectEntry<T> {
	
	public T setRegistryName(ResourceLocation resourceLocation);
	
	public ResourceLocation getRegistryName();

	T setRegistryName(String name);
}
