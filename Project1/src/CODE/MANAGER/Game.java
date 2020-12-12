package CODE.MANAGER;


import java.awt.Graphics;
import java.awt.image.BufferStrategy;


import CODE.ANIMATION.Assets;
import CODE.STATE.GameState;
import CODE.STATE.MenuState;
import CODE.STATE.State;


public class Game implements Runnable {
	private Display display;
	public String title;
	public int width,height;
	private Thread thread;
	public boolean running=false;
	
	private BufferStrategy bs;
	private Graphics g;

	private State gameState;
	private State menuState;

	private KeyManager keyManager;
	public static boolean P;
	
	
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
		int k=0;
		while(running) {
			if(getKeyManger().pause) {
				P=false;
				k+=1;
				if (k==1){
					new MainMenu().frame.setVisible(true);}
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
				System.out.println("Ticks and Frames: "+ticks);
				ticks=0;
				timer=0;
			}
			
		}
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
