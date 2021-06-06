package ex17.base;

import java.util.Scanner;

/**
 * Exercise 17 - Blood Alcohol Calculator
 * Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make a determination.
 *
 * Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the amount of time since your last drink. Calculate your blood alcohol content (BAC) using this formula
 *
 * BAC = (A × 5.14 / W × r) − .015 × H
 * where
 *
 * A is total alcohol consumed, in ounces (oz).
 * W is body weight in pounds.
 * r is the alcohol distribution ratio:
 * 0.73 for men
 * 0.66 for women
 * H is number of hours since the last drink.
 * Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.
 *
 * Example Output
 *
 * Enter a 1 is you are male or a 2 if you are female: 1
 * How many ounces of alcohol did you have? 3
 * What is your weight, in pounds? 175
 * How many hours has it been since your last drink? 1
 *
 * Your BAC is 0.049323
 * It is legal for you to drive.
 *
 *
 * Enter a 1 is you are male or a 2 if you are female: 1
 * How many ounces of alcohol did you have? 5
 * What is your weight, in pounds? 175
 * How many hours has it been since your last drink? 1
 *
 * Your BAC is 0.092206
 * It is not legal for you to drive.
 *
 *
 * Constraint
 *
 * Prevent the user from entering non-numeric values.
 *
 * Challenges
 *
 * Handle metric units.
 * Look up the legal BAC limit by state and prompt for the state. Display a message that states whether or not it’s legal to drive based on the computed BAC.
 * Develop this as a mobile application that makes it easy to record each drink, updating the BAC each time a drink is entered.
 */

public class App {
	public static void main(String[] args) {
		
		final double M = 0.73;
		final double F = 0.66;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a 1 if you are male or a 2 if you are female: ");
		
		int gender = -1;
		
		while (!(gender == 1 || gender ==2) ) {
			gender = isOneOrTwo(in.nextLine());
		}
		
		System.out.print("How many ounces of alcohol did you have? ");
		int A = -1;
		while (A < 0){
			A =isPosInt(in.nextLine());
		}
		
		System.out.print("What is your weight, in pounds? ");
		int W = -1;
		while (W < 0){
			W =isPosInt(in.nextLine());
		}
		
		System.out.print("How many hours has it been since your last drink? ");
		int H = -1;
		while (H < 0){
			H =isPosInt(in.nextLine());
		}
		
		double BAC = (A * 5.14 / W * (gender == 1 ? M : F)) - 0.015 * H;
		
		System.out.printf("Your BAC is %.6f%n", BAC);
		System.out.println("It is " + (BAC< 0.08 ? "legal" : "not legal") + " for you to drive.");
		
	}
	
	// checks to see if user enters a 1 or 2
	public static int isOneOrTwo(String str)
	{
		int number;
		
		try{
			number = Integer.parseInt(str);
			if(!(number == 1 || number ==2)){
				throw new NumberFormatException();
			}
			return number;
		}
		catch(NumberFormatException fe){
			System.out.print("Please enter a valid number: ");
			return -1;
		}
	}
	
	//checks to see if user enters 1 positive integer
	public static int isPosInt(String str)
	{
		int number;
		
		try{
			number = Integer.parseInt(str);
			if((number < 0)){
				throw new NumberFormatException();
			}
			return number;
		}
		catch(NumberFormatException fe){
			System.out.print("Please enter a valid number: ");
			return -1;
		}
	}
}
