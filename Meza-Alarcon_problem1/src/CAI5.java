
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5
{
	int studentResponse;
	double studentResponseForOptionFour;
	int randomNum;
	int randomNum2;
	int randomNumIncorr;
	int randomNumCorr;
	int correctAnsCount = 0;
	char retryorno;
	int level;
	int option;
	int randomIsFour;
	int option_5_option;

	public static void main(String[] args) 
	{
		CAI5 program = new CAI5();
		program.quiz();
	}
	
	public void quiz()
	{
		readProblemType();
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
		
		switch(getOption())
		{
			case 1 : System.out.printf("How much is %d plus %d?\n", getrandomNum(), getrandomNum2()); break;
			case 2 : System.out.printf("How much is %d times %d?\n", getrandomNum(), getrandomNum2()); break;
			case 3 : System.out.printf("How much is %d minus %d?\n", getrandomNum(), getrandomNum2()); break;
			case 4 : System.out.printf("How much is %d divided by %d (round to 2 decimal places)?\n", getrandomNum(), getrandomNum2()); break;
		}
		
		if (getOption() == 5)
		{
			SecureRandom randomType = new SecureRandom();
			int someRandomNum = randomType.nextInt(4) + 1;
			
			setOption_5_option(someRandomNum);
			
			switch(someRandomNum)
			{
				case 1 : System.out.printf("How much is %d plus %d?\n", getrandomNum(), getrandomNum2()); break;
				case 2 : System.out.printf("How much is %d times %d?\n", getrandomNum(), getrandomNum2()); break;
				case 3 : System.out.printf("How much is %d minus %d?\n", getrandomNum(), getrandomNum2()); break;
				case 4 : System.out.printf("How much is %d divided by %d?(round to 2 decimal places)\n", getrandomNum(), getrandomNum2()); 
					setRandomIsFour(1); break;
			}
		}
	}
	
	public void readResponse()
	{
		if (getOption() == 4 || getRandomIsFour() == 1)
		{
			Scanner response = new Scanner (System.in);
			setStudentResponseForOptionFour(response.nextDouble());
		}
		if (getOption() != 4 && getRandomIsFour() != 1)
		{
			Scanner response = new Scanner(System.in);
			setStudentResponse(response.nextInt());
		}
	}
	
	public void isAnswerCorrect()
	{
		
		int correctAns = 0;
		double correctAnsForDivision = 0.0;
		
		if(getOption() == 1 || getOption_5_option() == 1)
		{
			correctAns = (int)getrandomNum() + getrandomNum2();
			setOption_5_option(0);
		}
		
		if(getOption() == 2 || getOption_5_option() == 2)
		{
			correctAns = (int)getrandomNum() * getrandomNum2();
			setOption_5_option(0);
		}

		if(getOption() == 3 || getOption_5_option() == 3)
		{
			correctAns = (int)getrandomNum() - getrandomNum2();
			setOption_5_option(0);
		}

		if(getOption() == 4 || getRandomIsFour() == 1)
		{
			if (getrandomNum2() == 0)
			{
				System.out.println("You Can't divide by Zero!");
			}else 
			{
			correctAnsForDivision = (double) getrandomNum() / getrandomNum2();
			}
		}
		
		if (getOption() == 1 || getOption() == 2 || getOption() == 3 || getOption() == 5 && getRandomIsFour() != 1)
		{			
			setRandomIsFour(0);
			if (getStudentResponse() != correctAns )
			{
				displayIncorrectResponse();
			}
			
			if (getStudentResponse() == correctAns)
			{
				displayCorrectResponse();
			}
		}
			
		if (getOption() == 4 || (getOption() == 5 && getRandomIsFour() == 1))
		{
			setRandomIsFour(0);
			
			if (getStudentResponseForOptionFour() >= (correctAnsForDivision - 0.01) && getStudentResponseForOptionFour() <= (correctAnsForDivision + 0.01))
			{
				displayCorrectResponse();
			}
			
			if (getStudentResponseForOptionFour() < correctAnsForDivision - 0.01 || getStudentResponseForOptionFour() > correctAnsForDivision + 0.01 )
			{
				displayIncorrectResponse();
			}
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
		readProblemType();
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
	
	public void readProblemType()
	{
		System.out.println("Enter the type of arthmetic problem to work on (1-addition "
				+ "| 2-multiplication | 3-subtraction | 4-division | 5-random mixture of all types)");
		Scanner type = new Scanner(System.in);
		setOption(type.nextInt());
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

	private int getOption() 
	{
		return option;
	}

	private void setOption(int option)
	{
		this.option = option;
	}

	private int getRandomIsFour() 
	{
		return randomIsFour;
	}

	private void setRandomIsFour(int randomIsFive)
	{
		this.randomIsFour = randomIsFive;
	}

	private double getStudentResponseForOptionFour() 
	{
		return studentResponseForOptionFour;
	}

	
	private void setStudentResponseForOptionFour(double studentResponseForOptionFour) 
	{
		this.studentResponseForOptionFour = studentResponseForOptionFour;
	}

	private int getOption_5_option() 
	{
		return option_5_option;
	}

	private void setOption_5_option(int option_5_option) 
	{
		this.option_5_option = option_5_option;
	}
	
}