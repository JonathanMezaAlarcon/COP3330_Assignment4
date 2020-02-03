//1. Get the String that is to be encrypted from the main method
//2. Chop that string into individual chars and convert those chars to ints.
//		this will allow us to have access to the individual digits of the number
//3. add 7 to every individual digit
//4. Do modulo 10 to each digit
//5. create two temporary ints to hold the values of the first and second digist so that
//		their values are not lost when swapped
//6. swap the first digit with the third digit, and the second with the fourth
//7. catenate the digits together into a String in the following order: first, second, third, fourth
//8. return that string to the main method

import java.util.Scanner;


public class Encrypter {

	public static String encrypt(String digits) {
		
		//chopping string into indvidual digits
		int first = Character.getNumericValue(digits.charAt(0));
		int second = Character.getNumericValue(digits.charAt(1));
		int third = Character.getNumericValue(digits.charAt(2));
		int fourth = Character.getNumericValue(digits.charAt(3));
		
		//add 7
		first += 7; 
		second += 7; 
		third += 7; 
		fourth += 7; 
		
		//modulo 10
		first = first % 10; 
		second =second % 10; 
		third = third % 10; 
		fourth = fourth % 10; 
		
		int temp_first = first;
		int temp_second = second;
		
		//swapping
		first = third;
		third =  temp_first;
		second = fourth;
		fourth = temp_second;
		
		//catenation 
		String final_encrypt = String.valueOf(first) + String.valueOf(second) + String.valueOf(third) + String.valueOf(fourth);
		
		return final_encrypt;

	}

}
