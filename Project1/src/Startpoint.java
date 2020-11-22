import javax.swing.*;
public class Startpoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Startpoint();

	}
	public Startpoint() {
		JFrame f= new JFrame();
		f.setTitle("Labyrinth game");
		f.setSize(500,400);
		f.setLocationRelativeTo(null);
		f.add(new Board());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
}
}