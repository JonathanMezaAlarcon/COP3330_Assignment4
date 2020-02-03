//1. call readUnitType method in the readUserData method to read which measuring 
//		system the user will use
//2. call readMeasurementData method from within the readUserData method to send the program
//		to the appropriate method for the measuring system that the user will enter their data into
//3. In either the readImperialData or the readMetricData method, the program will read the data from 
//		the user and call the setHeight and setWeight methods to set the the height and weight of the user
//4. In either the readImperialData or the readMetricData method, the program checks if the weight and height
//		that the user entered are not negative. if either the weight or height is negative, the program will exit
//5. Then, in the calculateBmi method, the program will calculate the user's BMI using the appropriate equation 
//		according to what system the user is using. This will be done using the getter methods of the weight and
//		height. the BMI calculated will the send to the setter method for the BMI. 
//6. Then, the calculateBmi method will call the calculateBmiCategory method, which will calculate the user's 
//		BMI category using the getter method of BMI. 
//7. The result of the calculateBmiCategory method will be send to the setter method of calculateBmi.
//8. Lastly, the displayBmi method will print the user's BMI and the BMI category using the getters of each, and will
//		also display the BMI ranges from the website link. 

import java.util.Scanner;

public class BMICalculator {
	
	double height;
	double weight;
	double bmi;
	String unitType;
	String bmiCategory;
	
	public void readUserData()
	{
		readUnitType();
		readMeasurementData(getUnitType());
	}
	
	private void readUnitType()
	{
		System.out.print("Are you entering Imperial or Metric data?: ");
		Scanner which = new Scanner (System.in);
		setUnitType(which.nextLine());
		
	}
	 
	private void readMeasurementData (String whichSystemused)
	{
		if (whichSystemused.equalsIgnoreCase("imperial") == true)
		{
			readImperialData();
		}
		
		if (whichSystemused.equalsIgnoreCase("metric") == true)
		{
			readMetricData();
		}
	}
	
	private void readMetricData()
	{
		System.out.print("\nEnter your weight in kilograms(cannot be negative): ");
		Scanner num = new Scanner(System.in);
		setWeight(num.nextDouble());
		
		if (getWeight() < 0)
		{
			System.out.print("\nYou've enter a negative number, I will not exit the program in protest :)");
			System.exit(0);
		} 
		
		System.out.print("\nEnter your height in meters (cannot be negative): ");
		Scanner anotherNum = new Scanner(System.in);
		setHeight(anotherNum.nextDouble());
		
		if (getHeight() < 0)
		{
			System.out.print("\nYou've enter a negative number, I will not exit the program in protest :)");
			System.exit(0);
		} 
	}
	
	private void readImperialData()
	{
		System.out.print("\nEnter your weight in pounds(cannot be negative): ");
		Scanner num = new Scanner(System.in);
		setWeight(num.nextDouble());
		
		if (getWeight() < 0)
		{
			System.out.print("\nYou've enter a negative number, I will not exit the program in protest :)");
			System.exit(0);
		} 
		
		System.out.print("\nEnter your height in inches (cannot be negative): ");
		Scanner anotherNum = new Scanner(System.in);
		setHeight(anotherNum.nextDouble());
		
		if (getHeight() < 0)
		{
			System.out.print("\nYou've enter a negative number, I will not exit the program in protest :)");
			System.exit(0);
		}
	}
	
	public void calculateBmi()
	{
		if (getUnitType().equalsIgnoreCase("imperial") == true)
		{
			setBmi( (703 * getWeight()) / (getHeight() * getHeight()));
		}
		
		if (getUnitType().equalsIgnoreCase("metric") == true)
		{
			setBmi( (getWeight())/ ( getHeight() * getHeight()) );
		}
		
		setBmiCategory(calculateBmiCategory());
	}
	
	private String calculateBmiCategory()
	{
		if (getBmi() < 18.5 )
		{
			return "Underweight";
		}
		
		if (18.5 <= getBmi() && getBmi() <= 24.9)
		{
			return "Normal Weight";
		}
		
		if (25 <= getBmi() && getBmi() <= 29.9)
		{
			return "Overweight";
		}
		
		if (30 <= getBmi())
		{
			return "Obesity";
		}
		else {
			return "N/A";
		}
	}
	
	public void displayBmi()
	{
		System.out.printf("\nYour BMI is: %.1f\t\t\t\tBMI Categories:", getBmi());
		System.out.printf("\nYour BMI Category is: %s\t\tUnderweight = <18.5", getBmiCategory());
		System.out.printf("\n\t\t\t\t\t\tNormal weight = 18.5–24.9");
		System.out.printf("\n\t\t\t\t\t\tOverweight = 25–29.9");
		System.out.printf("\n\t\t\t\t\t\tObesity = BMI of 30 or greater ");
				
	}
	
	public double getWeight()
	{
		return this.weight;
	}
	
	private void setWeight(double weight)
	{
		this.weight = weight; 
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	private void setHeight(double height)
	{
		this.height = height; 
	}
	
	private void setBmi(double bmi)
	{
		this.bmi = bmi;
	}
	
	public double getBmi()
	{
		return this.bmi;
	}
	
	private void setUnitType(String unitType)
	{
		this.unitType = unitType;
	}
	
	public String getUnitType()
	{
		return this.unitType;
	}
	
	private void setBmiCategory(String bmiCategory)
	{
		this.bmiCategory = bmiCategory;
	}
	
	public String getBmiCategory()
	{
		return this.bmiCategory;
	}
}




