import java.io.*;

public class ChemElement
{
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getSymbol() {return symbol;}
	public void setSymbol(String symbol) {this.symbol = symbol;}
	public int getAtomicNumber() {return atomicNumber;}
	public void setAtomicNumber(int atomicNumber) {this.atomicNumber = atomicNumber;}
	public int getNumberOfValElectrons() {return numberOfValElectrons;}
	public void setNumberOfValElectrons(int numberOfValElectrons) {this.numberOfValElectrons = numberOfValElectrons;}
	public double getEnNumber()	{return enNumber;}
	public void setEnNumber(double enNumber) {this.enNumber = enNumber;}
	public int[] getOxidationNumbers() {return oxidationNumbers;}
	public void setOxidationNumbers(int[] oxidationNumbers)	{this.oxidationNumbers = oxidationNumbers;}

	private String name;
	private String symbol;
	private int atomicNumber;
	private int numberOfValElectrons;
	private double enNumber;
	private int[] oxidationNumbers;

	public ChemElement() 
	{
		//Empty Constructor
	}
	
	public ChemElement(String pName, String pSymbol, int pAtomicNumber, int pNumberOfValElectrons, double pEnNumber, int[] pOxidationNumbers)
	{
		name = pName;
		symbol = pSymbol;
		atomicNumber = pAtomicNumber;
		numberOfValElectrons = pNumberOfValElectrons;
		enNumber = pEnNumber;
		oxidationNumbers = pOxidationNumbers;
	}
}
