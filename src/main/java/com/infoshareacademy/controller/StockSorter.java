package com.infoshareacademy.controller;

import com.infoshareacademy.model.InputData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StockSorter {

    public static final Logger LOG = LoggerFactory.getLogger(StockSorter.class);

    public static final Comparator<InputData> byPrice = (d1, d2) -> Double.compare(d1.getPrice(), d2.getPrice());
    public static final Comparator<InputData> byDate = (l1, l2) -> l1.getDate().compareTo(l2.getDate());

    public List<InputData> sortDataBy(List<InputData> list, Comparator<InputData> inputData, LocalDate start, LocalDate end) {
        return list.stream()
                .filter(p ->
                        p.getDate().isEqual(start) ||
                        p.getDate().isEqual(end) ||
                        p.getDate().isAfter(start) &&
                        p.getDate().isBefore(end))
                .sorted(inputData)
                .collect(Collectors.toList());

    }

}
