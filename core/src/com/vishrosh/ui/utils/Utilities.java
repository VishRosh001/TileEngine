package com.vishrosh.ui.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.GridPoint2;
import com.vishrosh.tileengine.TileEngine;

public class Utilities {
	
	public static GridPoint2 convertY2Down(GridPoint2 coords) {
		GridPoint2 temp = new GridPoint2(coords);
		temp.y = TileEngine.SIZE.y - coords.y;
		return temp;
	}
	
	public static GridPoint2 getMousePos() {
		GridPoint2 temp = new GridPoint2();
		temp.x = Gdx.input.getX();
		temp.y = Gdx.input.getY();
		return temp;
	}
	
	public static GridPoint2 mousePosAsYDown() {
		return Utilities.convertY2Down(getMousePos());
	}
	
	public static boolean mouseOver() {
		
		
		return false;
	}
	
}
