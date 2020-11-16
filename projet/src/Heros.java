public class Heros extends Personne{
	public void move(String M){
		if (M=="L" && x>1){
			x=x-1;
		}
		else if (M=="R" && x<20){
			x=x+1;
		}
		else if (M=="U" && y>1){
			y=y-1;
		}
		else if (M=="D" && x<20){
			y=y+1;
		}
	}
	public void attack(){
	}
}