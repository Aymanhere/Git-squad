package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CODE.ENTITY.Entity;
import CODE.ENTITY.Magique;
import CODE.ENTITY.Monstre;
import CODE.ENTITY.Piege;
import CODE.ENTITY.StaticEntity;
import CODE.ENTITY.Teleportation;
import CODE.ENTITY.Tresor;
import CODE.ENTITY.hero;
import CODE.MANAGER.Game;
import CODE.WORLD.World;
import CODE.WORLD.World3;

class Test_case_special {

	@Test
	void testPiege() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		Entity piege1=new Piege(game,world,238,60);
		assertEquals(238,piege1.x);
		assertEquals(60,piege1.y);
	}
	@Test
	void testCollisionPiege() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		hero h1=new hero(game,world,238,60);
		Entity piege1=new Piege(game,world,238,60);
		assertTrue(h1.getCollisionBounds(0,0).intersects(piege1.getCollisionBounds(0,0)));
	}
	@Test
	void testPiegeEffect() throws Exception {
		Game game2 = new Game("Game",1000,640);
		World world2=new World3(game2,"res/worlds/worlds3.txt",game2.ld);
		hero h2=new hero(game2,world2,238,60);
		world2.getEntityManager().setHero(h2);
		Entity piege2=new Piege(game2,world2,238,60);
		assertTrue(world2.getEntityManager().getHero().getCollisionBounds(0,0).intersects(piege2.getCollisionBounds(0,0)));
		piege2.tick();
		assertEquals(14,h2.health);
	    }
	@Test
	void testTresor() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		Entity tresor=new Tresor(game,world,945,585);
		assertEquals(945,tresor.x);
		assertEquals(585,tresor.y);
	}
	
	@Test
	void testEFFECTTeleportation() throws Exception {
		Game game2 = new Game("Game",1000,640);
		World world2=new World3(game2,"res/worlds/worlds3.txt",game2.ld);
		hero h2=new hero(game2,world2,238,60);
		world2.getEntityManager().setHero(h2);
		Entity teleportation2=new Teleportation(game2,world2,238,60,35,40);
		assertEquals(238,teleportation2.x);
		assertEquals(60,teleportation2.y);
		assertTrue(world2.getEntityManager().getHero().getCollisionBounds(0,0).intersects(teleportation2.getCollisionBounds(0,0)));
		teleportation2.tick();
		assertEquals(35,h2.x);
		assertEquals(40,h2.y);
	    }
	
	@Test
	void testEFFECTMagic() throws Exception {
		Game game3 = new Game("Game",1000,640);
		World world3=new World3(game3,"res/worlds/worlds3.txt",game3.ld);
		hero h3=new hero(game3,world3,200,30);
		world3.getEntityManager().setHero(h3);
		Entity magic=new Magique(game3,world3,200,30);
		assertEquals(200,magic.x);
		assertEquals(30,magic.y);
		assertTrue(world3.getEntityManager().getHero().getCollisionBounds(0,0).intersects(magic.getCollisionBounds(0,0)));
		magic.tick();
		assertEquals(15,h3.health);
		h3.health=10;
		magic.tick();
		assertEquals(11,h3.health);
	    }
	
	
	

}