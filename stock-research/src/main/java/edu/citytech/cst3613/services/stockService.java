package edu.citytech.cst3613.services;


import java.util.List;
import static com.jbbwebsolutions.http.utility.JSONGet.*;
import edu.citytech.cst3613.dto.stock;
import edu.citytech.cst3613.dto.stockResult;

public class stockService {
    private static final String SURL = "http://localhost:8080/stocks/dividends";

    public List<stock> getStocks(){
        var stockResults = submitGet(SURL, stockResult.class);
        return stockResults.getData();
    }

    public static void main(String[] args) {
        var services = new stockService();
        services.getStocks().
                forEach(System.out::println);
    }
}
