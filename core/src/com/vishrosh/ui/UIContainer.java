package com.vishrosh.ui;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.badlogic.gdx.math.GridPoint2;
import com.vishrosh.resourceloader.ResourceLocation;
import com.vishrosh.statemachine.core.State;
import com.vishrosh.tileengine.TileEngine;
import com.vishrosh.ui.utils.UIContainerUtils;

public class UIContainer {
	ResourceLocation registryName;
	
	Rectangle containerRect;
	com.badlogic.gdx.math.Rectangle r = new com.badlogic.gdx.math.Rectangle(0, 0, 10, 10);
	State uiState;
	ArrayList<UIContainerChild> children;
	
	public UIContainer(String registryName, State state, Rectangle containerRect) {
		this.registryName = new ResourceLocation(registryName);
		this.containerRect = containerRect;
		this.uiState = state;	
		this.children = new ArrayList<>(5);
	}
	
	public void load() {
		for(UIContainerChild c : this.children) {
			c.load();
		}
	}
	
	public void setChildResourceLocation(ResourceLocation childResource) {
		if(childResource.getRegistryName().split("[:]").length > 1) return;
		childResource.setRegistryName(this.registryName + ":" + childResource.getRegistryName());
	}
	
	public void render() {
		TileEngine.batch.begin();
		for(UIContainerChild c : this.children) {
			if(c.getHasCustomRender()) {
				c.render();
			}else {
				if(c.getTexture() == null)continue;
				GridPoint2 pos = UIContainerUtils.toWorldSpace(c.getPosition(), this.containerRect);
				TileEngine.batch.draw(c.getTexture(), pos.x, pos.y, c.getSize().x, c.getSize().y);
			}
			c.update();
		}
		TileEngine.batch.end();
	}
	
	public void addToContainer(UIContainerChild child) {
		this.setChildResourceLocation(child.getRegistryName());
		for(UIContainerChild c : this.children) {
			if(c.getRegistryName().equals(child.getRegistryName()))return;
		}
		child.setParent(this);
		this.children.add(child);
	}
	
	public void destroyChildren() {
		for(UIContainerChild c : this.children) {
			if(c.getTexture() == null)continue;
			c.getTexture().getTexture().dispose();
		}
	}
}
