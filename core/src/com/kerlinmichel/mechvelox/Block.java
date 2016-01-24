package com.kerlinmichel.mechvelox;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Block extends Actor {
	
	int texture;
	float delta;
	boolean remove;
	public Block(float x) {
		Random r = new Random();
		texture = r.nextInt(10);
		
		setWidth(100);
		setHeight(100);
		setY(0);
		setX(x);
	}
	
	/*@Override
	public void act(float delta) {
		this.delta += 0.1;
		if(this.delta > 0.1f) {
			setX(getX()-5);
			this.delta = 0;
		}
	}*/
	
	@Override
	public void draw(Batch batch, float parentAlpha){
		switch(texture){
			case 0 : batch.draw(Resources.floor1, getX(), getY(), getWidth(), getHeight()); break;
			case 1 : batch.draw(Resources.floor2, getX(), getY(), getWidth(), getHeight()); break;
			case 2 : batch.draw(Resources.floor3, getX(), getY(), getWidth(), getHeight()); break;
			case 3 : batch.draw(Resources.floor4, getX(), getY(), getWidth(), getHeight()); break;
			case 4 : batch.draw(Resources.floor5, getX(), getY(), getWidth(), getHeight()); break;
			case 5 : batch.draw(Resources.floor6, getX(), getY(), getWidth(), getHeight()); break;
			case 6 : batch.draw(Resources.floor7, getX(), getY(), getWidth(), getHeight()); break;
			case 7 : batch.draw(Resources.floor8, getX(), getY(), getWidth(), getHeight()); break;
			case 8 : batch.draw(Resources.floor9, getX(), getY(), getWidth(), getHeight()); break;
			case 9 : batch.draw(Resources.floor10, getX(), getY(), getWidth(), getHeight()); break;
		}
	}
	
	public void setRemoving(boolean isRemoving) {
		remove = isRemoving;
	}
	
	public boolean getRemove() {
		return remove;
	}

}
