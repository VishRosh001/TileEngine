package com.vishrosh.ui;

import com.badlogic.gdx.math.Matrix4;

public class UIMatrix {
	
	private static Matrix4 screenMatrix;
	
	public static void setUIMatrix(Matrix4 screenMatrix) {
		UIMatrix.screenMatrix = screenMatrix;
	}
	
	public static Matrix4 getUIMatrix() {
		return UIMatrix.screenMatrix;
	}
	
}
