package com.vishrosh.tileengine.utils.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class OrthoCamera {
	
	private OrthographicCamera camera;
	
	Vector2 cameraSize;
	Vector3 cameraTarget;
	
	public OrthoCamera(int width, int height) {
		this.cameraSize = new Vector2(width, height);
		this.cameraTarget = new Vector3(0, 0, 0);
		camera = new OrthographicCamera(this.cameraSize.x, this.cameraSize.y);
		this.configureCamera();
	}
	
	public void configureCamera() {
		this.configureCameraSize();
		this.configureCameraTarget();
	}
	
	public OrthographicCamera getCamera() {
		return this.camera;
	}
	
	public void setCameraTarget(float x, float y) {
		this.cameraTarget.x = x;
		this.cameraTarget.y = y;
		this.configureCameraTarget();
	}
	
	private void configureCameraTarget() {
		this.camera.position.set(this.cameraTarget.x, this.cameraTarget.y, 0);
		this.camera.update();
	}
	
	public void setCameraSize(float width, float height) {
		this.cameraSize.x = width;
		this.cameraSize.y = height;
		this.configureCameraSize();
	}
	
	private void configureCameraSize() {
		/*if(this.cameraSize.y < this.cameraSize.x) {
			this.camera.setToOrtho(false, this.cameraSize.x, this.cameraSize.x*(Gdx.graphics.getHeight()/Gdx.graphics.getWidth()));
		}else {
			this.camera.setToOrtho(false, this.cameraSize.y*(Gdx.graphics.getWidth()/Gdx.graphics.getHeight()), this.cameraSize.y);
		}*/
		this.camera.setToOrtho(false, this.cameraSize.x, this.cameraSize.y);
		this.camera.update();
	}
	
	
	
}
