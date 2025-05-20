package edu.citytech.cst3613.dto;

public class etfs {
    public int rank;
    public String symbol;
    public String fundName;
    public double price;
    public String quantRating;
    public double aumInBillion;
    public String frequency;
    public String payOutDate;
    public String expenseRatio;

    @Override
    public String toString() {
        return "etfs [symbol = "+ symbol +", rank = " + rank + ", fundName = " + fundName + ", price = " + price
                + ", quantRating = " + quantRating + ", aumInBillion = " + aumInBillion
                + ", frequency = " + frequency + ", payOutDate = " + payOutDate
                + ", expenseRatio = " + expenseRatio + "]";
    }
}

