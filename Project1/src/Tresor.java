import java.awt.Image;

import javax.swing.ImageIcon;

public class Tresor {
	public int x;
	public int y;
	private Image tres;
	Tresor(int x1, int y1){
		ImageIcon img= new ImageIcon(getClass().getResource("tresor.jpg"));
		tres=img.getImage();
		x=x1;
		y=y1;
		
}
	public Image gettresor() {
		return tres;
	}
	
}
