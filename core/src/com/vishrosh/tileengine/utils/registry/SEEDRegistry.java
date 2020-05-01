package com.vishrosh.tileengine.utils.registry;

public interface SEEDRegistry<T> {
	
	public void register(T object);
	@SuppressWarnings("unchecked")
	public void registerAll(T ...object);
	public SEEDRegistry<T> getReigstry();
	
}
