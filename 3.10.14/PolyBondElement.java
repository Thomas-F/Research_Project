package edu.vcs.chemproject;

public class PolyBondElement {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public double getEnNumber() {
        return enNumber;
    }

    public void setEnNumber(double enNumber) {
        this.enNumber = enNumber;
    }

    public int[] getOxidationNumbers() {
        return oxidationNumbers;
    }

    public void setOxidationNumbers(int[] oxidationNumbers) {
        this.oxidationNumbers = oxidationNumbers;
    }

    private String name;
    private String symbol;
    private int atomicNumber;
    private double enNumber;
    private int[] oxidationNumbers;

    public PolyBondElement() {
        //Empty Constructor
    }

    public PolyBondElement(String pName, String pSymbol, int pAtomicNumber, double pEnNumber, int[] pOxidationNumbers) {
        name = pName;
        symbol = pSymbol;
        atomicNumber = pAtomicNumber;
        enNumber = pEnNumber;
        oxidationNumbers = pOxidationNumbers;
    }
}
