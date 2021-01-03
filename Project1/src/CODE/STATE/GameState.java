package CODE.STATE;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;

import CODE.ENTITY.Entity;
import CODE.ENTITY.Fantome;
import CODE.ENTITY.Magique;
import CODE.ENTITY.Monstre;
import CODE.ENTITY.Piege;
import CODE.ENTITY.Teleportation;
import CODE.ENTITY.Tresor;
import CODE.ENTITY.hero;
import CODE.MANAGER.Game;
import CODE.MANAGER.level_and_design;
import CODE.WORLD.EntityManager;
import CODE.WORLD.World;
import CODE.WORLD.World1;
import CODE.WORLD.World2;
import CODE.WORLD.World3;

public class GameState extends State {

	protected World world;
	
	public GameState(Game game) throws Exception {
		super(game);
		if (level_and_design.level==1) {
		String path="res/worlds/worlds.txt";

			world=new World1(game,path,game.ld);			
	
		}
		else if (level_and_design.level==2) {
			
		String path="res/worlds/worlds2.txt";

			world=new World2(game,path,game.ld);			
	
		}
		else if (level_and_design.level==3) {
		String path="res/worlds/worlds3.txt";

			world=new World3(game,path,game.ld);			

		}
		else {
			System.out.println("The level is by default ");
			world=new World1(game,"res/worlds/worlds.txt",game.ld);
		}
		}

			


	@Override
	public void tick() {

		world.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	

	
		
	}

}
