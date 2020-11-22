public abstract class Personne{
	public static final float DEFAULT_SPEED = 0.5f;
	public int x;
	public int y;
	public int ptvie;
	protected float speed;
	protected float xMove, yMove;
	public abstract void attack();
	Personne(int x1, int y1){
		x=x1;
		y=y1;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
}