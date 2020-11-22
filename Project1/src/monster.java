import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class monster extends Fantome {
	private Image mons;
	private Animation animmonstre;
	private Animation attackmonstre;
	private long lastTime=System.currentTimeMillis(),timer=0;
	private int a=(int) (Math.random()*9);
	private int b=(int) (Math.random()*9);
	private int c=(int) (Math.random()*9);

	monster(int x1, int y1) {
		super(x1, y1);
		// TODO Auto-generated constructor stub
		ImageIcon img= new ImageIcon(getClass().getResource("pp.jpg"));
		mons=img.getImage();
		animmonstre=new Animation(500,mons);
		attackmonstre=new Animation(500,mons);
		moveM();
	}
	public void tick() {
		animmonstre.tick();
		attackmonstre.tick();
		move();
		getInput();
		
	}
	private void getInput() {

		xMove=0;
		yMove=0;
		int[] L={-1,1,-1,-1,1,0,-1,1,0};
		timer+=System.currentTimeMillis() - lastTime;
		int[] T= {1000,2000,3000,4000,5000,1500,3500,4500,2500};
		
		if(timer>T[c]) {
		a=(int) (Math.random()*9);
		b=(int) (Math.random()*9);
		c=(int) (Math.random()*9);
		timer=0;
		}
		xMove=L[a]*speed;
		
		yMove=L[b]*speed;
		
		

		
		
		lastTime=System.currentTimeMillis();

	}
	public void moveM(){
			x=x+(int)((Math.random())*3);
		    y=x+(int)((Math.random())*3);
		    System.out.println(x);
		}
	public Image getMonster() {
		return mons;
	}
	
	
}
