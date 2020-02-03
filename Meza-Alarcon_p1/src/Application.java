//1. prompt the user to enter the int that is to be encrypted
//2. Create a scanner type jerry and assign that Scanner to an int named tom
//3. call the Encrypter.encrypt method within the print statement and send tom as it's argument
//4. the method returns the encrypted string and the print functions prints it out
//
//5. prompt user to enter the number to be decrypted
//6. create a scanner type mark and assign it to an int named chris
//7. call the Decrypter.decrypt method within the print function and send chris as its argument
//8. The method returns the decrypted string and prints it
//9. main method ends

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		System.out.print("enter the integer to be encrypted: ");//prompt
		Scanner jerry = new Scanner(System.in);
		String tom = jerry.nextLine();
		
		System.out.print("the encrypted number is: " + Encrypter.encrypt(tom));
		
		System.out.print("\nEnter the number to be decrypted: ");//prompt
		Scanner mark = new Scanner(System.in);
		String chris = mark.nextLine();
		
		System.out.print("The decrypted number is: " + Decrypter.decrypt(chris));
		
		System.out.println("\n\nThis is the end of the encryption/decryption program");
		System.out.println("Goodbye!");
		
		jerry.close();
		mark.close();

	}

}
