//1. Get the String that is to be decrypted from the user
//2. Create int variables to hold the values of each digit 
//3. Chop the string into chars and convert those chars into their number
//		values and assign them to int variables
//4. Create temporary int variables to hold the values of the first and second 
//		digits to that their values are not lost during the swapping
//5. Swap the digits back (1st <-> 3rd and 2nd <-> 4th)
//6. add 10 to each digit
//7. subtract 7 from each digit
//8. modulo 10 to each digit
//9. Convert the integers into strings and catenate them in order (1st, 2nd, 3rd, 4th)
//10. Return that string to the main method

import java.util.Scanner;
public class Decrypter {

	public static String decrypt(String encrypted) {
		
		//chop string into indvidual ints
		int first_d = Character.getNumericValue(encrypted.charAt(0));
		int second_d = Character.getNumericValue(encrypted.charAt(1));
		int third_d = Character.getNumericValue(encrypted.charAt(2));
		int fourth_d = Character.getNumericValue(encrypted.charAt(3));
		
		int temp_first_d = first_d;
		int temp_second_d = second_d;
		
		//swapping
		first_d = third_d;
		third_d = temp_first_d;
		second_d = fourth_d;
		fourth_d = temp_second_d;
		
		//add 10
		first_d += 10;
		third_d += 10;
		second_d += 10;
		fourth_d += 10;
		
		//minus 7
		first_d -= 7;
		third_d -= 7;
		second_d -= 7;
		fourth_d -= 7;
		
		//modulo 10
		first_d = first_d % 10;
		third_d = third_d % 10;
		second_d = second_d % 10;
		fourth_d = fourth_d % 10;
		
		//catenation 
		String final_decrypt = String.valueOf(first_d) + String.valueOf(second_d) + String.valueOf(third_d) + String.valueOf(fourth_d);
		
		return final_decrypt;

	}

}
