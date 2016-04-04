package com.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.handlers.GameStateManager;
import com.main.game;

public abstract class GameState {

	protected GameStateManager gsm;
	protected game game;
	
	protected SpriteBatch sb;
	protected OrthographicCamera cam;
	protected OrthographicCamera HUDcam;
	
	protected GameState(GameStateManager gsm) {
	this.gsm = gsm;
	game = gsm.game;
	sb = game.getSpriteBatch();
	cam = game.getCamera();
	HUDcam = game.getHUDCamera();
	
	}
	
	public abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render();
	public abstract void dispose();
}
