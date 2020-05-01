package com.vishrosh.tileengine.utils.maths;

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
	
	public static String combineVector2String(Vector2 v) {
		return ""+v.x+"/"+v.y;
	}
	
}
