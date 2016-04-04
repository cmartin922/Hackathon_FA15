package com.handlers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class InputProcesser extends InputAdapter {

	@Override
	public boolean keyDown(int k ) {		
		if(k == Keys.Q) {
			Input.setKey(Input.RIGHTLEGUP, true);
		}
		
		if(k == Keys.W) {
			Input.setKey(Input.LEFTLEGUP, true);
		}
		
		if(k == Keys.O) {
			Input.setKey(Input.RIGHTARM, true);
		}
		
		if(k == Keys.P) {
			Input.setKey(Input.LEFTARM, true);
		}
		
		if(k == Keys.A) {
			Input.setKey(Input.RIGHTLEGDOWN, true);
		}
		
		if(k == Keys.S) {
			Input.setKey(Input.LEFTLEGDOWN, true);
		}
		
		if(k == Keys.Z) {
			Input.setKey(Input.SLIDELEFT, true);
		}
		
		if(k == Keys.X) {
			Input.setKey(Input.SLIDERIGHT, true);
		}
		
		return true;
	}
	
	@Override
	public boolean keyUp(int k) {
		
		if(k == Keys.Q) {
			Input.setKey(Input.RIGHTLEGUP, false);
		}
		
		if(k == Keys.W) {
			Input.setKey(Input.LEFTLEGUP, false);
		}
		
		if(k == Keys.O) {
			Input.setKey(Input.RIGHTARM, false);
		}
		
		if(k == Keys.P) {
			Input.setKey(Input.LEFTARM, false);
		}
		
		if(k == Keys.A) {
			Input.setKey(Input.RIGHTLEGDOWN, false);
		}
		
		if(k == Keys.S) {
			Input.setKey(Input.LEFTLEGDOWN, false);
		}
		
		if(k == Keys.Z) {
			Input.setKey(Input.SLIDELEFT, false);
		}
		
		if(k == Keys.X) {
			Input.setKey(Input.SLIDERIGHT, false);
		}
		return true;
	}
}
