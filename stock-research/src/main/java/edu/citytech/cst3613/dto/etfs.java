package edu.citytech.cst3613.dto;

public class etfs {
    public int rank;
    public String fundName;
    public String symbol;
    public float price;
    public float quantRating;
    public float aumInBillion;
    public String frequency;
    public String payOutDate;
    public float expenseRatio;

    @Override
    public String toString() {
        return "etfs [symbol = "+ symbol +"rank = " + rank + ", fundName = " + fundName + ", price = " + price
                + ", quantRating = " + quantRating + ", aumInBillion = " + aumInBillion
                + ", frequency = " + frequency + ", payOutDate = " + payOutDate
                + ", expenseRatio = " + expenseRatio + "]";
    }
}

