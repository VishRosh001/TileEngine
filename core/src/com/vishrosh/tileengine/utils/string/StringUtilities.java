package com.vishrosh.tileengine.utils.string;

import com.badlogic.gdx.math.Vector2;

public class StringUtilities {
	public static Vector2 stringToVector2(String s) {
		Vector2 v = new Vector2(0, 0);
		String[] ss = s.split("[/]");
		v.x = Float.parseFloat(ss[0]);
		v.y = Float.parseFloat(ss[1]);
		
		return v;
	}
}
