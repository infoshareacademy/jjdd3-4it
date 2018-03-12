package com.infoshareacademy.controller;

import com.infoshareacademy.model.InputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchStock {
    private static final Logger LOG = LoggerFactory.getLogger(SearchStock.class);
    public InputData printPriceMax(List<InputData> resources) {
        LOG.info("Max value Price is compute");
        return resources.stream().max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).get();
    }

    public InputData printPriceMin(List<InputData> resources) {
        LOG.info("Min value Price is compute");
        return resources.stream().min((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).get();
    }
}
