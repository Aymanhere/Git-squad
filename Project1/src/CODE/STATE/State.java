package CODE.STATE;

import java.awt.Graphics;

import CODE.MANAGER.Game;

public abstract class State {
	protected Game game;
	
	private static State currentState=null;
	
	public static void setState(State state) {
		currentState=state;
	}
	public static State getState() {
		return currentState;
	}
	
	public State(Game game) {
		this.game=game;
	}


        //Class
		public abstract void tick();
		
		public abstract void render(Graphics g);
	

}
