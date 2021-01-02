package CODE.WORLD;

import java.io.BufferedReader;
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
		}catch(IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			System.out.println("S'il y a des lettre dans une case pr�cise cette derni�re prend la valeur 0 par d�faut ");
			return 0;
			
		}
		}
}


