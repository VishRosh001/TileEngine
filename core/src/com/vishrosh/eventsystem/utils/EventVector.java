package com.vishrosh.eventsystem.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Optional;

public class EventVector {
	
	int classID;
	ArrayList<Method> methods;
	
	public EventVector(int classID){
		this.classID = classID;
		this.methods = new ArrayList<>(5);
	}
	
	public int getClassID() {
		return this.classID;
	}
	
	public ArrayList<Method> getMethodList(){
		return this.methods;
	}
	
	public void addMethod(Method method) {
		this.methods.add(method);
	}
	
	public void removeMethod(Method m) {
		this.methods.remove(m);
	}
	
	public boolean doesMethodExist(Method m) {
		Optional<Method> a = this.methods.stream().filter((sub) -> sub == m).findFirst();
		return a.isPresent() ? true : false;
	}
	
	
}
