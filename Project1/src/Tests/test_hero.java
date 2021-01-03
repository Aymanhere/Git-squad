package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CODE.ENTITY.hero;
import CODE.MANAGER.Game;
import CODE.WORLD.Tile;
import CODE.WORLD.World;
import CODE.WORLD.World3;

class test_hero {
	//test Right

	@Test
	void testXY() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
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
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		hero h2=new hero(game,world,20,20);
		h2.xMove=-9;//28-9<20 donc collision 
		h2.moveh();
		assertEquals(20,h2.x);
	}
@Test
	void testCollision() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		hero h3=new hero(game,world,20,20);
		h3.xMove=-10;
		h3.moveh();
		assertFalse(h3.checkEntityCollisions(h3.xMove,0f));
		int tx = (int) (h3.x + h3.xMove + h3.bounds.x + h3.bounds.width) / Tile.TILEWIDTH;
		assertFalse(h3.collisionWithTile(tx,(int) (h3.y + h3.bounds.y + h3.bounds.height) / Tile.TILEHEIGHT));
		System.out.println(h3.x);
	}
	@Test
	void testSortie() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		hero h4=new hero(game,world,20,20);
		h4.xMove=-3;
		int tx = (int) (h4.x + h4.xMove + h4.bounds.x) / Tile.TILEWIDTH;
		assertFalse(h4.checkEntityCollisions(h4.xMove,0f));
		assertFalse((h4.collisionWithTile(tx,(int) (h4.y + h4.bounds.y + h4.bounds.height) / Tile.TILEHEIGHT) 
				&& h4.collisionWithTile(tx, (int) (h4.y + h4.bounds.y))));
		//System.out.println(h4.x);
		assertEquals(20,h4.x);
	}
	
	@Test
	 void testyMovenegative() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		hero h5=new hero(game,world,20,20);
		h5.yMove=20;
		h5.moveh();
		h5.yMove=-10;
		h5.moveh();
		//System.out.println(h5.y);
		assertEquals(30,h5.y);
	}
	@Test
	 void testySortie() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		hero h5=new hero(game,world,20,20);
		//h5.yMove=20;
		h5.yMove=-1;
		assertFalse(h5.checkEntityCollisions(0f,h5.yMove));
		int ty = (int) (h5.y + h5.yMove + h5.bounds.y) / Tile.TILEHEIGHT;
		assertTrue(h5.collisionWithTile((int) (h5.x + h5.bounds.x) / Tile.TILEWIDTH, ty) &&
		h5.collisionWithTile((int) (h5.x + h5.bounds.x + h5.bounds.width) / Tile.TILEWIDTH, ty));
		h5.moveh();
		//System.out.println(h5.y);
		assertEquals(20,h5.y);
	}
}
