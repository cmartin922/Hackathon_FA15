
package com.handlers;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class MyContactListener implements ContactListener{
	
	private boolean playerOnGround;

	//called when 2 fixtures start to collide
	@Override
	public void beginContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		
		//check if player is on ground and set true
		if((fa.getUserData() != null && fa.getUserData().equals("foot")) || (fb.getUserData() != null && fb.getUserData().equals("foot"))) {
			playerOnGround = true;
		}
		
	}

	//called when 2 fixtures are no longer colliding
	@Override
	public void endContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		
		//if player leaves ground set to false
		if((fa.getUserData() != null && fa.getUserData().equals("foot")) || (fb.getUserData() != null && fb.getUserData().equals("foot"))) {
			playerOnGround = false;
		}		
	}
	
	public boolean isPlayerOnGround() { return playerOnGround; }

	
	
	//collision detection
	//presolve
	//collision handling
	//postsolve
	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		
	}

}
