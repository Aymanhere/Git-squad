package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CODE.ENTITY.Monstre;
import CODE.ENTITY.hero;
import CODE.MANAGER.Game;
import CODE.WORLD.World;
import CODE.WORLD.World1;
import CODE.WORLD.World3;

class Test_pt_vie {
	//hERO
	@Test
	void testPTVIEINITIAL() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World1(game,"res/worlds/worlds.txt",game.ld);
		hero h1=new hero(game,world,20,20);
		assertEquals(15,h1.health);
        
	}
	@Test
	void testPTVIE() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World1(game,"res/worlds/worlds.txt",game.ld);
		hero h2=new hero(game,world,20,20);
		h2.hurt(1);
		assertEquals(14,h2.health);	

}
	@Test
	void testPTVIEMonster() throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World1(game,"res/worlds/worlds.txt",game.ld);
		Monstre m1= new Monstre(game,world,340,200);
		m1.hurt(1);
		assertEquals(14,m1.health);	
}
}
