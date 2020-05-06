package com.vishrosh.resourceloader;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectJson {
	
	@SerializedName("parent")
	@Expose
	private String parent;
	@SerializedName("texture")
	@Expose
	private String texturePath;
	
	public ObjectJson(String parent, String texturePath) {
		this.parent = parent;
		this.texturePath = texturePath;
	}
	
	public String getParent() {
		return this.parent;
	}
	
	public String getTexturePath() {
		return this.texturePath;
	}
	
}
