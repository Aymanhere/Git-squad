package CODE.MANAGER;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame_continue {

	public JFrame frame;
	public static boolean con=false;
    private Game game;
	public Frame_continue(Game game) {
		this.game=game;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnNewButton = new JButton("How to play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.Hw.frame.setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		//n2
		btnNewButton.setBounds(144, 52, 139, 29);
		frame.getContentPane().add(btnNewButton);
		Image img= new ImageIcon("textures/heroimg.jpg").getImage();
		
		JButton btnNewButton_2 = new JButton("Continue");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				con=true;
			}
		});
		frame.getContentPane().setLayout(null);
		btnNewButton_2.setBounds(144, 150, 139, 50);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    frame.setVisible(false);
				    game.display.frame.setVisible(false);
				    game.running=false;
				    game=new Game("Game",1000,640);
				    game.window.frame.setVisible(true);
				    
				
			}
		});
		btnNewButton_1.setBounds(144, 89, 139, 45);
		frame.getContentPane().add(btnNewButton_1);
	}
}
