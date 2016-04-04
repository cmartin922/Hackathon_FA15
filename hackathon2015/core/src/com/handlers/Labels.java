package com.handlers;

import java.text.DecimalFormat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Labels {

	boolean sleep = false;
	int code = 0;
	SpriteBatch spriteBatch;
	BitmapFont font;
	Color fontColor = new Color(1.0f, 1.0f, 1.0f, 1.0f);

	public void create() {
		spriteBatch = new SpriteBatch();
		font = new BitmapFont();
	}

	public void dispose() {
		spriteBatch.dispose();
		font.dispose();
	}

	double time = 720;
	double energy = 100.0;
	long startTime = System.currentTimeMillis();
	DecimalFormat df = new DecimalFormat("#.##");

	public void render() {
		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		if (time >= 0) {
//			Gdx.gl.glClearColor(0, 0, 0, 0);
//			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			long currentTime = System.currentTimeMillis() - startTime;
			if (currentTime >= 10) {
				String timeDisplay = "Time: " + (df.format(time / 60))
						+ " hours";
				energy = energy - 0.5 / 100;
				String energyDisplay = "Energy: " + (df.format(energy));
				
				String codeDisplay = "Progress: " + code + "/1000";
				while (energy <= 20) {
					sleep();
				}
				spriteBatch.begin();
				font.draw(spriteBatch, timeDisplay, 10, 450);
				font.draw(spriteBatch, energyDisplay, 500, 450);
				font.draw(spriteBatch, codeDisplay, 250, 450);
				spriteBatch.end();
				startTime = System.currentTimeMillis();
				time = time - 0.01;
			}
		}
	}
	public void sleep() {
		spriteBatch.begin();
		sleep = true;
		time = time - 45;
		long sleepTime = System.currentTimeMillis();
//		font.draw(spriteBatch, "Low energy! Go to sleep to gain energy.", 10,
//				430);
		while (System.currentTimeMillis() - sleepTime <= 3000) {
//			System.out.println("here");
		}
		spriteBatch.end();
		sleep = false;
		if (energy + 40 >= 100) {
			energy = 100;
		} else {
			energy = energy + 40;
		}
	}
	
	public boolean win(){
		return (time==0 && code==0);		
	}
	
	public void code() {
		code += 2;
	}
}