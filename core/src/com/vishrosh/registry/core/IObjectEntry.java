package com.vishrosh.registry.core;

import com.vishrosh.registry.core.ResourceLocation;

public interface IObjectEntry<T> {
	
	public T setRegistryName(ResourceLocation resourceLocation);
	
	public ResourceLocation getRegistryName();

	T setRegistryName(String name);
}
