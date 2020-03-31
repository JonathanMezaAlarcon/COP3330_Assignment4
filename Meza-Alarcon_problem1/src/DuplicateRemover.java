import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class DuplicateRemover {
	Set<String> uniqueWords = new HashSet<String>();
	String outputString;
	
	public String remove(String dataFile) throws IOException 
	{
		ArrayList <Character> saved = new ArrayList <Character>();
		int i = 0;
		String str = new String((Files.readAllBytes(Paths.get(dataFile))));
		int len = str.length();
		String temp = str.toLowerCase();
		char [] tempHolder = temp.toCharArray();			
		while( i < len)
		{
			int a = (int)tempHolder[i];
			if (a == 32)
			{
				String temp1 = saved.toString();
				uniqueWords.add(temp1);
				saved.clear();
			}
			else
			{
				saved.add(tempHolder[i]);
			}	
			i++;
		}
		outputString = uniqueWords.toString();
		saved.clear();
		return "unique_words.txt";
	}
	
	public void write(String outputFileName) throws IOException
	{
		File outputFile = new File(outputFileName);
		outputFile.createNewFile();	
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
	    writer.write(outputString);
	    writer.close();
	    uniqueWords.clear();
	}
}
