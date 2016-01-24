package com.kerlinmichel.mechvelox;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Player extends Actor {
	
	float delta;
	boolean draw2ndFrame;
	boolean isShooting;
	
	ArrayList<Missile> missiles;
	
	public Rectangle c_box;
	
	public Player() {
		setWidth(Resources.playerHover1.getWidth());
		setHeight(Resources.playerHover1.getHeight());
		
		missiles = new ArrayList<Missile>();
		
		c_box = new Rectangle();
	}
	
	@Override
	public void act(float delta) {
		this.delta += delta;
		if(this.delta > 0.07f) {
			this.delta = 0;
			draw2ndFrame = !draw2ndFrame;
			isShooting = false;
		}
		
		for(int i = 0; i < missiles.size(); i++) {
			if(missiles.get(i).dead) {
				missiles.get(i).remove();
				missiles.remove(i);
			}
		}
		
		c_box.x = getX() + 12;
		c_box.y = getY() + 11;
		c_box.width = 35;
		c_box.height = 46;
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(new TextureRegion(Resources.red), getX() + 32, getY() + 50, 0, 0, 
				1400, 2, 1, 1, Input.angle);
		if(draw2ndFrame)
			batch.draw(Resources.playerHover2, getX(), getY());
		else {
			if(isShooting)
				batch.draw(Resources.playerShoot, getX(), getY());
			else
				batch.draw(Resources.playerHover1, getX(), getY());
		}
	}
	
	public void spawnMissile(Stage stage) {
		Missile missile = new Missile(getX() + 21, getY() - 16, Input.angle);
		Missile missile2 = new Missile(getX() + 43, getY()- 16, Input.angle);
		missiles.add(missile);
		missiles.add(missile2);
		stage.addActor(missile);
		stage.addActor(missile2);
		
	}
	
	public ArrayList<Missile> getMissiles() {
		return missiles;
	}
}
