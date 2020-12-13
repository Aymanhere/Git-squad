package CODE.MANAGER;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class hw_play_continue {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hw_play_continue window = new hw_play_continue();
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
	public hw_play_continue() {
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
		JLabel lblNewLabel_4 = new JLabel("Different commands of the game");
		lblNewLabel_4.setBounds(20, 0,267, 48);
		String Newligne=System.getProperty("line.separator");
		String Text="<html>Press Z to move up<br>Press S to move down"
				+ "<br>Press D to move Right<br>Press Q to move Left<br>Press O to attack up </html>";
		JLabel lblNewLabel_5 = new JLabel(Text);
		lblNewLabel_5.setBounds(30,54,181,120);
		frame.getContentPane().add(lblNewLabel_4);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Back to play");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Frame_continue().frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(159, 199, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		
	}

}
