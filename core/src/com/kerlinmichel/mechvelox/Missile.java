package com.kerlinmichel.mechvelox;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Missile extends Actor {
	
	float speed; 
	
	Rectangle c_box;
	public boolean explode;
	public boolean dead;
	
	public int frame = 1;
	
	float delta;
	float delay = 0.9f;
	
	Texture texture;
	
	public Missile(float x, float y, float rotation) {
		setPosition(x, y);
		setRotation(rotation);
		speed = 7;
		setWidth(Resources.m1.getWidth());
		setHeight(Resources.m1.getHeight());
		c_box = new Rectangle();
	}
	
	@Override
	public void act(float delta) {
		c_box.x = getX() + 58;
		c_box.y = getY() + 55;
		c_box.width = 30;
		c_box.height = 15;
		setX((float) (getX() + speed*Math.cos(Math.toRadians(getRotation()))));
		setY((float) (getY() + speed*Math.sin(Math.toRadians(getRotation()))));
		
		this.delta += delta;
		if(this.delta > delay) {
			this.delay = 0;
			if(frame < 7) {
				frame++;
				speed++;
			}
			else {
				frame--;
			}
		}
		
		if(speed >= 15)
			speed = 14;
		
		if(!c_box.overlaps(Screens.scrnDim))
			explode = true;
	}
	
	public void update() {
		c_box.x = getX() + 58;
		c_box.y = getY() + 55;
		c_box.width = 30;
		c_box.height = 20;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		if(!explode)
			switch(frame) {
				case 1 : texture = Resources.m1; break;
				case 2 : texture = Resources.m2;break;
				case 3 : texture = Resources.m3;break;
				case 4 : texture = Resources.m4; Resources.shoot.play();break;
				case 5 : texture = Resources.m5;break;
				case 6 : texture = Resources.m6;break;
				case 7 : texture = Resources.m7;break;
			} else {
				switch(frame) {
					case 1 : texture = Resources.e1; speed = 0; break;
					case 2 : texture = Resources.e2;break;
					case 3 : texture = Resources.e3;break;
					case 4 : texture = Resources.e4;break;
					case 5 : texture = Resources.e5;break;
					case 6 : texture = Resources.e6;break;
					case 7 : texture = Resources.e7; dead = true; break;
				}
			}
		
		batch.draw(new TextureRegion(texture), getX(), getY(), getOriginX(), getOriginY(), 
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}

}
