import java.io.IOException;

public class Application {

	public static void main(String args[])
	{
		DuplicateRemover duplicateremover = new DuplicateRemover();
		try {
			duplicateremover.write(duplicateremover.remove("problem1.txt"));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		catch(NullPointerException y)
		{
			System.out.println(y.getMessage());
			System.exit(0);
		}	
	}
}