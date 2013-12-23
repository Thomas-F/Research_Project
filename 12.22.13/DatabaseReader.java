import java.io.*;
import java.text.DecimalFormat;


public class DatabaseReader 
{
	private String myElementSymbolOne;
	private String myElementSymbolTwo;
	
	public DatabaseReader(String elementSymbolOne, String elementSymbolTwo)
	{
		myElementSymbolOne = elementSymbolOne;
		myElementSymbolTwo = elementSymbolTwo;		
	}
	
	public void findTypeOfBond()
	{
		try 
		{
			FileReader fr = new FileReader("C:\\Akaash\\Java Workspace\\ChemistryResearchProject\\ValueDatabase.txt");
			BufferedReader br = new BufferedReader(fr);
			String theLine = "";
			double eNumberOne = 0;
			double eNumberTwo = 0;
			while ((theLine = br.readLine())!=null)
			{
				String[] lineParts = theLine.split(",");
				String element = lineParts[0];
				String symbol = lineParts[1];
				int atomicNumber = Integer.parseInt(lineParts[2]);
				double electronegativityNumber = Double.parseDouble(lineParts[3]);
				if (myElementSymbolOne.equals(symbol))
					eNumberOne = electronegativityNumber;
				if (myElementSymbolTwo.equals(symbol))
					eNumberTwo = electronegativityNumber;
			}
			DecimalFormat df = new DecimalFormat("#.00");
			double eNumbersDifference = Math.abs(Double.valueOf(df.format(eNumberOne-eNumberTwo)));
			if (eNumberOne == eNumberTwo)
			{
				System.out.println("This is a pure covalent bond.");
			}
			else if (eNumbersDifference==eNumberOne || eNumbersDifference==eNumberTwo)
			{
				System.out.println("This compound does not exist.");
			}
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
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
