

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed,index;
	Image frames;
	private long lastTime,timer;
	
	public Animation(int speed,Image frames) {
		this.speed=speed;
		this.frames=frames;
		index=0;
		timer=0;
		lastTime=System.currentTimeMillis();
	}
	public void tick() {
		timer+=System.currentTimeMillis() - lastTime;
		lastTime=System.currentTimeMillis();
		if(timer>speed) {
			timer=0;
			
		}
	}
 
    	 
     }

