package CODE.ENTITY;

import java.awt.Graphics;

import CODE.ANIMATION.Assets;
import CODE.MANAGER.Game;
import CODE.WORLD.Tile;
import CODE.WORLD.World;

public class Piege extends StaticEntity {

	private long lastAttackTimer,attackCooldown=50,attackTimer=attackCooldown;

	public Piege(Game game, World world, float x, float y) throws Exception {
		super(game, world, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT);
		bounds.x=0;
		bounds.y=0;
		bounds.width=32;
		bounds.height=24;
		int tx1 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
		int tx2 = (int) (x+ bounds.x) / Tile.TILEWIDTH;
		
		if(0<=this.x && this.x<=968 && 0<=this.y && this.y<=608 && !collisionWithTile(tx1, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx1, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(tx2, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx2, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) )  {
			this.x = x;
			this.y = y;
		   }else {
			x=880;
			y=20;
			tx1 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
			tx2 = (int) (x+ bounds.x) / Tile.TILEWIDTH;
			  if(!collisionWithTile(tx1, (int) (y+ bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx1, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(tx2, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx2, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) ) {
			     System.out.println("Positionnement incorrect du Piege !! donc il est positionné par défaut au point(880,20)");
			  this.x = 880;
			  this.y = 20;}else {
				  this.x = 880;
				  this.y = 20;

				  System.out.println("Position par défaut du piege n'est pas convenable ! ");
			  }
		   }
		
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
