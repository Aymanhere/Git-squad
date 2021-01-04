package CODE.ENTITY;

import java.awt.Graphics;

import CODE.ANIMATION.Assets;
import CODE.MANAGER.Game;
import CODE.WORLD.Tile;
import CODE.WORLD.World;

public class Magique extends StaticEntity{
	private long lastAttackTimer,attackCooldown=1000,attackTimer=attackCooldown;

	public Magique(Game game, World world, float x, float y) throws Exception {
		super(game, world, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT);
		bounds.x=8;
		bounds.y=0;
		bounds.width=26;
		bounds.height=28;
		int tx1 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
		int tx2 = (int) (x+ bounds.x) / Tile.TILEWIDTH;
		
		if(0<=this.x && this.x<=968 && 0<=this.y && this.y<=608 && !collisionWithTile(tx1, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx1, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(tx2, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx2, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) )  {
			this.x = x;
			this.y = y;
		   }else {
			x=20;
			y=50;
			tx1 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
			tx2 = (int) (x+ bounds.x) / Tile.TILEWIDTH;
			  if(!collisionWithTile(tx1, (int) (y+ bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx1, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(tx2, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx2, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) ) {
			     System.out.println("Positionnement incorrect du Magique !! donc il est positionné par défaut au point(20,50)");
			  this.x = 20;
			  this.y = 50;}else {
				  this.x = 20;
				  this.y = 50;

				  System.out.println("Position par défaut du magique n'est pas convenable ! ");
			  }
		   }
		
		
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
