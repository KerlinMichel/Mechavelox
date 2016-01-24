package com.kerlinmichel.mechvelox;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Screens scr;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		scr = new Screens();
		scr.show();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.65f, 0.47f, 0.337f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		scr.render(Gdx.graphics.getDeltaTime());
		batch.end();
	}
}
