package com.akshara.besoftware.response;

import com.akshara.besoftware.model.Food;

import java.util.ArrayList;

public class FoodResponse extends ResponseData {
    private ArrayList<Food> data;
    public ArrayList<Food> getData() {
        return data;
    }
    public void setData(ArrayList<Food> data) {
        this.data = data;
    }
}
