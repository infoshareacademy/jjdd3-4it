package com.infoshareacademy.controller;

import com.infoshareacademy.model.InputData;

import java.util.List;

public class SearchStock {

    public InputData printPriceMax(List<InputData> resources) {

        return resources.stream().max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).get();
    }

    public InputData printPriceMin(List<InputData> resources) {

        return resources.stream().min((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).get();
    }
}
