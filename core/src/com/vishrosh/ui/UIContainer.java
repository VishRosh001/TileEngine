package com.vishrosh.ui;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.badlogic.gdx.math.GridPoint2;
import com.vishrosh.statemachine.core.State;
import com.vishrosh.tileengine.TileEngine;
import com.vishrosh.ui.utils.UIContainerUtils;

public class UIContainer {
	Rectangle containerRect;
	State uiState;
	ArrayList<UIContainerChild> children;
	
	public UIContainer(State state, Rectangle containerRect) {
		this.containerRect = containerRect;
		this.uiState = state;	
		this.children = new ArrayList<>(5);
	}
	
	public void load() {
		for(UIContainerChild c : this.children) {
			c.load();
		}
	}
	
	public void render() {
		TileEngine.batch.begin();
		for(UIContainerChild c : this.children) {
			if(c.getTexture() == null)continue;
			if(c.getHasCustomRender()) {
				c.render();
			}else {
				GridPoint2 pos = UIContainerUtils.mapScreenPosToUIPos(this.containerRect, c.getPosition());
				TileEngine.batch.draw(c.getTexture(), pos.x, pos.y, c.getSize().x, c.getSize().y);
			}
			c.update();
		}
		TileEngine.batch.end();
	}
	
	public void addToContainer(UIContainerChild child) {
		for(UIContainerChild c : this.children) {
			if(c.getRegistryName().equals(child.getRegistryName()))return;
		}
		this.children.add(child);
	}
}
