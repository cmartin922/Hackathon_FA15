package com.states;

import static com.handlers.B2DVars.PPM;

import java.awt.Canvas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.*;
import com.handlers.B2DVars;
import com.handlers.GameStateManager;
import com.handlers.Input;
import com.handlers.Labels;
import com.handlers.MyContactListener;
import com.loader.BackgroundLoader;
import com.loader.BodyLoader;
import com.main.game;

public class Play extends GameState {

	private BodyLoader boLoader;
	private BackgroundLoader baLoader;
	
	private World world;
	private Box2DDebugRenderer b2dr;

	private OrthographicCamera b2dCam;

	private Body floorBody;

	private MyContactListener contactListener;

	public Body head;
	public Body lowerLegL;
	public Body upperLegL;
	public Body lowerLegR;
	public Body upperLegR;
	public Body lowerArmR;
	public Body lowerArmL;
	
	Body torso2;
	
	Labels labels;
	
	public Play(GameStateManager gsm) {
		super(gsm);
		
		labels = new Labels();
		labels.create();
		
	//	boLoader = new BodyLoader(this);
		baLoader = new BackgroundLoader();

		int startX = 200;
		int startY = 170;

		world = new World(new Vector2(0, -9.81f), true);

		// set world to use custom contact listener
		world.setContactListener(contactListener = new MyContactListener());

		b2dr = new Box2DDebugRenderer();

		b2dCam = new OrthographicCamera();
		b2dCam.setToOrtho(false, game.V_WIDTH / PPM, game.V_HEIGHT / PPM);

		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = new FixtureDef();
		RevoluteJointDef rjd = new RevoluteJointDef();

		// create floor
		bdef.position.set(-100 / PPM, 0 / PPM);
		bdef.type = BodyType.StaticBody;
		floorBody = world.createBody(bdef);
		shape.setAsBox(1000 / PPM, 10 / PPM);
		fdef.shape = shape;
		floorBody.createFixture(fdef).setUserData("floor");

		// BODIES
		bdef.type = BodyType.DynamicBody;
		// Head
		shape.setAsBox(10 / PPM, 10 / PPM);
		fdef.shape = shape;
		fdef.density = (float) -.1;
		fdef.friction = (float) 0.4;
		fdef.restitution = (float) 0.3;
		bdef.position.set(startX / PPM, startY / PPM);
		head = world.createBody(bdef);
		head.createFixture(fdef);

		// Torso1
		shape.setAsBox(15 / PPM, 10 / PPM);
		fdef.shape = shape;
		fdef.density = (float) 1;
		fdef.friction = (float) 0.4;
		fdef.restitution = (float) 0.1;
		bdef.position.set(startX / PPM, (startY - 28) / PPM);
		Body torso1 = world.createBody(bdef);
		torso1.createFixture(fdef);
		// Torso2
		shape.setAsBox(15 / PPM, 10 / PPM);
		fdef.shape = shape;
		bdef.position.set(startX / PPM, (startY - 43) / PPM);
		torso2 = world.createBody(bdef);
		torso2.createFixture(fdef);
		// Torso3
		shape.setAsBox(15 / PPM, 10 / PPM);
		fdef.shape = shape;
		bdef.position.set(startX / PPM, (startY - 58) / PPM);
		Body torso3 = world.createBody(bdef);
		torso3.createFixture(fdef);

		// UpperArm
		fdef.density = (float) .5;
		fdef.friction = (float) 0.4;
		fdef.restitution = (float) 0.1;
		// L
		shape.setAsBox(18 / PPM, (float) (6.5 / PPM));
		fdef.shape = shape;
		bdef.position.set((startX + 30) / PPM, (startY - 20) / PPM);
		Body upperArmL = world.createBody(bdef);
		upperArmL.createFixture(fdef);
		// R
		shape.setAsBox(18 / PPM, (float) (6.5 / PPM));
		fdef.shape = shape;
		bdef.position.set((startX - 30) / PPM, (startY - 20) / PPM);
		Body upperArmR = world.createBody(bdef);
		upperArmR.createFixture(fdef);

		// LowerArm
		fdef.density = (float) 1.0;
		fdef.friction = (float) 0.4;
		fdef.restitution = (float) 0.1;
		// L
		shape.setAsBox(17 / PPM, 6 / PPM);
		fdef.shape = shape;
		bdef.position.set((startX + 57) / PPM, (startY - 20) / PPM);
		lowerArmL = world.createBody(bdef);
		lowerArmL.createFixture(fdef);
		// R
		shape.setAsBox(17 / PPM, 6 / PPM);
		fdef.shape = shape;
		bdef.position.set((startX - 57) / PPM, (startY - 20) / PPM);
		lowerArmR = world.createBody(bdef);
		lowerArmR.createFixture(fdef);

		// UpperLeg
		fdef.density = (float) 1;
		fdef.friction = (float) .4;
		fdef.restitution = (float) 0.1;
		// L
		shape.setAsBox((float) (7.5 / PPM), 22 / PPM);
		fdef.shape = shape;
		bdef.position.set((startX + 8) / PPM, (startY - 85) / PPM);
		upperLegL = world.createBody(bdef);
		upperLegL.createFixture(fdef);
		// R
		shape.setAsBox((float) (7.5 / PPM), 22 / PPM);
		fdef.shape = shape;
		bdef.position.set((startX - 8) / PPM, (startY - 85) / PPM);
		upperLegR = world.createBody(bdef);
		upperLegR.createFixture(fdef);

		// LowerLeg
		fdef.density = (float) 5.0;
		fdef.friction = (float) 0.4;
		fdef.restitution = (float) 0.1;
		// L
		shape.setAsBox(6 / PPM, 20 / PPM);
		fdef.shape = shape;
		bdef.position.set((startX + 8) / PPM, (startY - 120) / PPM);
		lowerLegL = world.createBody(bdef);
		lowerLegL.createFixture(fdef);
		// R
		shape.setAsBox(6 / PPM, 20 / PPM);
		fdef.shape = shape;
		bdef.position.set((startX - 8) / PPM, (startY - 120) / PPM);
		lowerLegR = world.createBody(bdef);
		lowerLegR.createFixture(fdef);

		// Feet
		fdef.density = (float) 5.0;
		fdef.friction = (float) .4;
		fdef.restitution = (float) 0.1;
		// L
		shape.setAsBox(10 / PPM, 5 / PPM);
		fdef.shape = shape;
		bdef.position.set((startX + 12) / PPM, (startY - 140) / PPM);
		Body footL = world.createBody(bdef);
		footL.createFixture(fdef);
		// R
		shape.setAsBox(10 / PPM, 5 / PPM);
		fdef.shape = shape;
		bdef.position.set((startX - 12) / PPM, (startY - 140) / PPM);
		Body footR = world.createBody(bdef);
		footR.createFixture(fdef);

		// JOINTS
		rjd.enableLimit = true;

		// Head to shoulders
		rjd.lowerAngle = (float) (-40 / (180 / Math.PI));
		rjd.upperAngle = (float) (40 / (180 / Math.PI));
		rjd.initialize(torso1, head, new Vector2(startX / PPM, (startY - 15)
				/ PPM));
		world.createJoint(rjd);

		// Upper arm to shoulders
		// L
		rjd.lowerAngle = (float) (-85 / (180 / Math.PI));
		rjd.upperAngle = (float) (130 / (180 / Math.PI));
		rjd.initialize(torso1, upperArmL, new Vector2((startX + 18) / PPM,
				(startY - 20) / PPM));
		world.createJoint(rjd);
		// R
		rjd.lowerAngle = (float) (-130 / (180 / Math.PI));
		rjd.upperAngle = (float) (85 / (180 / Math.PI));
		rjd.initialize(torso1, upperArmR, new Vector2((startX - 18) / PPM,
				(startY - 20) / PPM));
		world.createJoint(rjd);

		// Lower arm to upper arm
		// L
		rjd.lowerAngle = (float) (-130 / (180 / Math.PI));
		rjd.upperAngle = (float) (10 / (180 / Math.PI));
		rjd.initialize(upperArmL, lowerArmL, new Vector2((startX + 45) / PPM,
				(startY - 20) / PPM));
		world.createJoint(rjd);
		// R
		rjd.lowerAngle = (float) (-10 / (180 / Math.PI));
		rjd.upperAngle = (float) (130 / (180 / Math.PI));
		rjd.initialize(upperArmR, lowerArmR, new Vector2((startX - 45) / PPM,
				(startY - 20) / PPM));
		world.createJoint(rjd);

		// Shoulders/stomach
		rjd.lowerAngle = (float) (-1 / (180 / Math.PI));
		rjd.upperAngle = (float) (1 / (180 / Math.PI));
		rjd.initialize(torso1, torso2, new Vector2(startX / PPM, (startY - 35)
				/ PPM));
		world.createJoint(rjd);
		// Stomach/hips
		rjd.initialize(torso2, torso3, new Vector2(startX / PPM, (startY - 50)
				/ PPM));
		world.createJoint(rjd);

		// Torso to upper leg
		// L
		rjd.lowerAngle = (float) (-85 / (180 / Math.PI));
		rjd.upperAngle = (float) (115 / (180 / Math.PI));
		rjd.initialize(torso3, upperLegL, new Vector2((startX + 8) / PPM,
				(startY - 72) / PPM));
		world.createJoint(rjd);
		// R
		rjd.lowerAngle = (float) (-135 / (180 / Math.PI));
		rjd.upperAngle = (float) (105 / (180 / Math.PI));
		rjd.initialize(torso3, upperLegR, new Vector2((startX - 8) / PPM,
				(startY - 72) / PPM));
		world.createJoint(rjd);

		// Upper leg to lower leg
		// L
		rjd.lowerAngle = (float) (-25 / (180 / Math.PI));
		rjd.upperAngle = (float) (45 / (180 / Math.PI));
		rjd.initialize(upperLegL, lowerLegL, new Vector2((startX + 8) / PPM,
				(startY - 105) / PPM));
		world.createJoint(rjd);
		// R
		rjd.lowerAngle = (float) (-45 / (180 / Math.PI));
		rjd.upperAngle = (float) (25 / (180 / Math.PI));
		rjd.initialize(upperLegR, lowerLegR, new Vector2((startX - 8) / PPM,
				(startY - 105) / PPM));
		world.createJoint(rjd);

		// Lower leg to foot
		// L
		rjd.lowerAngle = (float) (-1 / (180 / Math.PI));
		rjd.upperAngle = (float) (1 / (180 / Math.PI));
		rjd.initialize(lowerLegL, footL, new Vector2((startX + 8) / PPM,
				(startY - 140) / PPM));
		world.createJoint(rjd);
		// R
		rjd.lowerAngle = (float) (-1 / (180 / Math.PI));
		rjd.upperAngle = (float) (1 / (180 / Math.PI));
		rjd.initialize(lowerLegR, footR, new Vector2((startX - 8) / PPM,
				(startY - 140) / PPM));
		world.createJoint(rjd);

	}

	// control what collides with what by defining types and masks
	// type what type a thing is
	// mask what can collide with a thing
	// fdef.filter.categoryBits =
	// fdef.filter.maskBits =

	// bit operators
	// a && b
	// a || b
	// ~a

	public void handleInput() {
		// control his left leg
		if (Input.isDown(Input.LEFTLEGUP)) {
			if (upperLegL.getAngularVelocity() < 1) {
				lowerLegL.applyAngularImpulse((float) .005, true);
				upperLegL.applyAngularImpulse((float) .05, true);
			}

		}
		if (Input.isDown(Input.LEFTLEGDOWN)) {
			if (upperLegL.getAngularVelocity() < 1) {
				lowerLegL.applyAngularImpulse((float) .005, true);
				upperLegL.applyAngularImpulse((float) -.05, true);
			}

		}

		// control his right leg
		if (Input.isDown(Input.RIGHTLEGUP)) {
			if (upperLegR.getAngularVelocity() < 3) {
			lowerLegR.applyAngularImpulse((float) .005, true);
			upperLegR.applyAngularImpulse((float) -.05, true);
			}
		}
		if (Input.isDown(Input.RIGHTLEGDOWN)) {
			if (upperLegR.getAngularVelocity() < 3) {
				lowerLegR.applyAngularImpulse((float) .005, true);
				upperLegR.applyAngularImpulse((float) .05, true);
			}

		}

		// control his right arm
		if (Input.isDown(Input.RIGHTARM)) {
			if (lowerArmR.getAngularVelocity() < 2) {
			lowerArmR.applyAngularImpulse((float) -.05, true);
			}
		}
		if (Input.isPressed(Input.RIGHTARM) || Input.isPressed(Input.LEFTARM)) {
			if ((head.getWorldCenter().x) > ((game.V_WIDTH/2)-(159)) && ((head.getWorldCenter().x) < ((game.V_WIDTH/2)+(159)))) {
				labels.code();
			}
		}

		// control his left arm
		if (Input.isDown(Input.LEFTARM)) {
			if (lowerArmL.getAngularVelocity() < 2) {
			lowerArmL.applyAngularImpulse((float) .25, true);
			}
		}
		
		if(Input.isDown(Input.LEFTARM) && Input.isDown(Input.RIGHTARM)) {
			if (head.getLinearVelocity().y < 1)
			head.applyLinearImpulse(0, (float) .3, head.getWorldCenter().x, head.getWorldCenter().y, true);
		}
		
		//cheat saves
		if(Input.isDown(Input.SLIDELEFT)) {
			if (head.getLinearVelocity().y < 2) {
			head.applyLinearImpulse((float) -.3, 0, head.getWorldCenter().x, head.getWorldCenter().y, true);
			}
		}
		if(Input.isDown(Input.SLIDERIGHT)) {
			if (head.getLinearVelocity().y < 2) {
			head.applyLinearImpulse((float) .3, 0, head.getWorldCenter().x, head.getWorldCenter().y, true);
			}
		}
	}
	

	public void update(float dt) {
		handleInput();
		world.step(dt, 6, 2);

	}

	public void render() {

		// clear screen
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		// draw box2d world
		baLoader.render();
	//	boLoader.bodyRender();
		labels.render();
		
		b2dr.render(world, b2dCam.combined);
		

	}

	public void dispose() {
	}

}
