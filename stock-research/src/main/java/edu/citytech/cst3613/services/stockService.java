package edu.citytech.cst3613.services;


import java.util.List;
import static com.jbbwebsolutions.http.utility.JSONGet.*;
import edu.citytech.cst3613.dto.stock;
import edu.citytech.cst3613.dto.stockResult;

public class stockService {
    private static final String SURL = "http://localhost:8080/stocks/dividends";
    private  static stockResult stockResults;

    //intiatte
    public stockService() {
        stockResults = submitGet(SURL, stockResult.class);
    }

    public List<stock> getStocks(){
        return stockResults.getData();
    }

    public static void main(String[] args) {
        var services = new stockService();
        services.getStocks().
                forEach(System.out::println);
    }

    //get acces to the fitler
    public List<stock> getStocks(String query) {
        List<stock> list = this.getStocks();
        //default value
        if (query.equalsIgnoreCase("All")) {
            return list;
        }
        var filterList = list.stream().filter(e -> e.symbol.startsWith(query)).toList();

        return filterList;
    }
}
