package CODE.ENTITY;

import java.awt.Graphics;

import CODE.ANIMATION.Assets;
import CODE.MANAGER.Game;
import CODE.WORLD.Tile;
import CODE.WORLD.World;

public class Piege extends StaticEntity {

	private long lastAttackTimer,attackCooldown=50,attackTimer=attackCooldown;

	public Piege(Game game, World world, float x, float y) {
		super(game, world, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT);
		bounds.x=0;
		bounds.y=0;
		bounds.width=32;
		bounds.height=24;
		
	}

	@Override
	public void tick() {
		healthHero();
		
	}
public void healthHero() {
	if((world.getEntityManager().getHero().getCollisionBounds(0,0).intersects(this.getCollisionBounds(0,0)))) {
		attackTimer+=System.currentTimeMillis()-lastAttackTimer;
		lastAttackTimer=System.currentTimeMillis();
		if(attackTimer>=attackCooldown) {
			world.getEntityManager().getHero().hurt(1);
			attackTimer=0;
		}
	}
	
		
	
}
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.piege,(int)x,(int) y,null);
	}

	

}
