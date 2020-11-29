package CODE.ENTITY;

import CODE.MANAGER.Game;
import CODE.WORLD.World;

public abstract class Creature extends Entity{

	
	
	public static final float DEFAULT_SPEED = 0.8f;
	public static final int DEFAULT_CREATURE_WIDTH = 32,
							DEFAULT_CREATURE_HEIGHT = 32;

	
	protected float speed;
	protected float xMove, yMove;

	public Creature(Game game,World world,float x, float y, int width, int height) {
		super(game,world,x, y, width, height);
	
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		
	}

	protected boolean collisionWithTile(int x, int y){
		return world.getTile(x, y).isSolid(world.getId(x, y));
	}



	


}
