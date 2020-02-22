import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2
{
	//------------------------------------------------------------
	int studentResponse;
	int randomNum;
	int randomNum2;
	int randomNumIncorr;
	int randomNumCorr;

	public static void main(String[] args) 
	{
		CAI2 program = new CAI2();
		program.quiz();
	}
	
	public void quiz()
	{
		askQuestion();
		readResponse();
		isAnswerCorrect();
	}	
	
	public void askQuestion()
	{
		SecureRandom newrandom = new SecureRandom();
		setrandomNum(newrandom.nextInt(10));
		setrandomNum2(newrandom.nextInt(10));
		System.out.printf("How much is %d times %d?\n", randomNum, randomNum2);
	}
	
	public void readResponse()
	{
		Scanner response = new Scanner(System.in);
		int stdResponse = response.nextInt();
		setStudentResponse(stdResponse);
	}
	
	public void isAnswerCorrect()
	{
		int correctAns = getrandomNum() * getrandomNum2();
		
		while (getStudentResponse() != correctAns)
		{
			displayIncorrectResponse();
			retryquiz();
		}
		
		if (getStudentResponse() == correctAns)
		{
			displayCorrectResponse();
		}
	}
	
	public void displayCorrectResponse()
	{
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
	
	public void retryquiz()
	{
		readResponse();
		isAnswerCorrect();
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
}
