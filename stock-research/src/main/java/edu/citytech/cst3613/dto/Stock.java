package edu.citytech.cst3613.dto;

import java.util.List;

public class Stock {
    private List<String> data;
    private int size;

    public List<String> getData() {
        return data;
    }
    public void setData(List<String> data) {
        this.data = data;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return "Stock[]" +
                "data=" + data +
                ", size=" + size +
                ']';
    }
}
