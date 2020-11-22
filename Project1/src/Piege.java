import java.awt.Image;

import javax.swing.ImageIcon;

public class Piege {
	public int x;
	public int y;
	private Image pie;
	Piege(int x1, int y1){
		x=x1;
		y=y1;
		ImageIcon img= new ImageIcon(getClass().getResource("piege.png"));
		pie=img.getImage();
}
	public Image Piege() {
		return pie;
	}
}
