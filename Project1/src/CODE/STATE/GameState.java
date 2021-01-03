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
		/*File file=new File(path);
		if (!file.exists()) {			
			world=new World1(game,"res/worlds/default_world.txt",game.ld);
			System.out.println("File doesn't exist! Path is by default!");
		}else {*/
			world=new World1(game,path,game.ld);			
		//}
		}
		else if (level_and_design.level==2) {
			
		String path="res/worlds/worlds2.txt";
		File file=new File(path);
		/*if (!file.exists()) {			
			world=new World2(game,"res/worlds/default_world.txt",game.ld);
			System.out.println("File doesn't exist! Path is by default!");
		}else {*/
			world=new World2(game,path,game.ld);			
		//}
		}
		else if (level_and_design.level==3) {
		String path="res/worlds/worlds3.txt";
		File file=new File(path);
		/*if (!file.exists()) {			
			world=new World3(game,"res/worlds/default_world.txt",game.ld);
			System.out.println("File doesn't exist! Path is by default!");
		}else {*/
			world=new World3(game,path,game.ld);			
		//}
		}
		else {
			System.out.println("The level is by default ");
			world=new World1(game,"res/worlds/worlds.txt",game.ld);
		}
		}
		/*Hero=new hero(game,world,100,100);
		monstre=new Monstre(game,world,400,400);
		fantome=new Fantome(game,world,300,300);*/
		
		
	


	@Override
	public void tick() {
		/*Hero.tick();
		monstre.tick();	
		fantome.tick();*/
		world.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		/*Hero.render(g);
		monstre.render(g);
		fantome.render(g);*/

		/*for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				g.drawImage(Assets.grass,j*150,i*150, null);
			}
		}
		
	    g.drawImage(Assets.mur,300,300,50,50, null);
		g.drawImage(Assets.mur,400,200,40,10, null);
		
		g.drawImage(Assets.fantome,500,500,25,25, null);
		g.drawImage(Assets.monstre,90,550,25,25, null);
		g.drawImage(Assets.mur,300,300,50,50, null);
		g.drawImage(Assets.piege,100,100,40,10, null);
		g.drawImage(Assets.magique,550,200,25,25, null);
		g.drawImage(Assets.teleportation_entre,175,356,12,25, null);
		g.drawImage(Assets.teleportation_sortie,500,400,25,12, null);
		g.drawImage(Assets.tresor,400,400,27,20, null);*/
	
		
	}

}
