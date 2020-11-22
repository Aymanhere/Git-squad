public class Fantome extends Personne{
	Fantome(int x1, int y1) {
		super(x1, y1);
		// TODO Auto-generated constructor stub
	}
	public void move(){
		x=x+(int)(Math.random());
		y=y+(int)(Math.random());
	}
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}