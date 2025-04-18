package edu.citytech.cst3613.services;

import java.util.List;
import java.util.ArrayList;

public class CounterServices {
    
    public class Digit extends Object{
        public Digit(String description, int number) {
            this.description = description;
            this.number = number;
        }
        @Override
        public String toString() {
            return "Digit [description=" + description + ", number=" + number + "]";
        }
        public final String description; final int number;
    };
    private List<Digit> listOfNumbers = new ArrayList<Digit>();
    public List<Digit> getNumbers() {
        return this.listOfNumbers;
    }

    public CounterServices(){
        listOfNumbers.add(new Digit("One", 1));
        listOfNumbers.add(new Digit("Two", 2));
        listOfNumbers.add(new Digit("Three", 3));
        listOfNumbers.add(new Digit("Four", 4));
        listOfNumbers.add(new Digit("Five", 5));
        listOfNumbers.add(new Digit("Six", 6));
        listOfNumbers.add(new Digit("Seven", 7));
        listOfNumbers.add(new Digit("Eight", 8));
        listOfNumbers.add(new Digit("Nine", 9));
        listOfNumbers.add(new Digit("Ten", 10));    
        listOfNumbers.add(new Digit("Eleven", 11));
        listOfNumbers.add(new Digit("Twelve", 12));
        listOfNumbers.add(new Digit("Thirteen", 13));
        listOfNumbers.add(new Digit("Fourteen", 14));
        listOfNumbers.add(new Digit("Fifteen", 15));
        listOfNumbers.add(new Digit("Sixteen", 16));
        listOfNumbers.add(new Digit("Seventeen", 17));
        listOfNumbers.add(new Digit("Eighteen", 18));
        listOfNumbers.add(new Digit("Nineteen", 19));
        listOfNumbers.add(new Digit("Twenty", 20));
        listOfNumbers.add(new Digit("Twenty One", 21));
        listOfNumbers.add(new Digit("Twenty Two", 22));
        listOfNumbers.add(new Digit("Twenty Three", 23));
        listOfNumbers.add(new Digit("Twenty Four", 24));
        listOfNumbers.add(new Digit("Twenty Five", 25));
        listOfNumbers.add(new Digit("Twenty Six", 26));
        listOfNumbers.add(new Digit("Twenty Seven", 27));
        listOfNumbers.add(new Digit("Twenty Eight", 28));
        listOfNumbers.add(new Digit("Twenty Nine", 29));
        listOfNumbers.add(new Digit("Thirty", 30));
    }

    public static void main(String[] args) {
        CounterServices cs = new CounterServices();
        cs.getNumbers().forEach(System.out::println);
        System.out.println("DEVELOPER - Yuzhen Chen "+ new java.util.Date());
    }
}
