package CODE.ENTITY;

import java.awt.Graphics;

import CODE.ANIMATION.Assets;
import CODE.MANAGER.Game;
import CODE.WORLD.Tile;
import CODE.WORLD.World;

public class Magique extends StaticEntity{
	private long lastAttackTimer,attackCooldown=1000,attackTimer=attackCooldown;

	public Magique(Game game, World world, float x, float y) {
		super(game, world, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT);
		bounds.x=8;
		bounds.y=0;
		bounds.width=26;
		bounds.height=28;
		
	}

	@Override
	public void tick() {
		effetmagique();
		
	}
public void effetmagique() {
	if((world.getEntityManager().getHero().getCollisionBounds(0,0).intersects(this.getCollisionBounds(0,0)))) {
		attackTimer+=System.currentTimeMillis()-lastAttackTimer;
		lastAttackTimer=System.currentTimeMillis();
		if(attackTimer>=attackCooldown) {
			if(world.getEntityManager().getHero().health<15) {
			world.getEntityManager().getHero().hurt(-1);
			attackTimer=0;}
		}
	}
	
		
	
}
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.magique,(int)x,(int) y,null);
	}

	


}
