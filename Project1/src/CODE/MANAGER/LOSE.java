package CODE.MANAGER;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class LOSE{

	public JFrame frame;
	public static boolean con=false;
    private Game game;
	public LOSE(Game game) {
		this.game=game;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		Image img= new ImageIcon("textures/heroimg.jpg").getImage();
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Menu");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("ROG Fonts", Font.BOLD, 16));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    game.lose.frame.setVisible(false);
				    game.display.frame.setVisible(false);
				    game.running=false;
				    game=new Game("Game",1000,640);
				    game.window.frame.setVisible(true);
				    
				    
				
			}
		});
		btnNewButton_1.setBounds(132, 197, 179, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LOSE.class.getResource("/textures/GAME_Over1.jpg")));
		lblNewLabel.setBounds(75, 16, 309, 165);
		frame.getContentPane().add(lblNewLabel);
	}
}