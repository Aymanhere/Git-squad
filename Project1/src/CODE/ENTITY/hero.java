package CODE.ENTITY;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import CODE.ANIMATION.Animation;
import CODE.ANIMATION.Assets;
import CODE.MANAGER.Frame_continue;
import CODE.MANAGER.Game;
import CODE.MANAGER.MainMenu;
import CODE.WORLD.Tile;
import CODE.WORLD.World;

public class hero extends Creature{

	private Animation animdown;
	private Animation animup;
	private Animation animright;
	private Animation animleft;
	private Animation animhealth;
	private int timetick=0;
	
	private long lastAttackTimer,attackCooldown=100,attackTimer=attackCooldown;
	


	public hero(Game game,World world,float x, float y) throws Exception {
		super(game,world,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        
		bounds.x=8;
		bounds.y=0;
		bounds.width=15;
		bounds.height=29;
		int tx1 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
		int tx2 = (int) (x+ bounds.x) / Tile.TILEWIDTH;
		
		if(0<=this.x && this.x<=968 && 0<=this.y && this.y<=608 && !collisionWithTile(tx1, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx1, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(tx2, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx2, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))  {
			this.x = x;
			this.y = y;
		   }else {
			x=20;
			y=20;
			tx1 = (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH;
			tx2 = (int) (x+ bounds.x) / Tile.TILEWIDTH;
			  if(!collisionWithTile(tx1, (int) (y+ bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx1, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && !collisionWithTile(tx2, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx2, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) ) {
			     System.out.println("Positionnement incorrect du hero !! donc il est positionné par défaut au point(20,20)");
			  this.x = 20;
			  this.y = 20;}else {
				  this.x = 20;
				  this.y = 20;

				  System.out.println("Position par défaut du hero n'est pas convenable ! ");
			  }
		   }
		
		animhealth=new Animation(500,Assets.health);
		animdown=new Animation(500,Assets.hero_down);
		animup=new Animation(500,Assets.hero_up);
		animright=new Animation(500,Assets.hero_right);
		animleft=new Animation(500,Assets.hero_left);
		

	}
	
	public void moveh(){
		int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
		int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
		if(!checkEntityCollisions(xMove,0f) && tx!=0 && tx!=50)
		    moveXh();
		if(!checkEntityCollisions(0f,yMove)&& ty!=0 && ty!=30)
		    moveYh();
	}
	private void getInput() {
		xMove=0;
		yMove=0;
		if(game.getKeyManger().up) 
			yMove=-speed;
		if(game.getKeyManger().down) 
			yMove=+speed;
		if(game.getKeyManger().left) 
			xMove=-speed;
		if(game.getKeyManger().right) 
			xMove=+speed;		
	}

	public void moveXh(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
 
				if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
						!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
			
						x += xMove;
				}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else if(tx==50) {
				xMove=0;
			}
		}
	}

	public void moveYh(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				
				y += yMove;
			}
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}
		}
	}


	private void checkAttacks() {
		attackTimer+=System.currentTimeMillis()-lastAttackTimer;
		lastAttackTimer=System.currentTimeMillis();
		if(attackTimer<attackCooldown)
			return;
		Rectangle cb=getCollisionBounds(0,0);
		Rectangle ar=new Rectangle();
		int arSize_w=20;
		int arSize_h=10;
		ar.width=arSize_w;
		ar.height=arSize_h;
		if(game.getKeyManger().attack_up) {
			ar.x=cb.x+cb.width/2 -arSize_w/2;
			ar.y=cb.y-arSize_h;
			
			
		}
		else if(game.getKeyManger().attack_down) {
			ar.x=cb.x+cb.width/2 -arSize_w/2;
			ar.y=cb.y+cb.height;
		}
		else if(game.getKeyManger().attack_left) {
			ar.x=cb.x-arSize_w;
			ar.y=cb.y+cb.width/2 -arSize_h/2;
		}
		else if(game.getKeyManger().attack_right) {
			ar.x=cb.x+cb.width;
			ar.y=cb.y+cb.height/2 -arSize_h/2;
		}else{
			return;
		}
		attackTimer=0;
		for(Entity e:world.getEntityManager().getEntities()) {
			Class<StaticEntity> statics=StaticEntity.class;
			if(e.equals(this) || statics.isInstance(e)) 
				continue;
			if(e.getCollisionBounds(0,0).intersects(ar)) {
				e.hurt(1);
				return;
			}
		}
		
		
	}


	
	private BufferedImage getCurrentAnimationFrame() {
		if(health>0) {
		if(xMove<0) {
			return animleft.getCurrentFrame();
		}else if(xMove>0){
			return animright.getCurrentFrame();
		}else if(yMove<0) {
			return animup.getCurrentFrame();
		}else if(yMove>0) {
			return animdown.getCurrentFrame();
		}else if(game.getKeyManger().attack_right) {
			 return Assets.attack_right;
			
		}else if(game.getKeyManger().attack_left) {
			return Assets.attack_left;
		}else if(game.getKeyManger().attack_down) {
			return Assets.attack_down;
		}else if(game.getKeyManger().attack_up) {
			return Assets.attack_up;
		}else {
			return Assets.hero;
		}}else {
			return Assets.die;
		}
			
		}

	private BufferedImage getCurrenthealth() {
		if(health==15) {
			return animhealth.getFrames(0);
		}else if(health==14){
			return animhealth.getFrames(1);
		}else if(health==13){
			return animhealth.getFrames(2);
		}else if(health==12){
			return animhealth.getFrames(3);
		}else if(health==11){
			return animhealth.getFrames(4);	
		}else if(health==10){
			return animhealth.getFrames(5);
		}else if(health==9){
			return animhealth.getFrames(6);
		}else if(health==8){
			return animhealth.getFrames(7);
		}else if(health==7){
			return animhealth.getFrames(8);
		}else if(health==6){
			return animhealth.getFrames(9);
		}else if(health==5){
			return animhealth.getFrames(10);
		}else if(health==4){
			return animhealth.getFrames(11);
		}else if(health==3){
			return animhealth.getFrames(12);
		}else if(health==2){
			return animhealth.getFrames(13);
		}else if(health==1){
			return animhealth.getFrames(14);
		}else {
			return animhealth.getFrames(15);
			
		}
		
	    
	}
	

	@Override
	public void tick() {
			/*if(game.getKeyManger().pause) {
				game.P=false;
			}
			if (Frame_continue.con) {
				game.P=true;
			}*/
		if (game.P) {
		animhealth.tick();
		animdown.tick();
		animup.tick();
		animright.tick();
		animleft.tick();
		getInput();
		moveh();
		checkAttacks();
		isdead();
		}
	
		
	}
	public void isdead() {
	if (health<=0) {
		game.P=false;
		game.lose.frame.setVisible(true);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) x,(int) y,width,height, null);
		g.drawImage(getCurrenthealth(),(int) x,(int) y-10,width,10, null);
		//g.setColor(Color.red);
	 	//g.fillRect((int)(x+bounds.x+8-10),(int)(y+bounds.y+29),20,10);
	}

}


