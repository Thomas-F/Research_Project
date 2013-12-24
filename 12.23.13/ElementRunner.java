import java.io.*;
import java.util.Scanner;

public class ElementRunner
{
	
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		String theChosenOne = null;
		
		System.out.println("Enter the symbols of two elements of which you would like to find the properties of their bond.");
		System.out.print("Enter Element One's Symbol:");
		String symbolOne = myScanner.nextLine();
		System.out.print("Enter Element Two's Symbol:");
		String symbolTwo = myScanner.nextLine();
		//myScanner.close();
		
		DatabaseReader myDatabaseReader = new DatabaseReader(symbolOne, symbolTwo);
		myDatabaseReader.oxidationFinder();
		if (myDatabaseReader.getLoadSuccessful() == true)
		{
			System.out.print("Choose one of the bonds present above: ");
			String myChoice = myScanner.nextLine();
			theChosenOne = myChoice;
			System.out.println("You have chosen " + theChosenOne);
		}
		else {}
		
		//myDatabaseReader.getTypeOfBond();
	}
}
