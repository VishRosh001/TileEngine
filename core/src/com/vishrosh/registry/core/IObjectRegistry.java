package com.vishrosh.registry.core;

import com.vishrosh.registry.core.IObjectEntry;

public interface IObjectRegistry<T extends IObjectEntry<T>>{
	
	public void register(T object);
	public T getObjectByRegistryName(String registryName);
	public PlainRegistry<T> getRegistry();
}
