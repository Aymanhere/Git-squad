package CODE.WORLD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	
	
	public static String loadFileAsString(String path) {
		StringBuilder builder=new StringBuilder();
		
		try {
			BufferedReader br=new BufferedReader(new FileReader(path));
			String line;
			while((line=br.readLine())!=null) {
				
				builder.append(line+"\n");
	
				}br.close();
		}catch(FileNotFoundException er) {
				System.out.println("File doesn't exist! enter a valid path! |||warning||| Labyrinth is by default ");
				try {
					BufferedReader br=new BufferedReader(new FileReader("res/worlds/default_world.txt"));
					String line;
					try {
						while((line=br.readLine())!=null) {
							
							builder.append(line+"\n");

							}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}try {
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Again File doesn't exist! enter a valid path");
				}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			System.out.println("Il y'a d'autres caractères que 0 ou 1 cette case donc elle prend la valeur 0 par défaut ");
			return 0;
			
			
		}
		}
}


