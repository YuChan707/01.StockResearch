package edu.citytech.cst3613.dto;

import java.util.List;

public class stockResult {
    public List<stock> data;
    public int size;

    public List<stock> getData() {
        return data;
    }

    public void setData(List<stock> data) {
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
        return "stockResult[" +
                "data=" + data +
                ", size=" + size +
                ']';
    }
}
