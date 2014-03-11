package edu.vcs.chemproject;

public class PolyIon {

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

    public int getOxidationNumbers() {
        return ionicState;
    }

    public void setOxidationNumbers(int oxidationNumbers) {
        this.ionicState = ionicState;
    }

    public String getRevisedSymbol() {
        return revisedSymbol;
    }

    public void setRevisedSymbol(String revisedSymbol) {
        this.revisedSymbol = revisedSymbol;
    }

    private String name;
    private String symbol;
    private int ionicState;
    private String revisedSymbol;

    public PolyIon() {
        //Empty Constructor
    }

    public PolyIon(String pName, String pSymbol, int pIonicState, String pRevisedSymbol) {
        name = pName;
        symbol = pSymbol;
        ionicState = pIonicState;
        revisedSymbol = pRevisedSymbol;
    }
}
