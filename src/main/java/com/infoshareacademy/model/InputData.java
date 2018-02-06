package com.infoshareacademy.model;

import java.time.LocalDate;

public class InputData {

    private String price;
    private String date;

    InputData(String price, String date) {
        this.price = price;
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

}
