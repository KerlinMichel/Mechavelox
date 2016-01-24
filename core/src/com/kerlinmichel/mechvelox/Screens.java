package com.kerlinmichel.mechvelox;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class Screens implements Screen {
	
	Stage stage;
	Player player;
	Socket socket;
	BufferedReader reader;
	DataInputStream dataIn;
	
	Input input;
	
	ArrayList<Block> blocks;
	
	ArrayList<Enemy> enemies;
	
	float delta;
	float spawnDelta;
	float spawnDelay;
	Random r;
	
	public static boolean fire;
	
	public static Rectangle scrnDim;
	
	Image bg;
	
	int score;
	
	Label sb;
	
	public Screens() {
		try {
			socket = new Socket("172.28.108.102", 7100);
			reader = new BufferedReader(new InputStreamReader(new DataInputStream(socket.getInputStream())));
			//dataIn = new DataInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = new Input();
		input.read(reader, null);
		r = new Random();
		spawnDelay = 4 + 4*r.nextFloat();
		blocks = new ArrayList<Block>();
		
		enemies = new ArrayList<Enemy>();
		
		for(int i = 0; i < 14; i++)
			blocks.add(new Block(i*100));
		player = new Player();
		player.setPosition(100, 100);
		
		scrnDim = new Rectangle(0,0,1280,720);
		LabelStyle style = new LabelStyle();
		style.font = new BitmapFont();
		sb = new Label(Integer.toString(score), style);
		sb.setPosition(25, 50);
		
		bg = new Image(new Texture("m-013-015-bg.jpg"));
		bg.setScale(1.6f);
	}

	@Override
	public void show() {
		stage = new Stage();
		stage.addActor(bg);
		stage.addActor(player);
		for(Block block : blocks)
			stage.addActor(block);
		stage.addActor(sb);
		
		Resources.m.setLooping(true);
		Resources.m.play();
	}

	@Override
	public void render(float delta) {
		stage.act(delta);
		player.setRotation(Input.angle);
		stage.draw();
		sb.setText(Integer.toString(score));
		
		this.delta += 0.1;
		if(this.delta > 0.1f) {
			for(Block block : blocks)
				block.setX(block.getX()-5);
			sb.remove();
			stage.addActor(sb);
			this.delta = 0;
		}
		
		if(fire) {
			player.spawnMissile(stage);
			fire = false;
			player.isShooting = true;
		}
		
		spawnDelta += delta;
		if(spawnDelta > spawnDelay) {
			spawnDelay = 4 + 4*r.nextFloat();
			spawnDelta = 0;
			Enemy enemy = new Enemy();
			stage.addActor(enemy);
			enemies.add(enemy);
		}
		
		for(int i = 0; i < blocks.size(); i++) {
			if(blocks.get(i).getX() < -100) {
				blocks.get(i).remove();
				float x = blocks.get(blocks.size()-1).getX();
				Block block = new Block(x +100);
				blocks.add(block);
				stage.addActor(block);
				blocks.get(i).setRemoving(true);
			}
		}

		for(int i = 0; i < blocks.size(); i++) {
			if(blocks.get(i).getRemove()) {
				blocks.remove(i);
			}
		}
		
		for(int i = 0; i < enemies.size(); i++) {
			if(enemies.get(i).dead) {
				enemies.get(i).remove();
				enemies.remove(i);
			}
		}
		
		for(Enemy enemy : enemies) {
			enemy.update();
		}
		
		for(Enemy enemy : enemies) {
			for(Missile missile : player.getMissiles()) {
				if(enemy.c_box.overlaps(missile.c_box)) {
					Resources.explode.play();
					missile.explode = true;
					missile.speed = 0;
					enemy.dead = true;
					if(enemy.flying)
						score+=100;
					else
						score+=10;
				}
			}
			if(enemy.c_box.overlaps(player.c_box)) {
				score = 0;
			}
		}
			
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
