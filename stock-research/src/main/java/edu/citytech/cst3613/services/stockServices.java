package edu.citytech.cst3613.services;

import java.util.ArrayList;
import java.util.List;
import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.cst3613.dto.Stock;

public class stockServices {
    private static final String SURL = "https://localhost:8000/stocks/dividends";

    List<Stock> getStocks(){
        var stockResult = submitGet(SURL, Stock.class);

        System.out.println(stockResult);
        var list = new ArrayList<Stock>();
        return list;
    }

    public static void main(String[] args) {
        var service = new stockServices();
        service.getStocks().forEach(System.out::println);
    }
}
