import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter {
	String outputFileString;
	
	public String count(String dataFile) throws IOException
	{
		char [] temp = new char[10000]; 
		int i = 0;
		int n = 0;
		Map< String,Integer> wordCounter = new HashMap< String,Integer>(); 
		ArrayList <String> word = new ArrayList <String> ();
		ArrayList <Integer> occuranceAmount = new ArrayList <Integer>();
		String myCopyOfFile = new String((Files.readAllBytes(Paths.get(dataFile))));
		int length = myCopyOfFile.length();
		char[]newCopyOfFile = myCopyOfFile.toCharArray();
		
		while( i < length)
		{
			int a = (int)newCopyOfFile[i];
			if (a == 32)
			{
				String temp2 = String.valueOf(temp);
				if(word.contains(temp2))
				{
					int index = word.indexOf(temp2);
					Integer occuranceNum = occuranceAmount.get(index);
					occuranceNum += 1;
					occuranceAmount.set(index, occuranceNum);
				}
				else 
				{
					word.add(temp2);
					occuranceAmount.add(1);
				}
				temp = new char [temp.length];
				n = 0;
			}
			else
			{
				temp[n] = newCopyOfFile[i];
				n++;
			}	
			i++;
		}
		i = 0;
		int size = word.size();
		while (i < size)
		{
			wordCounter.put(word.get(i), occuranceAmount.get(i));
			i++;
		}
		outputFileString = wordCounter.toString();
		System.out.println(wordCounter);
	    wordCounter.clear();
		word.clear();
		occuranceAmount.clear();
		return "unique_word_counts.txt";
	}
	

	public void write(String outputFileName2) throws IOException
	{
		File outputFile = new File(outputFileName2);
		outputFile.createNewFile();	
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName2));
	    writer.write(outputFileString);
	    writer.close();
	}
}
