package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Emil Jorgensen
 */
public class Text {
		private String url;
		
		public Text(String fileUrl)
		{
			url = fileUrl;
		}

		
		/**
		 * As long as there are lines, the liens are saved in a list
		 * @return  the list as an Array of Strings
		 */
		public String[] OpenFile() throws IOException
		{
			FileReader fileReader = new FileReader(url);
			BufferedReader textReader = new BufferedReader(fileReader);
			int numberOfLines = readLines();
			String[] textList = new String[numberOfLines];
			for(int i = 0 ; i < numberOfLines ; i++)
			{
				textList[i] = textReader.readLine();
			}
			textReader.close();
			return textList;
		}
		
		/**
		 * Gives the number of lines in a textfile
		 * @return (int) Number of lines
		 */
		public int readLines() throws IOException
		{
			FileReader file_to_read = new FileReader(url);
			BufferedReader bReader = new BufferedReader(file_to_read);
			int numberOfLines = 0;
			while((bReader.readLine()) != null)
			{
				numberOfLines++;
			}
			bReader.close(); 
			return numberOfLines;
		}
	}
