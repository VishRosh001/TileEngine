package com.vishrosh.ui;

import com.badlogic.gdx.math.GridPoint2;
import com.vishrosh.font.FontRenderer;
import com.vishrosh.ui.utils.UIContainerUtils;

public class Label extends UIContainerChild{
	
	private static FontRenderer renderer;
	private String labelText;
	
	public void setLabelText(String text) {
		this.labelText = text;
	}
	
	public static void setFontRenderer(FontRenderer renderer) {
		Label.renderer = renderer;
	}
	
	public Label(String registryName) {
		super(registryName);
	}

	@Override
	public void load() {
		this.setPosition(10, 20);
		this.setSize(50, 10);
		this.setHasCustomRender(true);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render() {
		GridPoint2 pos = UIContainerUtils.toWorldSpace(this.getPosition(), this.getParent().containerRect);
		System.out.println("Label Pos: " + pos);
		Label.renderer.renderText(this.labelText, pos.x, pos.y);
	}

}
