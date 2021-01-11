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
		loadWorld(path);
		entityManager=new EntityManager(game,world,new hero(game,world,20,20));
		Entity tresor=new Tresor(game,world,945,585);
		entityManager.addEntity(tresor);
		Entity teleportation=new Teleportation(game,world,310,140,710,140);
		entityManager.addEntity(teleportation);
		Entity teleportation1=new Teleportation(game,world,930,140,800,490);
		entityManager.addEntity(teleportation1);
		Entity magique1=new Magique(game,world,810,140);
		entityManager.addEntity(magique1);
		Entity piege=new Piege(game,world,810,70);
		entityManager.addEntity(piege);
		Entity monstre1=new Monstre(game,world,310,70);
		entityManager.addEntity(monstre1);
		Entity fantome2=new Fantome(game,world,160,70);
		entityManager.addEntity(fantome2);
		Entity fantome=new Fantome(game,world,450,40);
		entityManager.addEntity(fantome);
		Entity fantome1=new Fantome(game,world,500,40);
		entityManager.addEntity(fantome1);
		Entity monstre3=new Monstre(game,world,550,20);
		entityManager.addEntity(monstre3);
		Entity monstre4=new Monstre(game,world,570,20);
		entityManager.addEntity(monstre4);
		

		
	}

}
