package edu.citytech.cst3613.dto;

import java.util.List;

public class etfsResult {
    public List<etfs> ETFs_data;
    public int size;
    public String Developver;

    public List<etfs> getData() {
        return ETFs_data;
    }
    public void setData(List<etfs> data) {
        this.ETFs_data = data;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return "Data[" +
                "data = " + ETFs_data +
                ", size=" + size +
                ']';
    }   
}
