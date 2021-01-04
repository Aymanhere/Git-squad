package CODE.ENTITY;

import java.awt.Graphics;

import CODE.ANIMATION.Animation;
import CODE.ANIMATION.Assets;
import CODE.MANAGER.Game;
import CODE.WORLD.Tile;
import CODE.WORLD.World;

public class Tresor extends StaticEntity {

	private Animation win;
	private int timetick=0;
	private long lasttimer, cooldown=2000,timer=cooldown;
	public Tresor(Game game, World world, float x, float y) throws Exception {
		super(game, world, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT);
		bounds.x=8;
		bounds.y=0;
		bounds.width=32;
		bounds.height=28;
		win=new Animation(500,Assets.win);
		int tx1 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
		int tx2 = (int) (x+ bounds.x) / Tile.TILEWIDTH;
		
		if(0<=this.x && this.x<=968 && 0<=this.y && this.y<=608 && !collisionWithTile(tx1, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx1, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(tx2, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx2, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) )  {
			this.x = x;
			this.y = y;
		   }else {
			x=880;
			y=560;
			tx1 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
			tx2 = (int) (x+ bounds.x) / Tile.TILEWIDTH;
			  if(!collisionWithTile(tx1, (int) (y+ bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx1, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(tx2, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx2, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) ) {
			     System.out.println("Positionnement incorrect du Tresor !! donc il est positionné par défaut au point(880,560)");
			  this.x = 880;
			  this.y = 560;}else {
				  this.x = 880;
				  this.y = 560;

				  System.out.println("Position par défaut du trésor n'est pas convenable ! ");
			  }
		   }
		
		
	}

	@Override
	public void tick() {
		win.tick();
		win();
	}
	public void win() {
		if((world.getEntityManager().getHero().getCollisionBounds(0,0).intersects(this.getCollisionBounds(0,0)))) {
			/*timer+=System.currentTimeMillis()-lasttimer;
			lasttimer=System.currentTimeMillis();
			if(timer>cooldown) {
			game.continu.frame.setVisible(true);
			game.P=false;
			}*/
			game.P=false;
			timetick+=1;
			if (timetick>50){
				game.Win.frame.setVisible(true);
				timetick=0;
			}
		}
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tresor,(int)x,(int) y,null);
		if((world.getEntityManager().getHero().getCollisionBounds(0,0).intersects(this.getCollisionBounds(0,0))))
		g.drawImage(win.getCurrentFrame(),400,200,null);
	}
	


	


}

