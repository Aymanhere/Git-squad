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
			int i=32;
			while(i!=0) {
				line=br.readLine();
				if(line !=null){
				   builder.append(line+"\n");
				   i--;
				}
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
			e.printStackTrace();
			return 0;
		}
		}
}


