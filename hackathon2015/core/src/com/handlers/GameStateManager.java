package com.handlers;

import java.util.Stack;

import com.main.game;
import com.states.GameState;
import com.states.Play;

public class GameStateManager {
	public game game;
	
	private Stack<GameState> gameStates;
	
	public static final int PLAY = 643;
	
	public GameStateManager(game game) {
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(PLAY);
		
	}
	
	public game game() { return game; }
	
	public void update(float dt) {
		gameStates.peek().update(dt);
	}

	public void render() {
		gameStates.peek().render();;
	}
	
	private GameState getState(int state) {
		if(state == PLAY) return new Play(this);
		return null;
	}
	
	public void setState(int state) {
		popState();
		pushState(state);
	}

	public void pushState(int state) {
		gameStates.push(getState(state));
	}
	
	public void popState() {
		GameState g = gameStates.pop();
		g.dispose();
	}
}
