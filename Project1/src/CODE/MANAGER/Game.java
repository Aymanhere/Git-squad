package CODE.MANAGER;


import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;


import CODE.ANIMATION.Assets;
import CODE.STATE.GameState;
import CODE.STATE.MenuState;
import CODE.STATE.State;



public class Game implements Runnable {
	public Display display;
	public String title;
	public int width,height;
	private Thread thread;
	public boolean running=false;
	int k=0;
	private BufferStrategy bs;
	private Graphics g;
	public int on=0;

	private State gameState;
	private State menuState;

	private KeyManager keyManager;
	public  boolean P;
	public level_and_design ld=new level_and_design(this);
	public MainMenu window=new MainMenu(this);
	public Hw_play_frame  Hw=new Hw_play_frame(this);
	public Frame_continue continu=new Frame_continue(this);

	
	
	
	public Game(String title, int width,int height) {
		P=true;
		this.width=width;
		this.height=height;
		this.title=title;
		keyManager=new KeyManager();
		
		
	}
	private void init() {
		display=new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState=new GameState(this);
		menuState=new MenuState(this);
		State.setState(gameState);
		
	}

	private void tick() {
		keyManager.tick();
		if(State.getState() !=null) {
			State.getState().tick();
		}
	
		
	}
	private void render(){
		
		bs=display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g=bs.getDrawGraphics();
		//clear Screen
		g.clearRect(0, 0, width, height);
		//Draw here
		if(State.getState()!=null)
			State.getState().render(g);
        
       		
		//END DRAW
		bs.show();
		g.dispose();
		
		
	}
	public void run() {
		int fps=60;
		double timePerTick=1000000000/fps;
		double delta=0;
		long now;
		long lastTime= System.nanoTime();
		long timer=0;
		int ticks=0;
		
		init();
		while(running) {
			on+=1;
			if(getKeyManger().pause) {
				keyManager.keys[KeyEvent.VK_P]=false;
				this.P=false;
				if (k==0){	
					continu.frame.setVisible(true);
					}
				k+=1;
			}
			else if (Frame_continue.con) {
			   continu.frame.setVisible(false);
			   this.P=true;
			   Frame_continue.con=false;
			    k=0;
			}
			now=System.nanoTime();
			delta+=(now -lastTime)/timePerTick;
			timer+=now - lastTime;
			lastTime=now;
			if(delta>=1) {
				tick();
				render();
				ticks++;
				delta--;
				
			}
			if(timer>=1000000000) {
				//System.out.println("Ticks and Frames: "+ticks);
				ticks=0;
				timer=0;
			}
			
		}
		on=0;
		stop();
		
	}
	public KeyManager getKeyManger() {
		return keyManager;
	}
	public synchronized void start() {
		if(running)
			return;
		running=true;
		thread=new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running)
			return;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static void main( String[] args) {

	}

}
