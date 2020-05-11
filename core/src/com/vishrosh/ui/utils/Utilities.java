package com.vishrosh.ui.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Utilities {
	
	public static float mapYUp2YDown(float y) {
		
		System.out.println(Gdx.graphics.getHeight());
		
		y = Gdx.graphics.getHeight() - y;
		
		return y;
	}
	
	public static Vector2 mapYUp2YDown(Vector2 coords) {
		
		coords.y = Gdx.graphics.getWidth() - coords.y;
		
		return coords;
	}
	
	public static boolean mouseOver() {
		
		
		return false;
	}
	
}
