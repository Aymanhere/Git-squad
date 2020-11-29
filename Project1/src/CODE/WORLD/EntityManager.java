package CODE.WORLD;

import java.awt.Graphics;
import java.util.ArrayList;

import CODE.ENTITY.Entity;
import CODE.ENTITY.hero;
import CODE.MANAGER.Game;
import CODE.WORLD.World;

public class EntityManager {
	
	
	protected Game game;
	protected World world;
	private hero Hero;

	
	private ArrayList<Entity> entities;

	public EntityManager(Game game,World world,hero Hero){
		this.game=game;
		this.world=world;
		this.Hero=Hero;

		entities = new ArrayList<Entity>();

		addEntity(Hero);
	}

	public hero getHero() {
		return Hero;
	}
	public void setHero(hero hero) {
		Hero = hero;
	}
	public void tick(){
		for(int i = 0;i < entities.size();i++){
			Entity e = entities.get(i);
			e.tick();
			if(!e.isActive())
				entities.remove(e);
					
		}
		
	
	}

	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
		Hero.render(g);
		
		
	}

	public void addEntity(Entity e){
		
		entities.add(e);
	}


	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
  


	
}
