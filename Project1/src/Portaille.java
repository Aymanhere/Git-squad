import java.awt.Image;

import javax.swing.ImageIcon;

public class Portaille {
	public int x;
	public int y;
	private Image por;
	Portaille(int x1, int y1){
		x=x1;
		y=y1;
		ImageIcon img= new ImageIcon(getClass().getResource("portaille.jpg"));
		por=img.getImage();
}
	
	public Image Portaille() {
		return por;
	}
}

