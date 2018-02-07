package com.infoshareacademy.model;

import java.time.LocalDate;

public class InputData {

    private LocalDate date;
    private Double price;

    InputData(LocalDate date, Double price) {
        this.date = date;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

}
