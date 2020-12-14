package CODE.WORLD;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import CODE.ANIMATION.Assets;
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


public abstract class World {
	protected static final int width=50,height=32;
	protected int[][] tiles;
	protected int[][]piege;
	protected World world;
	protected Game game;
	public EntityManager entityManager;
	String file;
	private  String path;
    public  Tile grassTile;
    public  Tile murTile;
	private level_and_design ld;
	
	public World(Game game,String path,level_and_design ld) {
		world=this;
		this.game=game;
		this.path=path;
		this.ld=ld;
		if(ld.design==1) {
			grassTile=new Tile(Assets.floor,0);
			murTile=new Tile(Assets.mur,1);
		}else {
			grassTile=new Tile(Assets.floor1,0);
			murTile=new Tile(Assets.mur1,1);
		}
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
			return grassTile;
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
	public void loadWorld(String path) {
		try {
			
			file =Utils.loadFileAsString(path);
			 String [] tokens=file.split("[,; \\s \t\n\r]+");
            if(tokens.length>width*height) {
            	String[] a= {};
            	tokens=a;
            }
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
			System.out.println("le monde est généré par défaut");
			file =Utils.loadFileAsString("res/worlds/default_world.txt");
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


		}


		

	}

}
