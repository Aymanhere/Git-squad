package CODE.ENTITY;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import CODE.MANAGER.Game;
import CODE.WORLD.Tile;
import CODE.WORLD.World;

public abstract class Entity  {
	
	protected World world;
	protected Game game;
	public float x;
	public float y;
	protected int width, height;
	public Rectangle bounds;
	public static final int DEFAULT_HEALTH = 15;
	public int health;
	protected boolean active=true;
	

	public Entity( Game game,World world,float x, float y, int width, int height) throws Exception{
		this.world=world;
		this.game=game;
		
		this.x = x;
		this.y = y;

			//throw new Exception("The hero is outside the map!");*/
			

		this.width = width;
		this.height = height;
		health = DEFAULT_HEALTH;

		bounds = new Rectangle(0, 0, width, height);
		
		
	}

	public abstract void tick();

	public abstract void render(Graphics g);
	
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		ArrayList<Entity> entities=world.getEntityManager().getEntities();
		Class<StaticEntity> s=StaticEntity.class;
		if(entities!=null) {
		for(int i=0;i<entities.size();i++){
			if(entities.get(i).getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)) && entities.get(i)!=this && !(s.isInstance(entities.get(i))))
				return true;
		}return false;
		}else {
		return false;}
	}
	
	
	
	public boolean checkEntityCollisionsHero(float xOffset, float yOffset){

		if(world.getEntityManager().getHero().getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true;
		}else {
			return false;
		
	}
}

	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
 
	public boolean collisionWithTile(int x, int y){
		return world.getTile(x, y).isSolid(world.getId(x, y));
	}
	
	public void hurt(double amt) {
		health-=amt;
		if(health<=0) {
			active=false;
			
		}
	}

	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}



}
