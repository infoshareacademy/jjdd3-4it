package com.infoshareacademy.controller;

import com.infoshareacademy.model.InputData;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SearchStock {



    public double printPriceMax(List<InputData> resources) {

        return resources.stream().max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).get().getPrice();
    }

    public double printPriceMin(List<InputData> resources) {

        return resources.stream().min((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).get().getPrice();
    }
}
