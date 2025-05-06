package edu.citytech.cst3613.services;

import java.util.ArrayList;
import java.util.List;

import edu.citytech.cst3613.dto.Stock;

public class stockServices {

    List<Stock> getStocks(){
        var list = new ArrayList<Stock>();
        return list;
    }

    public static void main(String[] args) {
        var service = new stockServices();
        service.getStocks().forEach(System.out::println);
    }
}
