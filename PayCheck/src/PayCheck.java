/*
 * 		This program prompts the user to input their weekly pay and produces a summary containing their name,
 * 		gross pay, deductions (tax and charity) and finally their total net pay.
 * 
 * 		Author : Smit B.
 * 		Date : Halloween, 2017
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class PayCheck {

	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);
		double charDed = 0 , taxDed= 0, netPay = 0, groPay = 0, more40 = 0, less40 = 0;
		System.out.print("Enter your surname name : ");
		String famName = input.nextLine();
		System.out.print("Enter your given name : ");
		String givName = input.nextLine();
		System.out.print("Enter your hourly rate : ");
		double ratePay = Double.parseDouble(input.nextLine());
		System.out.print("Enter number of hours you worked this week : ");
		int hoursWork = Integer.parseInt(input.nextLine());
		
		// if the hours worked are 40 or less, they get paid at the same rate
		if (hoursWork <= 40) {
			groPay = ratePay * hoursWork;
			// however if the hours worked are more than 40, they will get paid double their rate for every hour
			// over 40, and normal rate for less than 40
		}else if (hoursWork > 40) {
			more40 = hoursWork - 40;
			less40 = hoursWork - more40;
			groPay = (more40 *(2* ratePay)) + (less40 * ratePay);
		}
		System.out.print("Would you like to give $20 of your paycheck as contribution to charity? (Y/N?) : ");
		char charity = (input.nextLine()).charAt(0);

		// if the user inputs either a capital or lower case letter of y or n, it will give a variable the value of 20 or 0 based upon their input
		if (charity == 'y' || charity == 'Y'){
			charDed = 20.00;
		}else if (charity == 'n'|| charity == 'N'){
			charDed = 0.00;
			// however, if something other than a upper or lower case y and n is inputed, it will output an error message and exit  
		}else{
			System.out.println("Enter a valid letter option");
			System.exit(0);
		}
		// now, the user must input a letter to associate which category their tax is in. What ever they choose is the amount of tax deduction
		System.out.println("Enter the letter to indicate your tax category : ");
		System.out.println("A.	No tax deduction");
		System.out.println("B.	tax is 10% of gross pay");
		System.out.println("C.	tax is 20% of gross pay");
		System.out.println("D.	tax is 29% of gross pay");
		System.out.println("E.	tax is 35% of gross pay");
		System.out.print("Your Letter : ");
		char taxLet = (input.nextLine()).charAt(0);
		
		/* if user chooses option a, the tax deduction will be 0% of gross pay and then calc net pay by 
		 * subtracting gross pay by tax deductions and charity deductions	*/
		if (taxLet == 'A' || taxLet == 'a'){
			taxDed = 0;
			netPay = groPay - taxDed - charDed;

			/* if user chooses option b, the tax deduction will be 10% of gross pay and then calc net pay by 
			 * subtracting gross pay by tax deductions and charity deductions	*/		
		}else if (taxLet =='B'|| taxLet == 'b'){
			taxDed = groPay * 0.10;
			netPay = groPay - taxDed - charDed;

			/* if user chooses option c, the tax deduction will be 20% of gross pay and then calc net pay by 
			 * subtracting gross pay by tax deductions and charity deductions	*/			
		}else if (taxLet =='C'|| taxLet == 'c'){
			taxDed = groPay * 0.20;
			netPay = groPay - taxDed - charDed;

			/* if user chooses option d, the tax deduction will be 29% of gross pay and then calc net pay by 
			 * subtracting gross pay by tax deductions and charity deductions	*/			
		}else if (taxLet =='D'|| taxLet == 'd'){
			taxDed = groPay * 0.29;
			netPay = groPay - taxDed - charDed;

			/* if user chooses option e, the tax deduction will be 35% of gross pay and then calc net pay by 
			 * subtracting gross pay by tax deductions and charity deductions	*/		
		}else if (taxLet =='E'|| taxLet == 'e'){
			taxDed = groPay * 0.35;
			netPay = groPay - taxDed - charDed;

			// if any other letter is entered, it will output error message and exit			
		}else {
			System.out.println("Enter a valid letter option");
			System.exit(0);
		}

		// rounds the variables below to the nearest hundredth (unless the decimal value is 0)
		groPay =Double.parseDouble(new DecimalFormat("####.00").format(groPay));
		charDed =Double.parseDouble(new DecimalFormat("####.00").format(charDed));
		taxDed =Double.parseDouble(new DecimalFormat("####.00").format(taxDed));
		netPay =Double.parseDouble(new DecimalFormat("####.00").format(netPay));

		// outputs various things that are titled in each category
		System.out.println("*********************************************************************************");
		System.out.println("Name :               "+famName+", "+givName);
		System.out.println("Gross Pay :          $"+groPay);
		System.out.println("Charity Deduction :  $"+charDed);
		System.out.println("Tax Deductions :     $"+taxDed);
		System.out.println("Net Pay :            $"+netPay);
		System.out.println("*********************************************************************************");

	}

}
