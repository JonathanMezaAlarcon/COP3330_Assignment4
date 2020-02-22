import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 
{
	int studentResponse;
	int randomNum;
	int randomNum2;

	public static void main(String[] args) 
	{
		CAI1 program = new CAI1();
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
	
	public void retryquiz()
	{
		readResponse();
		isAnswerCorrect();
	}	
	
	public void displayCorrectResponse()
	{
		System.out.println("Very good!");
		System.exit(0);
	}
	
	public void displayIncorrectResponse()
	{
		System.out.println("No. Please try again.");
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
}