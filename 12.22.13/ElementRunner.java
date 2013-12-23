import java.io.*;
import java.util.Scanner;

public class ElementRunner 
{	
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter two elements that you would like to find the properties of their bond.");
		System.out.print("Enter element 1:");
		String symbolOne = myScanner.nextLine();
		System.out.print("Enter element 2:");
		String symbolTwo = myScanner.nextLine();
		myScanner.close();
		DatabaseReader myDatabaseReader = new DatabaseReader(symbolOne, symbolTwo);
		myDatabaseReader.findTypeOfBond();
	}
}
