package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import CODE.ENTITY.Entity;
import CODE.ENTITY.Monstre;
import CODE.ENTITY.Piege;
import CODE.ENTITY.hero;
import CODE.MANAGER.Game;
import CODE.WORLD.World;
import CODE.WORLD.World1;
import CODE.WORLD.World3;

class Test_Monstre {

	@Test
	void testPositionMonstre() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World1(game,"res/worlds/worlds3.txt",game.ld);
		hero h1=new hero(game,world,238,60);
		Entity monstre1=new Monstre(game,world,200,60);
		assertEquals(200,monstre1.x);
		assertEquals(60,monstre1.y);
	
	}
	
	@Test
	void testCollisionMonstre() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		hero h1=new hero(game,world,240,100);
		//32-29=3
		//29+51=80 on avance par 1 pixel on obtient la collision
		//rectangle dans (180,80)
		//en haut YM_29
		//en bas YM+20+31
		//en gauche XM-21-8-15
		//à la droite XM+42
		Monstre monstre1=new Monstre(game,world,200,100);
		world.getEntityManager().setHero(h1);
		monstre1.checkAttacks();
		assertTrue(monstre1.Attack);
	}
	@Test
	void testEffetMonstre() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		hero h1=new hero(game,world,240,100);
		//32-29=3
		//29+51=80 on avance par 1 pixel on obtient la collision
		//rectangle dans (180,80)
		//en haut YM_29
		//en bas YM+20+31
		//en gauche XM-21-8-15
		//à la droite XM+42
		Monstre monstre1=new Monstre(game,world,200,100);
		world.getEntityManager().setHero(h1);
		assertEquals(15,h1.health);
		monstre1.checkAttacks();
		assertEquals(14,h1.health);
	}
	
}