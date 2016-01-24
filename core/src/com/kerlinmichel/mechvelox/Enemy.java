package com.kerlinmichel.mechvelox;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Enemy extends Actor {
	
	float delta;
	int frame = 1;
	boolean inc;
	
	Texture texture;
	
	public Rectangle c_box;
	
	boolean flying;
	
	public boolean dead;
	
	public Enemy() {
		Random r = new Random();
		flying = r.nextBoolean();
		setX(1300);
		setY(100);
			if(flying)
				setY(475 + 200*r.nextFloat());
		setWidth(Resources.en1.getWidth());
		setHeight(Resources.en1.getHeight());
		setScale(3);
		c_box = new Rectangle();
	}
	
	@Override
	public void act(float delta) {
		this.delta += delta;
		if(this.delta > 0.1f) {
			this.delta = 0;
			if(frame == 4) {
				frame = 1;
			} else {
				frame++;
			}
			setX(getX() - 6);
		}
		
		c_box.x = getX();
		c_box.y = getY();
		c_box.width = getWidth()*3;
		c_box.height = getHeight()*3;
	}
	
	public void update() {
		c_box.x = getX();
		c_box.y = getY();
		c_box.width = getWidth()*3;
		c_box.height = getHeight()*3;
	}
	
	@Override 
	public void draw(Batch batch, float parentAlpha) {
		if(!flying) {
			switch(frame) {
				case 1 : texture = Resources.en1; break;
				case 2 : texture = Resources.en2; break;
				case 3 : texture = Resources.en3; break;
				case 4 : texture = Resources.en4; break;
			}
		} else {
			switch(frame) {
			case 1 : texture = Resources.fl1; break;
			case 2 : texture = Resources.fl2; break;
			case 3 : texture = Resources.fl3; break;
			case 4 : texture = Resources.fl4; break;
			}
		}
		
		batch.draw(texture, getX(), getY(), getWidth()*getScaleX(), getHeight()*getScaleY());
	}

}
