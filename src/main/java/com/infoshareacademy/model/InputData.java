package com.infoshareacademy.model;

import com.infoshareacademy.controller.SortStock;

import java.time.LocalDate;
import java.util.Comparator;

public class InputData  {

    private final LocalDate date;
    private final Double price;

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
