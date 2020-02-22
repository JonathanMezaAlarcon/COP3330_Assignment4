import java.util.Scanner;

public class SavingsAccount {
	private static float annualInterestRate;
	private float savingsBalance;
	private float[] monthlyInterestRate = new float[14];
	private float[] monthlyBalance = new float[14];
	
	public void SavingsAccount(float savingsBalance)
	{
		this.savingsBalance = savingsBalance;
	}
	public float calculateMonthlyInterest()
	{	
		float final_balance = getSavingsBalance();
		setMonthlyBalance(getSavingsBalance(), 0);
		
		if ((getInterestRate() *100) == 5)
		{
			float interest = (getSavingsBalance() * getInterestRate())/12;
			
			final_balance = getSavingsBalance() + interest;
			System.out.printf("The Interest for this month is: %.2f\t\t", interest);
			System.out.printf("This Balance for this month is: %.2f\n\n", getSavingsBalance()+interest);
			return final_balance;
		}
		if ((getInterestRate() *100) == 4)
		{
			for (int i = 1; i < 13 ; i++)
			{
			float interest = (getMonthlyBalance(i - 1) * getInterestRate())/12;
			float newbalance = interest + getMonthlyBalance(i -1);
			setMonthlyInterestRate(interest, i);
			setMonthlyBalance(newbalance, i);
			
			System.out.printf("The Interest for month %d is: %.2f\t\t", i, getMonthlyInterestRate(i));
			System.out.printf("The Balance for month %d is: %.2f\n\n", i, getMonthlyBalance(i));
			
			final_balance = final_balance + getMonthlyInterestRate(i);
			setSavingsBalance(final_balance);
			}
		}
		return final_balance;
	}
	
	public static void modifyInterestRate(float interestRate)
	{
		setInterestRate(interestRate / 100);
	}
	
	public static void setInterestRate(float annualInterestRates)
	{
		annualInterestRate = annualInterestRates;
	}
	
	private float getInterestRate()
	{
		return this.annualInterestRate;
	}
	
	private void setSavingsBalance(float newSavingsBalance)
	{
		this.savingsBalance = newSavingsBalance;
	}
	private float getSavingsBalance()
	{
		return this.savingsBalance;
	}
	
	private void setMonthlyInterestRate (float monthlyInterestRate, int i)
	{
		this.monthlyInterestRate[i] = monthlyInterestRate;
	}
	private float getMonthlyInterestRate(int i) 
	{
		return monthlyInterestRate[i];
	}
	
	private float getMonthlyBalance(int i)
	{
		return monthlyBalance[i];
	}
	
	private void setMonthlyBalance(float monthlyBalance, int i) 
	{
		this.monthlyBalance[i] = monthlyBalance;
	}
	

	

}
