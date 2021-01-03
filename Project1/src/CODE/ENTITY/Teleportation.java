package CODE.ENTITY;

import java.awt.Graphics;

import CODE.ANIMATION.Assets;
import CODE.MANAGER.Game;
import CODE.WORLD.Tile;
import CODE.WORLD.World;

public class Teleportation extends StaticEntity{

        private int a,b;

		public Teleportation(Game game, World world, float x, float y,int a,int b) throws Exception {
			super(game, world, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT);
			this.a=a;
			this.b=b;
			bounds.x=8;
			bounds.y=0;
			bounds.width=26;
			bounds.height=28;
			
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
			g.drawImage(Assets.teleportation_sortie,a,b,null);
		}

		



}
