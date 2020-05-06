package com.vishrosh.registry.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.vishrosh.resourceloader.ResourceLocation;

public class PlainRegistry<T> {
	
	private IntegerMap<T> integerMap;
	private BiMap<ResourceLocation, T> registryObjects;
	
	public PlainRegistry(){
		this.registryObjects = HashBiMap.create(50);
		this.integerMap = new IntegerMap<T>(50);
	}
	
	public ResourceLocation[] getRegistryNames() {
		return (ResourceLocation[]) this.registryObjects.keySet().toArray(new ResourceLocation[this.registryObjects.size()]);
	}
	
	public ArrayList<T> getObjects() {
		ArrayList<T> values = new ArrayList<>(this.registryObjects.size());
		Iterator<T> iterator = this.registryObjects.values().iterator();
		
		while(iterator.hasNext())values.add(iterator.next());
		
		return values;
	}

	public BiMap<ResourceLocation, T> getRegistryObjects() {
		return registryObjects;
	}

	public void register(ResourceLocation resource, T object) {
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		if(this.registryObjects.containsKey(resource)) {
			return;
		}
		this.registryObjects.put(resource, object);
		this.integerMap.register(object);
		lock.unlock();
	}
	
	public ResourceLocation getResourceLocationByName(String registryName) {
		//System.out.println(registryName);
		ResourceLocation r = new ResourceLocation(registryName);
		if(this.registryObjects.containsKey(r)) return r;
		return null;
	}
	
	public T getObjectByRegistryName(String registryName) {
		
		ResourceLocation r = getResourceLocationByName(registryName);
		
		if(r != null) return this.registryObjects.get(r);
		
		return null;
	}

	public IntegerMap<T> getIntegerMap() {
		return integerMap;
	}
	
}
