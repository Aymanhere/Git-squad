package CODE.ENTITY;

import CODE.MANAGER.Game;
import CODE.WORLD.World;

public abstract class  StaticEntity extends Entity {

	public StaticEntity(Game game, World world, float x, float y, int width, int height) {
		super(game, world, x, y, width, height);
		
	}
	
	

}
