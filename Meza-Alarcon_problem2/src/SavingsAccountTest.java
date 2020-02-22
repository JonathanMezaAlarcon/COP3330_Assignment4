import java.util.Scanner;

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount();
		SavingsAccount saver2 = new SavingsAccount();
		
		saver1.SavingsAccount(2000);
		saver2.SavingsAccount(3000);
		
		System.out.println("\t\t\t\tThe following is for interest rate %4\n");
		
		saver1.modifyInterestRate(4);
		saver2.modifyInterestRate(4);
		
		float total_balance = saver1.calculateMonthlyInterest();
		System.out.printf("\tThe total Balance for saver1 after interest is: %.2f\n\n\n", total_balance);
		
		float total_balance2 = saver2.calculateMonthlyInterest();
		System.out.printf("\tThe total Balance for saver2 after interest is: %.2f\n\n\n", total_balance2);
		
		System.out.println("\t\t\t\tThe following is for interest rate %5\n");
		
		saver1.modifyInterestRate(5);
		saver2.modifyInterestRate(5);
		
		total_balance = saver1.calculateMonthlyInterest();
		System.out.printf("\tThe total Balance for saver1 is: %.2f\n\n", total_balance);
		total_balance2 = saver2.calculateMonthlyInterest();
		System.out.printf("\tThe total Balance for saver2 is: %.2f\n\n", total_balance2);

	}

}

