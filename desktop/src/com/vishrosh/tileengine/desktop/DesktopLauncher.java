package com.vishrosh.tileengine.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.vishrosh.tileengine.TileEngine;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.vSyncEnabled = false;
		config.foregroundFPS = 0;
		config.backgroundFPS = 0;
		config.width = TileEngine.SIZE.x;
		config.height = TileEngine.SIZE.y;
		new LwjglApplication(new TileEngine(), config);
	}
}
