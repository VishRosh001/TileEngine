package com.vishrosh.tileengine.utils.maths;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;

public class MathUtilities {
	
	public static double normalise(double value, int max, int min) {
		return (value - min) / (max - min);
	}
	
	public static Vector2 map1DIndexTo2DIndex(int value, int vectorWidth) {
		int i = value % vectorWidth;
	    return new Vector2(i, (value - i) / vectorWidth);
	}
	
	public static Vector2 map1DIndexTo2DIndex(float value, float vectorWidth) {
		int i = (int)value % (int)vectorWidth;
	    return new Vector2(i, (value - i) / vectorWidth);
	}
	
	public static String gridPoint2String(GridPoint2 g) {
		return Integer.toHexString(g.x) + "|" + Integer.toHexString(g.y);
	}
	
	public static double scaleNumToXY(double value, int max, int min, int minScale, int maxScale ) {
		double a = maxScale - minScale;
		double b = (value - min) / (max - min);
		return (a*b)+minScale;
	}
	
	public static GridPoint2 vec2Grid2(Vector2 v) {
		return new GridPoint2((int)v.x, (int)v.y);
	}
	
}
