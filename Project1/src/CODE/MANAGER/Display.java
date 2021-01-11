package CODE.MANAGER;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Display {

	public JFrame frame;
	private Canvas canvas;
	private String title;
	private int width,height;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Display(String title,int width,int height) {
			this.title=title;
			this.width=width;
			this.height=height;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame=new JFrame(title);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Display.class.getResource("/textures/HERO.png")));
		frame.setSize(width,height);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setVisible(true);	
		
		canvas= new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);		
		
		frame.getContentPane().add(canvas);
		frame.pack();
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public JFrame getFrame(){
		return frame;
	}
	

	}


