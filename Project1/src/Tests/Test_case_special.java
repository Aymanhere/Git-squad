package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CODE.ENTITY.Entity;
import CODE.ENTITY.Monstre;
import CODE.ENTITY.Piege;
import CODE.ENTITY.Tresor;
import CODE.ENTITY.hero;
import CODE.MANAGER.Game;
import CODE.WORLD.World;
import CODE.WORLD.World3;

class Test_case_special {

	@Test
	void testPiege() {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt");
		Entity piege1=new Piege(game,world,238,60);
		assertEquals(238,piege1.x);
		assertEquals(60,piege1.y);
	}
	@Test
	void testPiegeEffet() {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt");
		hero h1=new hero(game,world,238,60);
		Entity piege1=new Piege(game,world,238,60);
		piege1.tick();
		assertTrue(h1.getCollisionBounds(0,0).intersects(piege1.getCollisionBounds(0,0)));
		System.out.println(h1.health);
		//assert(12,h1.health);
	}
	@Test
	void testTresor() {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt");
		Entity tresor=new Tresor(game,world,945,585);
		assertEquals(945,tresor.x);
		assertEquals(585,tresor.y);
		
	}
	

}
