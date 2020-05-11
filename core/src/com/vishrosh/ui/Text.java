package com.vishrosh.ui;

import com.vishrosh.font.FontRenderer;

public class Text {
	
	private static FontRenderer renderer;
	
	public static void setRenderer(FontRenderer renderer) {
		Text.renderer = renderer;
	}
	
	public static void renderText(String text, int x, int y) {
		Text.renderer.renderText(text, x, y);
	}
	
	
	
}
