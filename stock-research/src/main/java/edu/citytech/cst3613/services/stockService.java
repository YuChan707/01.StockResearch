package edu.citytech.cst3613.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jbbwebsolutions.http.utility.JSONGet.*;
import edu.citytech.cst3613.dto.stock;
import edu.citytech.cst3613.dto.stockResult;

public class stockService {
    private static final String SURL = "http://localhost:8080/stocks/dividends";
    private  static stockResult stockResults;
    private Map<Character, Integer> map = new HashMap<>();

    public Map<Character, Integer> getMap() {
        return map;
    }
    //intiatte
    public stockService() {
        stockResults = submitGet(SURL, stockResult.class);

        List<stock> list = stockResults.getData();

        for (stock stock_ : list) {
            char c = stock_.symbol.charAt(0);

            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }
    }

    public List<stock> getStocks(){
        return stockResults.getData();
    }

    public static void main(String[] args) {
        var services = new stockService();
        services.getStocks().
                forEach(System.out::println);
        System.out.println("Developer - Yuzhen Chen");
        System.out.println(services.map);
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
