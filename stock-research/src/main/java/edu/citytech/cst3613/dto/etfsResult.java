package edu.citytech.cst3613.dto;

import java.util.List;

public class etfsResult {
    public List<etfs> data;
    public int size;

    public List<etfs> getData() {
        return data;
    }
    public void setData(List<etfs> data) {
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
        return "etfsResult[" +
                "data=" + data +
                ", size=" + size +
                ']';
    }   
}
