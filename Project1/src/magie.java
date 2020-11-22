import java.awt.Image;

import javax.swing.ImageIcon;

public class magie {
	public int x;
	public int y;
	private Image mag;
	magie(int x1, int y1){
		ImageIcon img= new ImageIcon(getClass().getResource("magie.jpg"));
		mag=img.getImage();
		x=x1;
		y=y1;
	}
	public Image getmagie() {
		return mag;
	}
}
