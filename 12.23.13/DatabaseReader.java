import java.io.*;
import java.text.DecimalFormat;
import java.util.Hashtable;

public class DatabaseReader
{
	private String myElementSymbolOne;
	private String myElementSymbolTwo;
	private boolean isLoadSuccessful = false;
	
	ChemElement chemElementUno = new ChemElement();
	ChemElement chemElementDos = new ChemElement();
	
	//public Hashtable<String, ChemElement> chemElements = new Hashtable<String, ChemElement>();

	public DatabaseReader(String elementSymbolOne, String elementSymbolTwo)
	{
		myElementSymbolOne = elementSymbolOne;
		myElementSymbolTwo = elementSymbolTwo;
		loadElements();
	}
	
	public boolean getLoadSuccessful()
	{
		return isLoadSuccessful;
	}
	
	public void loadElements()
	{
		try
		{
			FileReader fr = new FileReader("C:\\Akaash\\Java Workspace\\ChemistryResearchProject\\ValueDatabase2.txt");
			BufferedReader br = new BufferedReader(fr);
			String theLine = "";
			
			while ((theLine = br.readLine()) != null)
			{
				String[] lineParts = theLine.split(",");
				
				String symbol = lineParts[1];
				
				int[] oxStates = new int[lineParts.length-4];
				for (int i = 4; i<lineParts.length; i++)
				{
					oxStates[i-4] = Integer.parseInt(lineParts[i]);
				}
				
				if (myElementSymbolOne.equals(symbol))
				{
					chemElementUno = new ChemElement(lineParts[0], lineParts[1], Integer.parseInt(lineParts[2]), Double.parseDouble(lineParts[3]), oxStates);
				}
				if (myElementSymbolTwo.equals(symbol))
				{
					chemElementDos = new ChemElement(lineParts[0], lineParts[1], Integer.parseInt(lineParts[2]), Double.parseDouble(lineParts[3]), oxStates);
				}
			}
			if (myElementSymbolOne.equals(chemElementUno.getSymbol()) && myElementSymbolTwo.equals(chemElementDos.getSymbol()))
				isLoadSuccessful = true;
			else if (myElementSymbolOne.equals(chemElementUno.getSymbol()) || myElementSymbolTwo.equals(chemElementDos.getSymbol()))
			{
				if (!myElementSymbolOne.equals(chemElementUno.getSymbol()))
					System.out.println("The first element's symbol is not valid.");
				if (!myElementSymbolTwo.equals(chemElementDos.getSymbol()))
					System.out.println("The second element's symbol is not valid.");
			}
			else
				System.out.println("The symbols of both elements are not valid.");
			
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void getTypeOfBond()
	{
		if (isLoadSuccessful == true)
		{
			DecimalFormat df = new DecimalFormat("#.00");
			double eNumbersDifference = Math.abs(Double.valueOf(df.format(chemElementUno.getEnNumber() - chemElementDos.getEnNumber())));
			
			if (chemElementUno.getEnNumber() == chemElementDos.getEnNumber())
				System.out.println("This is a pure covalent bond.");
			else if (eNumbersDifference == chemElementUno.getEnNumber() || eNumbersDifference == chemElementDos.getEnNumber())
				System.out.println("This compound does not exist.");
			else
			{
				if (eNumbersDifference >= 1.7)
					System.out.println("This is an ionic bond.");
				else if (eNumbersDifference < 1.7 && eNumbersDifference >= 0.3)
					System.out.println("This is a polar covalent bond.");
				else
					System.out.println("This is a covalent bond.");
			}
		}
		else {}
	}
	
	public void oxidationFinder()
	{
		if (isLoadSuccessful == true)
		{
			int[] oxStateUno = chemElementUno.getOxidationNumbers();
			int[] oxStateDos = chemElementDos.getOxidationNumbers();
			String symbolUno = chemElementUno.getSymbol();
			String symbolDos = chemElementDos.getSymbol();
			
			System.out.print("The possible bonds that the two elements can form are: ");
			for (int i = 0; i < oxStateUno.length; i++)
			{
				for (int j = 0; j < oxStateDos.length; j++)
				{
					if (Math.abs(oxStateDos[j]) == 1 && Math.abs(oxStateUno[i]) == 1)
						System.out.print(symbolUno + symbolDos + "   ");
					else if (Math.abs(oxStateDos[j]) == 1)
						System.out.print(symbolUno + symbolDos + Math.abs(oxStateUno[i]) + "   ");
					else if (Math.abs(oxStateUno[i]) == 1)
						System.out.print(symbolUno + Math.abs(oxStateDos[j]) + symbolDos + "   ");
					else
						System.out.print(symbolUno + Math.abs(oxStateDos[j]) + symbolDos + Math.abs(oxStateUno[i]) + "  ");
				}
			}
			System.out.println();
		}
		else {}
	}
	
}
