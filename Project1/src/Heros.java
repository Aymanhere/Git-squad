import java.awt.*;

import javax.swing.*;

public class Heros extends Personne{
	int ptvie=3;
	private Image Heros;
	Heros(int x1, int y1) {
		super(x1, y1);
		ImageIcon img= new ImageIcon(getClass().getResource("Heros.png"));
		Heros=img.getImage();
	
		// TODO Auto-generated constructor stub
	}
	public void move(String M){
		if (M.equals("L") && x>1){
			x=x-1;
		}
		else if (M.equals("R") && x<19){
			x=x+1;
		}
		else if (M.equals("U") && y>1){
			y=y-1;
		}
		else if (M.equals("D") && x<19){
			y=y+1;
		}
	}
	public void move1(String M){
		if (M.equals("L") && x>20){
			x=x-20;
		}
		else if (M.equals("R") && x<480){
			x=x+20;
		}
		else if (M.equals("U") && y>20){
			y=y-20;
		}
		else if (M.equals("D") && y<380){
			y=y+20;
		}
	}
	public void attack(){
	}
	public Image getHeros() {
		return Heros;
	}
	
}