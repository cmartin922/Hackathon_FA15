package com.loader;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.main.game;

public class BackgroundLoader {
	int screen = 0;
	SpriteBatch batch;
	Sprite sprite;
	SpriteBatch computerBatch;
    Texture computerTexture;
    Sprite computerSprite;
    
    SpriteBatch blankBatch;
    Texture blankTexture;
    Sprite blankSprite;
    
    SpriteBatch bowlBatch;
    Texture bowlTexture;
    Sprite bowlSprite;
    
    SpriteBatch drinksBatch;
    Texture drinksTexture;
    Sprite drinksSprite;
    
    SpriteBatch snacksBatch;
    Texture snacksTexture;
    Sprite snacksSprite;
    
	public BackgroundLoader() {
		String computerPath = "Backgrounds/computer.png";
		computerBatch = new SpriteBatch();
		computerTexture = new Texture(Gdx.files.internal(computerPath));
		computerSprite = new Sprite(computerTexture);
		
		computerSprite.scale((float) 0.01);
		
		String blankPath = "/Users/miranda/Documents/Coding/libgdx/hackathon2015/core/assets/Backgrounds/blank.png";
		blankBatch = new SpriteBatch();
		blankTexture = new Texture(Gdx.files.internal(blankPath));
		blankSprite = new Sprite(blankTexture);
		
		computerSprite.scale((float) 0.01);
		
		String drinksPath = "/Users/miranda/Documents/Coding/libgdx/hackathon2015/core/assets/Backgrounds/drinks.png";
		drinksBatch = new SpriteBatch();
		drinksTexture = new Texture(Gdx.files.internal(drinksPath));
		drinksSprite = new Sprite(computerTexture);
		
		computerSprite.scale((float) 0.01);
		
		String bowlPath = "/Users/miranda/Documents/Coding/libgdx/hackathon2015/core/assets/Backgrounds/bowl.png";
		bowlBatch = new SpriteBatch();
		bowlTexture = new Texture(Gdx.files.internal(bowlPath));
		bowlSprite = new Sprite(bowlTexture);
		
		computerSprite.scale((float) 0.01);
		
		String snacksPath = "/Users/miranda/Documents/Coding/libgdx/hackathon2015/core/assets/Backgrounds/snacks.png";
		snacksBatch = new SpriteBatch();
		snacksTexture = new Texture(Gdx.files.internal(drinksPath));
		snacksSprite = new Sprite(snacksTexture);
		
		computerSprite.scale((float) 0.01);
	}
	
	public void render() {
        if (screen == 0) {
        computerBatch.begin();
        computerSprite.draw(computerBatch);
        computerBatch.end();
        }
        else {
        	//render
        	batch.begin();
        	sprite.draw(batch);
        	batch.end();
        	
        }
	}
	
	private void chooseRandom() {
		Random bgchooser = new Random();
		int bg = bgchooser.nextInt(3);
		System.out.println(bg);
		if (bg == 0) {
			batch = drinksBatch;
			sprite = drinksSprite;
		} else if (bg == 1) {
			batch = blankBatch;
			sprite = blankSprite;
		} else if (bg == 2) {
			batch = snacksBatch;
			sprite = snacksSprite;
		} else if (bg == 3) {
			batch = bowlBatch;
			sprite = bowlSprite;
		}
	}

}
