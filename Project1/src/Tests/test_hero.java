package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CODE.ENTITY.hero;
import CODE.MANAGER.Game;
import CODE.WORLD.Tile;
import CODE.WORLD.World;
import CODE.WORLD.World1;
import CODE.WORLD.World3;

class test_hero {
	//test Right

	@Test
	void testXY() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World1(game,"res/worlds/worlds.txt",game.ld);
		hero h1=new hero(game,world,20,20);
		h1.xMove=15;
		h1.moveh();
		assertEquals(35,h1.x);
		h1.yMove=17;
		h1.moveh();
		assertEquals(37,h1.y);
	}
	@Test
	void testXnegative() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World1(game,"res/worlds/worlds.txt",game.ld);
		hero h2=new hero(game,world,20,20);
		h2.xMove=-9;//28-9<20 donc collision 
		h2.moveh();
		assertEquals(20,h2.x);
	}
@Test
	void testCollision() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World1(game,"res/worlds/worlds.txt",game.ld);
		hero h3=new hero(game,world,20,20);
		h3.xMove=-10;
		h3.moveh();
		assertTrue(h3.checkEntityCollisions(h3.xMove,0f));
		int tx = (int) (h3.x + h3.xMove + h3.bounds.x + h3.bounds.width) / Tile.TILEWIDTH;
		//assertFalse(h3.collisionWithTile(tx,(int) (h3.y + h3.bounds.y + h3.bounds.height) / Tile.TILEHEIGHT));
		System.out.println(h3.x);
	}
	
	
	@Test
	 void testyMovenegative() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World1(game,"res/worlds/worlds.txt",game.ld);
		hero h5=new hero(game,world,20,20);
		h5.moveh();
		h5.yMove=-10;
		h5.moveh();
		assertEquals(20,h5.y);
	}
}
	