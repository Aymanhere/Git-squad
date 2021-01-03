package CODE.ENTITY;

import CODE.MANAGER.Game;
import CODE.WORLD.World;

public abstract class Creature extends Entity{

	
	
	public static final float DEFAULT_SPEED = 0.8f;
	public static final int DEFAULT_CREATURE_WIDTH = 32,
							DEFAULT_CREATURE_HEIGHT = 32;
	

	
	protected float speed;
	public float xMove;
	public float yMove;

	public Creature(Game game,World world,float x, float y, int width, int height) throws Exception {
		super(game,world,x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		
	}






	


}
