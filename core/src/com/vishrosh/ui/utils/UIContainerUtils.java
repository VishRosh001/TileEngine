package com.vishrosh.ui.utils;

import java.awt.Rectangle;

import com.badlogic.gdx.math.GridPoint2;
import com.vishrosh.tileengine.TileEngine;
import com.vishrosh.tileengine.utils.maths.MathUtilities;

public class UIContainerUtils {
	public static GridPoint2 mapScreenPosToUIPos(Rectangle containerRect, GridPoint2 pos){
		GridPoint2 temp = new GridPoint2();
		temp.x = (int) MathUtilities.scaleNumToXY(pos.x, TileEngine.SIZE.x, 0, containerRect.x, containerRect.x+containerRect.width);
		temp.y = (int) MathUtilities.scaleNumToXY(pos.y, TileEngine.SIZE.y, 0, containerRect.y, containerRect.y+containerRect.height);
		return temp;
	}
	
	public static GridPoint2 toWorldSpace(GridPoint2 point, Rectangle containerRect) {
		GridPoint2 temp = new GridPoint2(0, 0);
		temp.x = point.x + containerRect.x;
		temp.y = point.y + containerRect.y;
		return temp;
	}
	
	public static GridPoint2 toWorldSpace(int x, int y, Rectangle containerRect) {
		GridPoint2 temp = new GridPoint2(0, 0);
		temp.x = x + containerRect.x;
		temp.y = y + containerRect.y;
		return temp;
	}
	
	public static GridPoint2 toLocalSpace(GridPoint2 point, Rectangle containerRect) {
		GridPoint2 temp = new GridPoint2(0, 0);
		temp.x = (point.x - containerRect.x);
		temp.y = (point.y - containerRect.y);
		return temp;
	}
}
