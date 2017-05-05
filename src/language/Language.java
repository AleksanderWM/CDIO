/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */

package language;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import language.Language;

public class Language {
	
	
	public static String[] Text = new String [100];
	
	public static void chooseLanguage(String Language){
		
			InputStream in = Language.class.getResourceAsStream("/" + Language);

			Reader reader = null;
			try {
				reader = new InputStreamReader(in, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			Scanner scan = new Scanner(reader);

			int i = 1;
			while (scan.hasNextLine()) {
				String string = scan.nextLine();
				Text[i] = string;
				i++;

			}
			scan.close();

	}
	
	public static String toString(int index){
		return Text[index];
	}
	
	public static boolean languageFound(String Language){
		if(Language.equalsIgnoreCase("DANISH") || Language.equalsIgnoreCase("ENGLISH"))
			return true;
		return false;
	}
	

}
