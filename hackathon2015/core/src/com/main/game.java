package com.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.handlers.GameStateManager;
import com.handlers.Input;
import com.handlers.InputProcesser;

public class game extends ApplicationAdapter {
    public static final String TITLE = "QWACKATHOP";
    public static final int V_WIDTH = 320;
    public static final int V_HEIGHT = 240;
    public static final int SCALE = 2;
    
    public static final float STEP = 1 /60f;
    private float accum;
    
    private OrthographicCamera cam;
    private OrthographicCamera HUDcam;
    private SpriteBatch sb;
    
    private GameStateManager gsm;
    
    @Override
    public void create() {  
    	
    	
    	Gdx.input.setInputProcessor(new InputProcesser());
    	
    	sb = new SpriteBatch();
    	cam = new OrthographicCamera();
    	cam.setToOrtho(false, V_WIDTH, V_HEIGHT);
    	
    	HUDcam = new OrthographicCamera();
    	HUDcam.setToOrtho(false, V_WIDTH, V_HEIGHT);
    	
    	gsm = new GameStateManager(this);
    }

    @Override
    public void dispose() {
       }

    @Override
    public void render() {   
    	accum += Gdx.graphics.getDeltaTime();
    	while(accum >= STEP) {
    		accum -= STEP;
    		gsm.update(STEP);
    		gsm.render();
    		
    		Input.update();
    	}
     
    }

	public OrthographicCamera getCamera() {
		return cam;
	}
	
	public OrthographicCamera getHUDCamera() {
		return HUDcam;
	}

	public SpriteBatch getSpriteBatch() {
		return sb;
	}

}
