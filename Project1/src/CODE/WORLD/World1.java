package CODE.WORLD;

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

public class World1 extends World{

	public World1(Game game, String path,level_and_design ld) throws Exception {
		super(game, path,ld);
<<<<<<< HEAD
		entityManager=new EntityManager(game,world,new hero(game,world,1000,1500));
		Entity piege=new Piege(game,world,270,60);
=======
		entityManager=new EntityManager(game,world,new hero(game,world,20,20));
		Entity piege=new Piege(game,world,50,100);
>>>>>>> branch 'main' of https://github.com/Aymanhere/ISN_2020_Git_squad.git
		entityManager.addEntity(piege);
		Entity piege1=new Piege(game,world,238,60);
		entityManager.addEntity(piege1);
		Entity piege2=new Piege(game,world,480,90);
		entityManager.addEntity(piege2);
		Entity piege3=new Piege(game,world,390,120);
		entityManager.addEntity(piege3);
		Entity piege4=new Piege(game,world,900,40);
		entityManager.addEntity(piege4);
		Entity piege5=new Piege(game,world,430,240);
		entityManager.addEntity(piege5);
		Entity piege6=new Piege(game,world,80,360);
		entityManager.addEntity(piege6);
		Entity piege7=new Piege(game,world,440,490);
		entityManager.addEntity(piege7);
		Entity piege8=new Piege(game,world,770,468);
		entityManager.addEntity(piege8);
		Entity piege9=new Piege(game,world,830,420);
		entityManager.addEntity(piege9);
		Entity magique=new Magique(game,world,100,200);
		entityManager.addEntity(magique);
		Entity magique2=new Magique(game,world,270,88);
		entityManager.addEntity(magique2);
		Entity magique1=new Magique(game,world,220,525);
		entityManager.addEntity(magique1);
		Entity tresor=new Tresor(game,world,50,50);
		entityManager.addEntity(tresor);
		Entity teleportation=new Teleportation(game,world,80,420,920,368);
		entityManager.addEntity(teleportation);
		Entity teleportation2=new Teleportation(game,world,780,20,140,420);
		entityManager.addEntity(teleportation2);
		Entity teleportation3=new Teleportation(game,world,340,590,40,268);
		entityManager.addEntity(teleportation3);
		Entity teleportation4=new Teleportation(game,world,660,188,400,590);
		entityManager.addEntity(teleportation4);
		Entity teleportation5=new Teleportation(game,world,728,300,100,20);
		entityManager.addEntity(teleportation5);
		Entity teleportation6=new Teleportation(game,world,400,420,840,308);
		entityManager.addEntity(teleportation6);
		Entity monstre1=new Monstre(game,world,200,60);
		entityManager.addEntity(monstre1);
		Entity monstre2=new Monstre(game,world,340,220);
		entityManager.addEntity(monstre2);
		Entity monstre3=new Monstre(game,world,840,120);
		entityManager.addEntity(monstre3);
		Entity monstre4=new Monstre(game,world,400,120);
		entityManager.addEntity(monstre4);
		Entity monstre5=new Monstre(game,world,480,120);
		entityManager.addEntity(monstre5);
		Entity monstre6=new Monstre(game,world,340,590);
		entityManager.addEntity(monstre6);
		Entity monstre7=new Monstre(game,world,80,420);
		entityManager.addEntity(monstre7);
		Entity monstre8=new Monstre(game,world,400,420);
		entityManager.addEntity(monstre8);
		Entity monstre9=new Monstre(game,world,945,585);
		entityManager.addEntity(monstre9);
		Entity fantome=new Fantome(game,world,400,120);
		entityManager.addEntity(fantome);
		Entity fantome1=new Fantome(game,world,945,585);
		entityManager.addEntity(fantome1);
		Entity fantome2=new Fantome(game,world,400,420);
		entityManager.addEntity(fantome2);
		Entity fantome3=new Fantome(game,world,80,420);
		entityManager.addEntity(fantome3);
		Entity fantome4=new Fantome(game,world,340,590);
		entityManager.addEntity(fantome4);
		loadWorld(path);
	}

}
