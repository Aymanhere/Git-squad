package CODE.MANAGER;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.TextField;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;





import javax.swing.JLabel;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class MainMenu {

	public JFrame frame;
	private Game game;
    

	public MainMenu(Game game) {
		this.game=game;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setBounds(173, 16, 92, 20);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("How to play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.Hw.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
	
		btnNewButton.setBounds(144, 52, 139, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1= new JButton("Play");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.ld.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(154, 97, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		/*JLabel lblNewLabel_3 = new JLabel("");
		Image img= new ImageIcon("textures/heroimg.jpg").getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(125, 160, 185, 68);
		frame.getContentPane().add(lblNewLabel_3);*/
		

	
		

	}
}
