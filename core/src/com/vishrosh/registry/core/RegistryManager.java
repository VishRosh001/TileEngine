package com.vishrosh.registry.core;

import java.util.Optional;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import com.vishrosh.tileengine.tile.Tile;
import com.vishrosh.resourceloader.ResourceLocation;
import com.vishrosh.tileengine.item.Item;

public class RegistryManager {
	
	static BiMap<ResourceLocation, CoreRegistry<? extends ObjectRegistryEntry<?>>> registries = HashBiMap.create();
	
	private RegistryManager() {
		
	}
	
	public static void createRegistries() {
		RegistryManager.createRegistry(new ResourceLocation("tiles"), new CoreRegistry<Tile>(Tile.class));
		RegistryManager.createRegistry(new ResourceLocation("items"), new CoreRegistry<Item>(Item.class));
	}
	
	public static void createRegistry(ResourceLocation resourceLocation, CoreRegistry<? extends ObjectRegistryEntry<?>> clazz) {
		if(RegistryManager.registries == null)return;
		if(RegistryManager.registries.containsKey(resourceLocation))return;
		RegistryManager.registries.put(resourceLocation, clazz);
	}
	
	public static CoreRegistry<? extends ObjectRegistryEntry<?>> getRegistry(ResourceLocation resourceLocation) {
		if(RegistryManager.registries.containsKey(resourceLocation))return RegistryManager.registries.get(resourceLocation);
		return null;
	}
	
	public static CoreRegistry<? extends ObjectRegistryEntry<?>> getRegistry(String resourceLocation) {
		return RegistryManager.getRegistry(new ResourceLocation(resourceLocation));
	}
	
	public static CoreRegistry<? extends ObjectRegistryEntry<?>> getRegistry(Class<? extends ObjectRegistryEntry<?>> clazz){
		Optional<CoreRegistry<? extends ObjectRegistryEntry<?>>> a;
		a = RegistryManager.registries.values().stream().filter(c -> c.getSuperType().getName().equals(clazz.getName())).findFirst();
		
		if(a.isPresent())return a.get();
		return null;
	}
}
