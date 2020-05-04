package com.vishrosh.registry.core;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class IntegerMap<T>{
	
	public BiMap<Integer, T> integerMap;
	
	public IntegerMap(int expectedSize) {
		this.integerMap = HashBiMap.create(expectedSize);
	}
	
	public void register(T value) {
		if(this.integerMap.containsValue(value))return;
		this.integerMap.put(this.getNextInteger(), value);
	}
	
	public int getNextInteger() {
		return this.integerMap.size();
	}
	
	public int getObjectID(T value) {
		if(this.integerMap.containsValue(value))this.integerMap.inverse().get(value);
		
		return -1;
	}
}
