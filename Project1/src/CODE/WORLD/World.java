package CODE.WORLD;

import java.awt.Graphics;
import java.util.ArrayList;

import CODE.ENTITY.Entity;

import CODE.ENTITY.Fantome;
import CODE.ENTITY.Magique;
import CODE.ENTITY.Monstre;
import CODE.ENTITY.Piege;
import CODE.ENTITY.Teleportation;
import CODE.ENTITY.Tresor;
import CODE.ENTITY.hero;
import CODE.MANAGER.Game;


public class World {
	private static final int width=50,height=32;
	private int[][] tiles;
	private int[][]piege;
	public int spawnX,spawnY;
	protected World world;
	protected Game game;
	private EntityManager entityManager;
	
	public World(Game game,String path) {
		world=this;
		this.game=game;
        
		entityManager=new EntityManager(game,world,new hero(game,world,1500,1500));
		Entity piege=new Piege(game,world,270,60);
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
		Entity tresor=new Tresor(game,world,945,585);
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
		//entityManager.getHero().setX(spawnX);
		//entityManager.getHero().setY(spawnY);
	}

	public int[][] getPiege() {
		return piege;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick() {
		entityManager.tick();
	}
	public void render(Graphics g) {
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				getTile(x,y).render(g, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT);
			}
		}
		entityManager.render(g);
		
	}
	public Tile getTile(int x,int y) {

		Tile t;
        if(0<=x && x<=49 && 0<=y && y<=31) {
		t=Tile.tiles[tiles[x][y]];
        }else {
        	t=null;
        }
		if(t==null) 
			return Tile.grassTile;
		return t;
	}
	public Boolean Bordure(int x,int y) {
		if(x==0 || y==0 || x==19 || y==29) {
			return true;
		}else {
			return false;
		}

	}
	
	public int getId(int x,int y) {
		Tile t;
	
        if(0<=x && x<=width-1 && 0<=y && y<=height-1) {
		t=Tile.tiles[tiles[x][y]];
        }else {
        	t=null;
        }
		if(t==null) 
			return 0;
		return t.id;
	}
	public ArrayList<Integer> getpiege() {
		ArrayList<Integer> piege=new ArrayList<Integer>();
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				if(tiles[i][j]==2) {
					piege.add(i);
					piege.add(j);
			
				}
			}
		}return piege;
		
	}
	private void loadWorld(String path) {
		try {
			String file =Utils.loadFileAsString("res/worlds/worlds.txt");
			String[] tokens=file.split("\\s+");
			tiles=new int[width][height];
			for(int y=0;y<height;y++) {
				for(int x=0;x<width;x++) {
					if(Utils.parseInt(tokens[(x+y*width)])==0 || Utils.parseInt(tokens[(x+y*width)])==1) {
					   tiles[x][y]=Utils.parseInt(tokens[(x+y*width)]);
					}else{
						tiles[x][y]=0;
					}
					}
				}
			
			
		} catch (ArrayIndexOutOfBoundsException e ) {
			tiles=new int[width][height];
			for(int y=0;y<height;y++) {
				for(int x=0;x<width;x++) {
					if(x==0 || x==width-1 || y==0 || y==height-1) {
					tiles[x][y]=1;
					}else {
						tiles[x][y]=0;
					}
				}
			}


		}


		

	}

}
