package com.kerlinmichel.mechvelox;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;

import com.badlogic.gdx.InputProcessor;

public class Input implements InputProcessor{
	
	public static float angle = 0;
	public static String id = "";

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void read(final BufferedReader reader, final DataInputStream data) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						String s = reader.readLine();
						angle = -Float.parseFloat(s);
						id = reader.readLine();
						if(id.equals("f")) {
							Screens.fire = true;
						}
						//angle = -data.readFloat();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}).start();
	}
	
}
