package com.kerlinmichel.mechvelox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Resources {
	
	public static Texture red = new Texture("Red.png");
	
	public static Texture floor1 = new Texture("m-001.jpg");
	public static Texture floor2 = new Texture("m-002.jpg");
	public static Texture floor3 = new Texture("m-003.jpg");
	public static Texture floor4 = new Texture("m-004.jpg");
	public static Texture floor5 = new Texture("m-024.jpg");
	public static Texture floor6 = new Texture("m-027.jpg");
	public static Texture floor7 = new Texture("m-029.jpg");
	public static Texture floor8 = new Texture("m-030.jpg");
	public static Texture floor9 = new Texture("m-031.jpg");
	public static Texture floor10 = new Texture("m-040.jpg");
	
	public static Texture playerHover1 = new Texture("Player\\Player Hover 1.png");
	public static Texture playerHover2 = new Texture("Player\\Player Hover 2.png");
	public static Texture playerShoot = new Texture("Player\\Player Shoot.png");
	
	public static Texture m1 = new Texture("missile/m1.png");
	public static Texture m2 = new Texture("missile/m2.png");
	public static Texture m3 = new Texture("missile/m3.png");
	public static Texture m4 = new Texture("missile/m4.png");
	public static Texture m5 = new Texture("missile/m5.png");
	public static Texture m6 = new Texture("missile/m6.png");
	public static Texture m7 = new Texture("missile/m7.png");
	public static Texture e1 = new Texture("missile/e1.png");
	public static Texture e2 = new Texture("missile/e2.png");
	public static Texture e3 = new Texture("missile/e3.png");
	public static Texture e4 = new Texture("missile/e4.png");
	public static Texture e5 = new Texture("missile/e5.png");
	public static Texture e6 = new Texture("missile/e6.png");
	public static Texture e7 = new Texture("missile/e7.png");
	
	public static Texture en1 = new Texture("enemy/Enemy1.png");
	public static Texture en2 = new Texture("enemy/Enemy2.png");
	public static Texture en3 = new Texture("enemy/Enemy3.png");
	public static Texture en4 = new Texture("enemy/Enemy4.png");
	
	public static Texture fl1 = new Texture("enemy/fl1.png");
	public static Texture fl2 = new Texture("enemy/fl2.png");
	public static Texture fl3 = new Texture("enemy/fl3.png");
	public static Texture fl4 = new Texture("enemy/fl4.png");
	
	public static Music m = Gdx.audio.newMusic(Gdx.files.internal("headbangr.ogg"));
	
	public static Sound explode = Gdx.audio.newSound(Gdx.files.internal("ex.wav"));
	public static Sound shoot = Gdx.audio.newSound(Gdx.files.internal("rocket.wav"));
	

}
