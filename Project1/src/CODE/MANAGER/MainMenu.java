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
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class MainMenu {

	public JFrame frame;
	private Game game;
    

	public MainMenu(Game game) {
		this.game=game;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/textures/HERO.png")));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 500);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);  
		frame.getContentPane().setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("||Welcome To \r\nGitsquadGame||");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("ROG Fonts", Font.BOLD, 25));
		lblNewLabel.setBounds(41, 0, 510, 124);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("How to play");
		btnNewButton.setFont(new Font("ROG Fonts", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.Hw.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
	
		btnNewButton.setBounds(342, 255, 209, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1= new JButton("Play");
		btnNewButton_1.setFont(new Font("ROG Fonts", Font.BOLD, 16));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.ld.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(26, 255, 209, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainMenu.class.getResource("/textures/HERO.png")));
		lblNewLabel_1.setBounds(223, 109, 140, 116);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("ROG Fonts", Font.BOLD, 16));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(207, 339, 186, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		/*JLabel lblNewLabel_3 = new JLabel("");
		Image img= new ImageIcon("textures/heroimg.jpg").getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(125, 160, 185, 68);
		frame.getContentPane().add(lblNewLabel_3);*/
		

	
		

	}
}
