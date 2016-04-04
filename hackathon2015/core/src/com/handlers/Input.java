package com.handlers;

public class Input {

	//stores the state of the current keys pressed
	public static boolean[] keys;
	//stores the previous state of keys pressed
	public static boolean[] pkeys;
	
	public static final int NUM_KEYS = 8;
	public static final int RIGHTARM = 0;
	public static final int RIGHTLEGUP = 1;
	public static final int LEFTLEGUP = 2;
	public static final int LEFTARM = 3;
	public static final int RIGHTLEGDOWN = 4;
	public static final int LEFTLEGDOWN = 5;
	public static final int SLIDELEFT = 6;
	public static final int SLIDERIGHT = 7;
	
	
	static {
		keys = new boolean[NUM_KEYS];
		pkeys = new boolean[NUM_KEYS];
	}
	
	public static void update() {
		for (int i = 0; i < NUM_KEYS; i++) {
			pkeys[i] = keys[i];
		}
	}
	
	public static void setKey(int i, boolean b) {
		keys[i] = b;
	}
	public static boolean isDown(int i) {
		return keys[i];
	}
	
	public static boolean isPressed(int i ) {
		return keys[i] && !pkeys[i];
	}
}
