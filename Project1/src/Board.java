import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener{
	private Timer timer;
	private Map M;
	private Heros p;
	private monster m;
	private magie e;
	private Tresor t;
	private Portaille l1;
	private Portaille l2;
	
	private Piege g;
	public boolean running=false;
	public Board() {
		M=new Map();
		p=new Heros(0,0);
		m=new monster(40,40);
		e= new magie(100,160);
		t= new Tresor(360,340);
		l1= new Portaille(60,120);
		l2= new Portaille(120,360);
		g= new Piege(180,300);
		addKeyListener(new Al());
		setFocusable(true);
		timer = new Timer(25,this);
		timer.start();
	}
	public void run() {
		int fps=60;
		double timePerTick=1000000000/fps;
		double delta=0;
		long now;
		long lastTime= System.nanoTime();
		long timer=0;
		int ticks=0;
		
		//init();
		while(running) {
			now=System.nanoTime();
			delta+=(now -lastTime)/timePerTick;
			timer+=now - lastTime;
			lastTime=now;
			if(delta>=1) {
				m.tick();
				//render(g);
				ticks++;
				delta--;
				
			}
			if(timer>=1000000000) {
				System.out.println("Ticks and Frames: "+ticks);
				ticks=0;
				timer=0;
			}
			
		}
		//stop();
		
	}
	public void render(Graphics g) {
		g.drawImage(m.getMonster(),m.x,m.y, null);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
	}
	public void paint(Graphics graphe) {
		super.paint(graphe);
		for(int y=0; y <20;y++) {
			for(int x=0;x<25;x++) {
				if(M.Mapcoo(x,y).equals("f")) {
					graphe.drawImage(M.getfloor(), x*20, y*20, null);
				}
				if(M.Mapcoo(x,y).equals("w")) {
					graphe.drawImage(M.getwall(), x*20 , y*20, null);
				}	    
			}
		}
	  graphe.drawImage(p.getHeros(), p.x, p.y, null);
	  graphe.drawImage(m.getMonster(), m.x, m.y, null);
	  graphe.drawImage(e.getmagie(),e.x, e.y,null);
	  graphe.drawImage(t.gettresor(),t.x, t.y,null);
	  graphe.drawImage(l1.Portaille(),l1.x, l1.y,null);
	  graphe.drawImage(l2.Portaille(),l2.x, l2.y,null);
	  graphe.drawImage(g.Piege(),g.x, g.y,null);
	}


public class Al extends KeyAdapter{
	public void keyPressed(KeyEvent e) {
		int keycode=e.getKeyCode();
		String command;
		if(keycode==KeyEvent.VK_DOWN) {
			command="D";
			p.move1(command);
		}
		if(keycode==KeyEvent.VK_UP) {
			command="U";
			p.move1(command);
		}
		if(keycode==KeyEvent.VK_LEFT) {
			command="L";
			p.move1(command);
		}
		if(keycode==KeyEvent.VK_RIGHT) {
			command="R";
			p.move1(command);
		}
	}
	public void keyRelased(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
}
public class LogoAnimatorJPanel extends JPanel implements ActionListener {
	 private Timer animationTimer; 
	 public void startAnimation()
	    {
	        animationTimer = new Timer(20, this);
	        animationTimer.start();
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	} 
	
    
	
}

}

