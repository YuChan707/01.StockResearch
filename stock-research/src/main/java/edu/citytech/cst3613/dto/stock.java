package edu.citytech.cst3613.dto;


public class stock {
    public int rank = 0;
    public String symbol = "";
    public String companyName = "";
    public float divYield = 0;
    public float marketCapInMillions = 0;

    @Override
    public String toString(){
        return "Stock [rank = " + rank + ", symbol = " + symbol + ", companyName = " + companyName 
        + ", divYield = " + divYield + ", marketCapToBillions = " + marketCapInMillions + "]";
    }
    
}
