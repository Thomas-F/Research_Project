import java.io.*;
import java.text.DecimalFormat;
import java.util.*;


public class DatabaseReader
{
	private String myElementSymbolOne;
	private String myElementSymbolTwo;
	private boolean isLoadSuccessful = false;
	private boolean isInputSameElement = false;
	public ArrayList<String> combinations = new ArrayList<String>();
	
	ChemElement chemElementUno = new ChemElement();
	ChemElement chemElementDos = new ChemElement();

	public DatabaseReader() {}
	
	public DatabaseReader(String elementSymbolOne, String elementSymbolTwo)
	{
		myElementSymbolOne = elementSymbolOne;
		myElementSymbolTwo = elementSymbolTwo;
		loadElements();
	}
	
	public ArrayList<String> getArrayListCombo() {return combinations;}
	public boolean getLoadSuccessful() {return isLoadSuccessful;}
	public boolean getInputSameElement() {return isInputSameElement;}
	
	public void loadElements()
	{
		try
		{
			FileReader fr = new FileReader("C:\\Akaash\\Java Workspace\\ChemistryResearchProject\\ValueDatabase3.txt"); 
			BufferedReader br = new BufferedReader(fr);
			String theLine = "";
			
			while ((theLine = br.readLine()) != null)
			{
				String[] lineParts = theLine.split(",");
				
				String symbol = lineParts[1];
				
				int[] oxStates = new int[lineParts.length-5];
				for (int i = 5; i<lineParts.length; i++)
				{
					oxStates[i-5] = Integer.parseInt(lineParts[i]);
				}
				
				if (myElementSymbolOne.equals(symbol))
				{
					chemElementUno = new ChemElement(lineParts[0], lineParts[1], Integer.parseInt(lineParts[2]), Integer.parseInt(lineParts[3]), Double.parseDouble(lineParts[4]), oxStates);
				}
				if (myElementSymbolTwo.equals(symbol))
				{
					chemElementDos = new ChemElement(lineParts[0], lineParts[1], Integer.parseInt(lineParts[2]), Integer.parseInt(lineParts[3]), Double.parseDouble(lineParts[4]), oxStates);
				}
			}
			if (myElementSymbolOne.equals(chemElementUno.getSymbol()) && myElementSymbolTwo.equals(chemElementDos.getSymbol()))
				isLoadSuccessful = true;
			else if (myElementSymbolOne.equals(chemElementUno.getSymbol()) || myElementSymbolTwo.equals(chemElementDos.getSymbol()))
			{
				if (!myElementSymbolOne.equals(chemElementUno.getSymbol()))
					System.out.println("The first element's symbol is not valid. Please run the program again.");
				if (!myElementSymbolTwo.equals(chemElementDos.getSymbol()))
					System.out.println("The second element's symbol is not valid. Please run the program again.");
			}
			else
				System.out.println("The symbols of both elements are not valid. Please run the program again.");
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
			double electroUno = chemElementUno.getEnNumber();
			double electroDos = chemElementDos.getEnNumber();
			
			
			if (electroDos == electroUno)
			{
				if (symbolUno.equals("H") || symbolUno.equals("O") || symbolUno.equals("F") || symbolUno.equals("Br") || symbolUno.equals("I") || symbolUno.equals("N") || symbolUno.equals("Cl"))
				{
					System.out.print("This pure covalent bond is: ");
					System.out.println("[" + symbolDos + "2].");
					isInputSameElement = true;
				}
				else
				{
					System.out.println("This compound does not exist. Please run the program again.");
					isInputSameElement = true;
				}
			}
			
			else
			{
				System.out.print("The possible bond(s) that the two elements can form is(are): ");
				for (int i = 0; i < oxStateUno.length; i++)
				{
					for (int j = 0; j < oxStateDos.length; j++)
					{
						if (electroDos > electroUno)
						{
							if (oxStateUno[i] < 0 && oxStateDos[j] > 0)
								continue;
							
							else
							{
								if (Math.abs(oxStateDos[j]) == Math.abs(oxStateUno[i]))
								{
									if (!combinations.contains(symbolUno + symbolDos))
										combinations.add(symbolUno + symbolDos);
								}	
								else if (Math.abs(oxStateDos[j]) == 1)
								{
									if (!combinations.contains(symbolUno + symbolDos + Math.abs(oxStateUno[i])))
										combinations.add(symbolUno + symbolDos + Math.abs(oxStateUno[i]));
								}
								else if (Math.abs(oxStateUno[i]) == 1)
								{
									if (!combinations.contains(symbolUno + Math.abs(oxStateDos[j]) + symbolDos))
										combinations.add(symbolUno + Math.abs(oxStateDos[j]) + symbolDos);
								}
								else
								{
									if (!combinations.contains(symbolUno + Math.abs(oxStateDos[j]) + symbolDos + Math.abs(oxStateUno[i])))
											combinations.add(symbolUno + Math.abs(oxStateDos[j]) + symbolDos + Math.abs(oxStateUno[i]));
								}
							}
						}
						else
						{
							if (oxStateDos[j] < 0 && oxStateUno[i] > 0)
							{
								continue;
							}
							else
							{
								if (Math.abs(oxStateDos[j]) == Math.abs(oxStateUno[i]))
								{
									if (!combinations.contains(symbolDos + symbolUno))
										combinations.add(symbolDos + symbolUno);
								}	
								else if (Math.abs(oxStateDos[j]) == 1)
								{
									if (!combinations.contains(symbolDos + Math.abs(oxStateUno[i]) + symbolUno))
										combinations.add(symbolDos + Math.abs(oxStateUno[i]) + symbolUno);
								}
								else if (Math.abs(oxStateUno[i]) == 1)
								{
									if (!combinations.contains(symbolDos + symbolUno + Math.abs(oxStateDos[j])))
										combinations.add(symbolDos + symbolUno + Math.abs(oxStateDos[j]));
								}
								else
								{
									if (!combinations.contains(symbolDos + Math.abs(oxStateUno[i]) + symbolUno + Math.abs(oxStateDos[j])))
											combinations.add(symbolDos + Math.abs(oxStateUno[i]) + symbolUno + Math.abs(oxStateDos[j]));
								}
							}
						}
					}
				}
				System.out.println(combinations + ".");
			}
			
		}
		else {}
	}
	
}
