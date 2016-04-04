package com.loader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.states.Play;

public class BodyLoader {
	Play p;
	SpriteBatch headBatch;
    Texture headTexture;
    Sprite headSprite;
    
    SpriteBatch torso1Batch;
    Texture torso1Texture;
    Sprite torso1Sprite;
    
    SpriteBatch torso2Batch;
    Texture torso2Texture;
    Sprite torso2Sprite;
    
    SpriteBatch torso3Batch;
    Texture torso3Texture;
    Sprite torso3Sprite;
    
    SpriteBatch upperArmLBatch;
    Texture upperArmLTexture;
    Sprite upperArmLSprite;
    	
    SpriteBatch upperArmRBatch;
    Texture upperArmRTexture;
    Sprite upperArmRSprite;
    
    SpriteBatch lowerArmRBatch;
    Texture lowerArmRTexture;
    Sprite lowerArmRSprite;
    
    SpriteBatch lowerArmLBatch;
    Texture lowerArmLTexture;
    Sprite lowerArmLSprite;
    
	public BodyLoader(Play p) {
		this.p = p;
		String filePath = "/../../../assets/Body/";
		String headPath = "/Users/miranda/Documents/Coding/libgdx/hackathon2015/core/assets/Body/head.png";
		headBatch = new SpriteBatch();
	    headTexture = new Texture(Gdx.files.internal(headPath));
	    headSprite = new Sprite(headTexture);
	    headSprite.scale((float) .1);
	    
	    String torso1Path = "/Users/miranda/Documents/Coding/libgdx/hackathon2015/core/assets/Body/torso1.png";
	    torso1Batch = new SpriteBatch();
	    torso1Texture = new Texture(Gdx.files.internal(torso1Path));
	    torso1Sprite = new Sprite(torso1Texture);
		
	    String torso2Path = "/Users/miranda/Documents/Coding/libgdx/hackathon2015/core/assets/Body/torso2.png";
	    torso2Batch = new SpriteBatch();
	    torso2Texture = new Texture(Gdx.files.internal(torso2Path));
	    torso2Sprite = new Sprite(torso2Texture);
	    
	    String torso3Path = "/Users/miranda/Documents/Coding/libgdx/hackathon2015/core/assets/Body/torso3.png";
	    torso3Batch = new SpriteBatch();
	    torso3Texture = new Texture(Gdx.files.internal(torso3Path));
	    torso3Sprite = new Sprite(torso3Texture);
	}
	
	public void bodyRender() {
		Vector2 headPos = p.head.getPosition();
		
		headSprite.setPosition(headPos.x, headPos.y);
//	    bottleSprite.setOrigin(bottleModelOrigin.x, bottleModelOrigin.y);
	    headSprite.setRotation(p.head.getAngle() * MathUtils.radiansToDegrees);
	    
	    headBatch.begin();
        headSprite.draw(headBatch);
        headBatch.end();
	}
	
}
