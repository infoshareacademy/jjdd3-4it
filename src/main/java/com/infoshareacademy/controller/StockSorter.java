package com.infoshareacademy.controller;

import com.infoshareacademy.model.InputData;
import com.infoshareacademy.tools.StockFileReaderService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StockSorter {

    public static final Comparator<InputData> byPrice = (d1, d2) -> Double.compare(d1.getPrice(), d2.getPrice());
    public static final Comparator<InputData> byDate = (l1, l2) -> l2.getDate().compareTo(l1.getDate());

    public List<InputData> sortDataBy(List<InputData> list, Comparator<InputData> inputData) {
        return list.stream()
                .sorted(inputData)
                .limit(10)
                .collect(Collectors.toList());
    }

    public void printSortedData(Comparator<InputData> inputData) {
        List<InputData> price = sortDataBy(StockFileReaderService.readFile(), inputData);
        price.forEach(each -> {
            System.out.println(each.getDate() + "  " + each.getPrice());
        });
    }

}
