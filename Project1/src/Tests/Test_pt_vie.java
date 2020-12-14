package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CODE.ENTITY.Monstre;
import CODE.ENTITY.hero;
import CODE.MANAGER.Game;
import CODE.WORLD.World;
import CODE.WORLD.World3;

class Test_pt_vie {
	//hERO
	@Test
	void testPTVIEINITIAL() {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		hero h1=new hero(game,world,1500,1500);
		assertEquals(15,h1.health);
        
	}
	@Test
	void testPTVIE() {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		hero h2=new hero(game,world,1500,1500);
		h2.hurt(1);
		assertEquals(14,h2.health);	

}
	@Test
	void testPTVIEMonster() {
		Game game = new Game("Game",1000,640);
		World world=new World3(game,"res/worlds/worlds3.txt",game.ld);
		Monstre m1= new Monstre(game,world,340,590);
		m1.hurt(1);
		assertEquals(14,m1.health);	
}
}
