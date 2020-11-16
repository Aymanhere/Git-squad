public class labyrinthe {
	//taille des sprites en longueur et largeur
	private char px,py=30;
	//nombre de cellules en longueur et largeur 
	private int dx,dy=15;
	private int labyr[][];
	if ((dx % 2) != 0){
        dx = dx - 1;
    if ((dy % 2) != 0)
        dy = dy - 1;
    
    this.lab=new int[dx+1][dy+1];
}