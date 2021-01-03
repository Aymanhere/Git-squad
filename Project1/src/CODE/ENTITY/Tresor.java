package CODE.ENTITY;

import java.awt.Graphics;

import CODE.ANIMATION.Animation;
import CODE.ANIMATION.Assets;
import CODE.MANAGER.Game;
import CODE.WORLD.Tile;
import CODE.WORLD.World;

public class Tresor extends StaticEntity {

	private long lastAttackTimer,attackCooldown=1000,attackTimer=attackCooldown;
	private Animation win;

	public Tresor(Game game, World world, float x, float y) throws Exception {
		super(game, world, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT);
		bounds.x=8;
		bounds.y=0;
		bounds.width=32;
		bounds.height=28;
		win=new Animation(500,Assets.win);
		
	}

	@Override
	public void tick() {
	win.tick();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tresor,(int)x,(int) y,null);
		if((world.getEntityManager().getHero().getCollisionBounds(0,0).intersects(this.getCollisionBounds(0,0))))
		g.drawImage(win.getCurrentFrame(),400,200,null);
	}
	


	


}

