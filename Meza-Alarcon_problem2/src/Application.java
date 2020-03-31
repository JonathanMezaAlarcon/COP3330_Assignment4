import java.io.IOException;

public class Application {
	
	public static void main(String args[])
	{
		try			
		{
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		duplicateCounter.write(duplicateCounter.count("problem2.txt"));
		}			
		catch(IOException e)
		{				
			System.out.println(e.getMessage());
		}
		System.exit(0);;
	}
}
