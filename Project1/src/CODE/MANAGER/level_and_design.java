package CODE.MANAGER;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import CODE.ANIMATION.Assets;
import CODE.WORLD.Tile;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;

public class level_and_design {
    public static  int level=1;
    public  int design=1;
	protected JFrame frame;
    private Game game;
    private final Action action = new SwingAction();
    private final Action action_1 = new SwingAction_1();
    private final Action action_2 = new SwingAction_2();
    private final Action action_3 = new SwingAction_3();
    private final Action action_4 = new SwingAction_4();


	public level_and_design(Game game) {
		this.game=game;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(level_and_design.class.getResource("/textures/HERO.png")));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 600, 500);
		frame.setLocationRelativeTo(null);  
		frame.setUndecorated(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("||Choose your game||");
		lblNewLabel.setIcon(null);
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("ROG Fonts", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(74, 16, 443, 74);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setForeground(new Color(255, 102, 0));
		btnNewButton.setFont(new Font("ROG Fonts", Font.PLAIN, 28));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				game.start(); 
				frame.setVisible(false);
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setIcon(new ImageIcon(level_and_design.class.getResource("/textures/fire3.png")));
		lblNewLabel_1.setBounds(200, 315, 194, 85);
		frame.getContentPane().add(lblNewLabel_1);
		btnNewButton.setBounds(190, 296, 219, 55);
		frame.getContentPane().add(btnNewButton);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton = new JRadioButton("level 1");
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setEnabled(false);
		rdbtnNewRadioButton.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton.setFont(new Font("ROG Fonts", Font.BOLD, 20));
		rdbtnNewRadioButton.setAction(action_1);
		rdbtnNewRadioButton.setBounds(52, 128, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton);
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("level 3");
		rdbtnNewRadioButton_1.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_1.setFont(new Font("ROG Fonts", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setAction(action_2);
		rdbtnNewRadioButton_1.setBounds(52, 250, 155, 34);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_1);
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("level 2");
		rdbtnNewRadioButton_2.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_2.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_2.setFont(new Font("ROG Fonts", Font.BOLD, 20));
		rdbtnNewRadioButton_2.setAction(action);
		rdbtnNewRadioButton_2.setBounds(52, 191, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_2);
		ButtonGroup buttonGroup2 = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Glass Floor");
		rdbtnNewRadioButton_3.setForeground(new Color(0, 191, 255));
		rdbtnNewRadioButton_3.setFont(new Font("ROG Fonts", Font.BOLD, 20));
		rdbtnNewRadioButton_3.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_3.setAction(action_3);
		rdbtnNewRadioButton_3.setBounds(319, 162, 219, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		buttonGroup2.add(rdbtnNewRadioButton_3);
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Grass Floor");
		rdbtnNewRadioButton_4.setForeground(new Color(0, 100, 0));
		rdbtnNewRadioButton_4.setFont(new Font("ROG Fonts", Font.BOLD, 20));
		rdbtnNewRadioButton_4.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_4.setAction(action_4);
		rdbtnNewRadioButton_4.setBounds(319, 212, 219, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		buttonGroup2.add(rdbtnNewRadioButton_4);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("ROG Fonts", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game. window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(239, 399, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Level 2");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			level=2;
		}
		
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Level 1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			level=1;
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "level 3");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			level=3;
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Glass Floor");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			design=2;
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Grass Floor");
			putValue(SHORT_DESCRIPTION, "Grass Floor");
		}
		public void actionPerformed(ActionEvent e) {
			design=1;
		}
	}
}
