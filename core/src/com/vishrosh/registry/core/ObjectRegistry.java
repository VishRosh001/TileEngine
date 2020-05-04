package com.vishrosh.registry.core;

import com.vishrosh.logger.core.Logger;
import com.vishrosh.registry.core.IObjectEntry;

public class ObjectRegistry<T extends IObjectEntry<T>> implements IObjectRegistry<T>{
	
	private PlainRegistry<T> REGISTRY = new PlainRegistry<T>();

	@Override
	public void register(T object) {
		if(object.getRegistryName() == null) {
			Logger.getLogger(this.getClass()).logMinor("Object Registry", "Registry name has not been set for " + object);
			return;
		}
		this.REGISTRY.register(object.getRegistryName(), object);
	}
	
	@Override
	public T getObjectByRegistryName(String registryName) {
		System.out.println("regi");
		return this.REGISTRY.getObjectByRegistryName(registryName);
	}
	
	@Override
	public PlainRegistry<T> getRegistry(){
		return this.REGISTRY;
	}
	
}
