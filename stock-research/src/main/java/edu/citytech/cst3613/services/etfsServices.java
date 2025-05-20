package edu.citytech.cst3613.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jbbwebsolutions.http.utility.JSONGet.*;

import edu.citytech.cst3613.dto.etfsResult;
import edu.citytech.cst3613.dto.etfs;

public class etfsServices {
    private static final String SURL = "http://localhost:8080/stocks/etfs";
    private  static etfsResult etfsResults;
    private Map<Character, Integer> map = new HashMap<>();

    public Map<Character, Integer> getMap() {
        return map;
    }
    //intiatte
    public etfsServices() {
        etfsResults = submitGet(SURL, etfsResult.class);

        List<etfs> list = etfsResults.getData();

        for (etfs stock_ : list) {
            char c = stock_.symbol.charAt(0);

            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }
    }

    public List<etfs> getETFs(){
        return etfsResults.getData();
    }

    public static void main(String[] args) {
        var services = new etfsServices();
        services.getETFs().
                forEach(System.out::println);
        System.out.println("Developer - Yuzhen Chen");
        System.out.println(services.map);
    }

    //get acces to the fitler
    public List<etfs> getETFs(String query) {
        List<etfs> list = this.getETFs();
        //default value
        if (query.equalsIgnoreCase("All")) {
            return list;
        }
        var filterList = list.stream().filter(e -> e.symbol.startsWith(query)).toList();

        return filterList;
    }
}
