package edu.handong.csee.java.lab06; //package name

import java.util.Scanner; //import Scanner class to get input from user

/**
 * This class defines a Cesco object. 
 * When you input the house volume value and the initial value of the bugs in the house,
 * you can get the total number of the bugs, the total bug volume,and the number of weeks taken until the house is full of bugs.
 * The growth rate of bugs is fixed at 0.95 and one bug volume is fixed at 0.002. 
 * @author jo jeong hoon
 *
 */
public class Cesco { //define Cesco object

	final double GROWTH_RATE = 0.95; //instance variable
	final double ONE_BUG_VOLUME = 0.002;  //instance variable
	
	
	/**
	 * starts this program
	 * @param args refers command-line arguments as an array of String objects.
	 */
	public static void main(String[] args) { //main method to initiate this program
	
		Scanner keyboard = new Scanner(System.in); // instantiate Scanner object
		Cesco myCesco = new Cesco(); //instantiate Cesco object

		System.out.println("Enter the total volume of your house in cubic feet: "); //print the line on console
		double houseVolume = keyboard.nextInt(); //local variable & get houseVolume value
		System.out.println("Enter the estimated number of roaches in your house: "); //print the line on console
		double startPopulation = keyboard.nextInt(); //local variable & get the number of bugs value
		
		myCesco.calculateBugPopulation(houseVolume, startPopulation); //the instance myCesco do the calculateBugPopulation method
	}

	/**
	 * calculates the number of weeks, total bug population, and the number of weeks taken
	 * and shows the results
	 * @param houseVolume refers to the volume of the house
	 * @param startPopulation refers to the initial population of bugs
	 */
	public void calculateBugPopulation(double houseVolume, double startPopulation) { //define calculateRoachPopulation method
		
		double population = startPopulation; //local variable
		double totalBugVolume = population * ONE_BUG_VOLUME;  //local variable
 		double newBugs; //local variable
		
		int countWeeks = 0; //local variable
		
		while(totalBugVolume < houseVolume) { //repeats the statements while totalBugVolume is smaller than houseVolume  
			
			newBugs = population * GROWTH_RATE; //the number of newBugs is defined by multiplying population by GROWTH RATE
			population += newBugs; //(current)population is defined by adding the number of new bugs to (past)population
			
			totalBugVolume = population * ONE_BUG_VOLUME; //totalBugVolume is defined by multiplying population by ONE_BUG_VOLUME
			countWeeks ++; //the number of weeks increases by one when the loop executed once
		}
		
		System.out.println("Starting with a bug population of " + startPopulation); //print startPopulation value
		System.out.println("and a house with a volume of " + houseVolume +" cubic feet."); //print houseVolume value
		System.out.println("After " + countWeeks + " weeks,"); //print the number of weeks taken until the house is full of bugs
		System.out.println("the house will be filled with " + (int)population + " roaches."); //print the population of bugs which fill the whole house
		System.out.println("And they will fill a volume of " + (int)totalBugVolume + " cubic feet."); //print the totalBugVolume >>JC how the totalBugVolume(33239) is larger than the houseVolume(20000)?
		System.out.println("Better call Debugging Experts Inc."); //print the recommendation
	}
}














