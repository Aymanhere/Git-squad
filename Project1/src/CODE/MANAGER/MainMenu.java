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
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import interface_graphique.GrapheParListe;

import javax.swing.SwingConstants;

import CODE.ENTITY.Creature;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.TextArea;

public class MainMenu {

	public JFrame frame;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	    //text
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setBounds(173, 16, 92, 20);
		frame.getContentPane().add(lblNewLabel);
		//buttons
		//n1
		JButton btnNewButton = new JButton("How to play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Hw_play_frame().frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		//n2
		btnNewButton.setBounds(144, 52, 139, 29);
		frame.getContentPane().add(btnNewButton);
		JButton btnNewButton_1= new JButton("Play");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new level_and_design().frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(154, 97, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		JLabel lblNewLabel_3 = new JLabel("");
		Image img= new ImageIcon("textures/heroimg.jpg").getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(125, 160, 185, 68);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Continue");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		

	}
}
