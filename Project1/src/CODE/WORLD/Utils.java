package CODE.WORLD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {
	
	
	public static String loadFileAsString(String path) {
		StringBuilder builder=new StringBuilder();
		
		try {
			InputStream inputStream = Utils.class.getResourceAsStream(path);
			InputStreamReader inputReader = new InputStreamReader(inputStream);
			BufferedReader br=new BufferedReader(inputReader);
			String line= null;
			while((line=br.readLine())!=null) {
				
				builder.append(line+"\n");
	
				}br.close();
		}catch(Exception er) {
				System.out.println("File doesn't exist! enter a valid path! |||warning||| Labyrinth is by default ");
				try {
				InputStream inputStream = Utils.class.getResourceAsStream("/worlds/default_world.txt");
				InputStreamReader inputReader = new InputStreamReader(inputStream);
				BufferedReader br=new BufferedReader(inputReader);
				String line= null;
				while((line=br.readLine())!=null) {
					
					builder.append(line+"\n");
		
					}br.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
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


