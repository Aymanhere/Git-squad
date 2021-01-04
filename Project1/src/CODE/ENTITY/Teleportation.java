package CODE.ENTITY;

import java.awt.Graphics;

import CODE.ANIMATION.Assets;
import CODE.MANAGER.Game;
import CODE.WORLD.Tile;
import CODE.WORLD.World;

public class Teleportation extends StaticEntity{

        private float a,b;

		public Teleportation(Game game, World world, float x, float y,float a,float b) throws Exception {
			super(game, world, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT);
			this.a=a;
			this.b=b;
			bounds.x=8;
			bounds.y=0;
			bounds.width=26;
			bounds.height=28;
			int tx1 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
			int tx2 = (int) (x+ bounds.x) / Tile.TILEWIDTH;
			int txa = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
			int txb = (int) (x+ bounds.x) / Tile.TILEWIDTH;
			
			if(0<=this.x && this.x<=968 && 0<=this.y && this.y<=608 && 0<=this.a && this.a<=968 && 0<=this.b && this.b<=608 && !collisionWithTile(tx1, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx1, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(tx2, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx2, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) 
					&& !collisionWithTile(txa, (int) (b + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(txa, (int) (b + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(txb, (int) (b + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(txb, (int) (b + bounds.y + bounds.height) / Tile.TILEHEIGHT))  {
				this.x = x;
				this.y = y;
				this.a=a;
				this.a=b;
			   }else {
				x=20;
				y=560;
				a=60;
				b=560;
				tx1 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
				tx2 = (int) (x+ bounds.x) / Tile.TILEWIDTH;
				txa = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
				txb = (int) (x+ bounds.x) / Tile.TILEWIDTH;
				  if(!collisionWithTile(tx1, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
							!collisionWithTile(tx1, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(tx2, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
							!collisionWithTile(tx2, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) 
							&& !collisionWithTile(txa, (int) (b + bounds.y) / Tile.TILEHEIGHT) &&
							!collisionWithTile(txa, (int) (b + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(txb, (int) (b + bounds.y) / Tile.TILEHEIGHT) &&
							!collisionWithTile(txb, (int) (b + bounds.y + bounds.height) / Tile.TILEHEIGHT))  {
				     System.out.println("Positionnement incorrect du teleportation !! donc il est positionné par défaut au point(20,560,60,560)");
						this.x = 20;
						this.y = 560;
						this.a=60;
						this.b=560;}else {
							this.x = 20;
							this.y = 560;
							this.a=60;
							this.b=560;

					  System.out.println("Position par défaut du teleportation n'est pas convenable ! ");
				  }
			   }
			
			
		}

		@Override
		public void tick() {
		teleportation();
			
		}
	public void teleportation() {
		if((world.getEntityManager().getHero().getCollisionBounds(0,0).intersects(this.getCollisionBounds(0,0)))) {
			world.getEntityManager().getHero().x=a;
			world.getEntityManager().getHero().y=b;
			
			}
}
		
			
		
	
		@Override
		public void render(Graphics g) {
			g.drawImage(Assets.teleportation_entre,(int)x,(int) y,null);
			g.drawImage(Assets.teleportation_sortie,(int)a,(int)b,null);
		}

		



}
