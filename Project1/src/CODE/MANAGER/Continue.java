package CODE.MANAGER;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
public class Continue {

	public JFrame frame;
	public Game game;
	

	public Continue(Game game) {
        this.game=game;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose your game");
		lblNewLabel.setBounds(127, 27, 150, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				game.P=true;
                
                frame.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(159, 199, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("Quit");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			    frame.setVisible(false);
			    game.display.frame.setVisible(false);
			    game.running=false;
			    new MainMenu(game).frame.setVisible(true);
			    
			}
		});
		btnNewButton1.setBounds(159, 100, 115, 29);
		frame.getContentPane().add(btnNewButton1);

	}
}
