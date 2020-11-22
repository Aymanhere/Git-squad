import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Map {
	private Scanner r;
	private String Map[]=new String[20];
	
	private Image floor;
	private Image wall;
	
	public Map() {
		ImageIcon png=new ImageIcon(getClass().getResource("squar.jpg"));
		floor= png.getImage();
		ImageIcon png1=new ImageIcon(getClass().getResource("black.jpg"));
		wall= png1.getImage();
		
	openFile();
	readFile();
	closeFile();
	}
public Image getfloor() {
	return floor;
}
public Image getwall() {
	return wall;
}
public String Mapcoo(int x,int y) {
	String index=Map[y].substring(x,x+1);
	return index;
}
 public void openFile() {
	 try {
	 r=new Scanner (new File("map.txt"));
	 }catch(Exception e) {
		System.out.println("problem in loading map");
	 }
	 
 }
public void readFile() {
	while(r.hasNext()) {
		for(int i=0;i<20;i++) {
				Map[i]=r.next()	;		
		}
	}
}
public void closeFile() {
	
	
}
}
