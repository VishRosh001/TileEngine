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
}
