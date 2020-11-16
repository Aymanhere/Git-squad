public class cellule {
		//construction de la cellule de cordonnées(x,y)
		private int x;
		private int y;
		 public cellule(int x,int y) {
		        this.x=x;
		        this.y=y;
		    }
		 //méthode des getter pour renvoyer la cordonnée en x
		 public int getx() {
		        return this.x;
		    }
		 //méthode des getter pour renvoyer la cordonnée en y
		 public int gety() {
		        return this.y;
		    }
		//méthode des setter pour renvoyer la cordonnée en x
		 public void setx(int x) {
		        this.x=x;
		    }
		//méthode des setter pour renvoyer la cordonnée en y
		 public void sety(int y) {
		      	this.y=y;
		    }
}

