import java.io.*;
import java.util.ArrayList;
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
		
		DatabaseReader myDatabaseReader = new DatabaseReader(symbolOne, symbolTwo);
		myDatabaseReader.oxidationFinder();
		
		if (myDatabaseReader.getLoadSuccessful() == true && myDatabaseReader.getInputSameElement() == false)
		{			
			while (true)
			{
				System.out.print("Choose a bond present above: ");
				String myChoice = myScanner.nextLine();
				theChosenOne = myChoice;
				if (myDatabaseReader.getArrayListCombo().contains(theChosenOne))
				{
					System.out.println("You have chosen " + theChosenOne + ".");
					break;
				}
				else
				{
					System.out.println("This is not one of the bonds present above. Please try again. ");
				}
			}	
		}
		else {}
	}
}
