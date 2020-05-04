package com.vishrosh.registry.core;

public class CoreRegistry<T extends ObjectRegistryEntry<T>> extends ObjectRegistry<T>{
	
	private Class<T> superType;
	
	public CoreRegistry(Class<T> superType) {
		this.setSuperType(superType);
	}

	public Class<T> getSuperType() {
		return superType;
	}

	public void setSuperType(Class<T> superType) {
		this.superType = superType;
	}
}
