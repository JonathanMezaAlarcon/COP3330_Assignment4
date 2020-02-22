
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4
{
	int studentResponse;
	int randomNum;
	int randomNum2;
	int randomNumIncorr;
	int randomNumCorr;
	int correctAnsCount = 0;
	char retryorno;
	int level;

	public static void main(String[] args) 
	{
		CAI4 program = new CAI4();
		program.quiz();
	}
	
	public void quiz()
	{
		readDifficulty();		
		for (int i = 0 ; i < 10; i++)
		{
			askQuestion();
			readResponse();
			isAnswerCorrect();
		}
		displayCompletionMessage();
	}	
	
	public void askQuestion()
	{
		generateQuestionArgument();
		System.out.printf("How much is %d times %d?\n", getrandomNum(), getrandomNum2());
	}
	
	public void readResponse()
	{
		Scanner response = new Scanner(System.in);
		setStudentResponse(response.nextInt());
	}
	
	public void isAnswerCorrect()
	{
		int correctAns = getrandomNum() * getrandomNum2();
		
		if (getStudentResponse() != correctAns)
		{
			displayIncorrectResponse();
		}
		
		if (getStudentResponse() == correctAns)
		{
			displayCorrectResponse();
		}
	}
	
	public void displayCorrectResponse()
	{
		setCorrectAnsCount(10);
		SecureRandom randomCorrect = new SecureRandom();
		setRandomNumCorr(randomCorrect.nextInt(4) +1);
		
		switch(getRandomNumCorr())
		{
			case 1 : System.out.println("Very good!\n"); break;
			case 2 : System.out.println("Excellent!\n"); break;
			case 3 : System.out.println("Nice work!\n"); break;
			case 4 : System.out.println("Keep up the good work!\n"); break;
		}
	}
	
	public void displayIncorrectResponse() 
	{
		SecureRandom randomIncorrect = new SecureRandom();
		setRandomNumIncorr(randomIncorrect.nextInt(4) +1);
		
		switch(getRandomNumIncorr())
		{
			case 1 : System.out.println("No. Wrong Answer.\n"); break;
			case 2 : System.out.println("Wrong. Better luck on the next question.\n"); break;
			case 3 : System.out.println("Don’t give up!\n"); break;
			case 4 : System.out.println("No. Keep trying.\n"); break;
		}
	}
	
	public void readDifficulty()
	{
		System.out.println("Enter your difficulty level (1-4):");
		Scanner difficultyLevel = new Scanner(System.in);
		setLevel(difficultyLevel.nextInt());
	}
	
	public void generateQuestionArgument()
	{
		if (getLevel() == 1)
		{
			SecureRandom newrandom = new SecureRandom();
			setrandomNum(newrandom.nextInt(10));
			setrandomNum2(newrandom.nextInt(10));
		}
		
		if (getLevel() == 2)
		{
			SecureRandom newrandom = new SecureRandom();
			setrandomNum(newrandom.nextInt(100));
			setrandomNum2(newrandom.nextInt(100));
		}
		
		if (getLevel() == 3)
		{
			SecureRandom newrandom = new SecureRandom();
			setrandomNum(newrandom.nextInt(1000));
			setrandomNum2(newrandom.nextInt(1000));
		}
		
		if (getLevel() == 4)
		{
			SecureRandom newrandom = new SecureRandom();
			setrandomNum(newrandom.nextInt(10000));
			setrandomNum2(newrandom.nextInt(10000));
		}
	}
	
	public void retryquiz()
	{
		readDifficulty();		
		setCorrectAnsCountForRetry(0);
		for (int i = 0 ; i < 10 ; i++)
		{
			askQuestion();
			readResponse();
			isAnswerCorrect();
		}
		displayCompletionMessage();
	}	
	
	public void displayCompletionMessage()
	{
		if (getCorrectAnsCount() >= 75)
		{
			System.out.println("Congratulations, you are ready to go to the next level! Your score was a " + getCorrectAnsCount());
		}
		
		if (getCorrectAnsCount() < 75)
		{
			System.out.println("Please ask your teacher for extra help. your score was " + getCorrectAnsCount());
		}
		
		System.out.println("\nWould you like to try another set of Problems? (Y or N):");
		Scanner yn = new Scanner(System.in);
		setRetryyorno(yn.next().charAt(0));
		
		if (getRetryyorno() == 'y' || getRetryyorno() == 'Y')
		{
			retryquiz();
		}
		
		if (getRetryyorno() == ('n' | 'N'))
		{
			System.out.println("\nHave a good day!");
			System.exit(0);
		}
	}
	
	public int getStudentResponse() 
	{
		return this.studentResponse;
	}

	private void setStudentResponse(int studentResponse) 
	{
		this.studentResponse = studentResponse;
	}

	private int getrandomNum() 
	{
		return randomNum;
	}

	private void setrandomNum(int randomNum) 
	{
		this.randomNum = randomNum;
	}

	private int getrandomNum2() 
	{
		return randomNum2;
	}

	private void setrandomNum2(int randomNum2) 
	{
		this.randomNum2 = randomNum2;
	}
	
	private int getRandomNumIncorr() 
	{
		return randomNumIncorr;
	}

	private void setRandomNumIncorr(int randomNumIncorr) 
	{
		this.randomNumIncorr = randomNumIncorr;
	}

	private int getRandomNumCorr() 
	{
		return randomNumCorr;
	}

	private void setRandomNumCorr(int randomNumCorr) 
	{
		this.randomNumCorr = randomNumCorr;
	}

	private int getCorrectAnsCount() 
	{
		return correctAnsCount;
	}

	private void setCorrectAnsCount(int correctAnsCount) 
	{
		this.correctAnsCount = this.correctAnsCount + correctAnsCount;
	}
	
	private void setCorrectAnsCountForRetry(int correctAnsCount) 
	{
		this.correctAnsCount = correctAnsCount;
	}

	private char getRetryyorno() 
	{
		return retryorno;
	}

	private void setRetryyorno(char retryorno) 
	{
		this.retryorno = retryorno;
	}

	private int getLevel() 
	{
		return level;
	}

	private void setLevel(int level) 
	{
		this.level = level;
	}
}