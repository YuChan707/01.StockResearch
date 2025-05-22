package edu.citytech.cst3613.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jbbwebsolutions.http.utility.JSONGet.*;

import edu.citytech.cst3613.dto.etfsResult;
import edu.citytech.cst3613.dto.etfs;

public class etfsServices {

    private static final String SURL = "http://localhost:8080/stocks/etfs";
    private etfsResult etfsResults;
    private final Map<Character, Integer> map = new HashMap<>();

    public Map<Character, Integer> getMap() {
        return map;
    }

    // Constructor
    public etfsServices() {
        // Fetch data from microservice
        etfsResults = submitGet(SURL, etfsResult.class);

        // Ensure we avoid null pointers
        if (etfsResults == null || etfsResults.getData() == null) {
            etfsResults = new etfsResult();
            etfsResults.setData(List.of());
        }

        List<etfs> list = etfsResults.getData();

        // Build letter-count map
        for (etfs stock_ : list) {
            if (stock_.symbol == null || stock_.symbol.isEmpty())
                continue;

            char c = stock_.symbol.charAt(0);
            map.merge(c, 1, Integer::sum);
        }
    }

    // Return full list of ETFs
    public List<etfs> getETFs() {
        return etfsResults.getData();
    }

    // Return filtered ETFs by symbol prefix

    public List<etfs> getETFs(String query) {
        List<etfs> list = this.getETFs();
        if (query.equalsIgnoreCase("All")) {
            return list;
        }
        /*
         * return list.stream()
         * .filter(e -> e.symbol != null && e.symbol.startsWith(query))
         * .toList();
         */
        return list.stream()
                .filter(e -> e.symbol != null && e.symbol.equalsIgnoreCase(query))
                .toList();
    }

    public String isRisky(float expenseRatio) {
        if (expenseRatio > 0.70f) {
            return "Dangerous Risky";
        } else {
            return "Acceptable Risk";
        }
    }

    // Manual test
    public static void main(String[] args) {
        var services = new etfsServices();
        services.getETFs().forEach(System.out::println);
        System.out.println("Developer - Yuzhen Chen");
        System.out.println(services.getMap());
    }
}
