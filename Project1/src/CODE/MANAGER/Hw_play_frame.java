package CODE.MANAGER;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Hw_play_frame {

	protected JFrame frame;
    private Game game;
	public Hw_play_frame(Game game) {
		this.game=game;
		initialize();
	}


	public void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Hw_play_frame.class.getResource("/textures/HERO.png")));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 600, 600);
		frame.setLocationRelativeTo(null);  
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel_4 = new JLabel("Game commands");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("ROG Fonts", Font.BOLD, 26));
		lblNewLabel_4.setBackground(new Color(139, 0, 0));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(69, 51,424, 79);
		String Text="<html>Z to move up<br>S to move down"
				+ "<br>D to move Right<br>Q to move Left<br></html>";
		JLabel lblNewLabel_5 = new JLabel(Text);
		lblNewLabel_5.setFont(new Font("ROG Fonts", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(new Color(255, 228, 196));
		lblNewLabel_5.setBounds(25,167,278,181);
		frame.getContentPane().add(lblNewLabel_4);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("ROG Fonts", Font.PLAIN, 19));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(game.on==0) {
				game.window.frame.setVisible(true);
				frame.setVisible(false);
				}else {
					game.continu.frame.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		
		btnNewButton.setBounds(175, 364, 214, 53);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Movements");
		lblNewLabel.setForeground(new Color(255, 127, 80));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("ROG Fonts", Font.BOLD, 19));
		lblNewLabel.setBounds(15, 121, 254, 70);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Attacks");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 165, 0));
		lblNewLabel_1.setFont(new Font("ROG Fonts", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(351, 146, 154, 20);
		frame.getContentPane().add(lblNewLabel_1);
		String Text1="<html>O to attack up<br>L to attack down"
				+ "<br>M to attack Right<br>K to attack Left<br></html>";
		JLabel lblNewLabel_2 = new JLabel(Text1);
		lblNewLabel_2.setForeground(new Color(255, 222, 173));
		lblNewLabel_2.setFont(new Font("ROG Fonts", Font.PLAIN, 18));
		
		lblNewLabel_2.setBounds(329, 199, 234, 116);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Hw_play_frame.class.getResource("/textures/fire3.png")));
		lblNewLabel_3.setBounds(185, 415, 204, 53);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("P To pause");
		lblNewLabel_6.setFont(new Font("ROG Fonts", Font.BOLD, 18));
		lblNewLabel_6.setForeground(new Color(255, 222, 173));
		lblNewLabel_6.setBounds(206, 322, 154, 26);
		frame.getContentPane().add(lblNewLabel_6);
	}

}
