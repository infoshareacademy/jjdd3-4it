package com.infoshareacademy.controller;

import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.model.InputData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortDataStock {

    public List<InputData> readFile() {
        String pathToFile = "src/main/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();
        return importStock.getResources();
    }


    public List<InputData> sortDataBy(List<InputData> list, int count) {

        Comparator<InputData> byPrice = (d1, d2) -> Double.compare(d1.getPrice(), d2.getPrice());
        Comparator<InputData> byDate = (l1, l2) -> l2.getDate().compareTo(l1.getDate());

        return list.stream()
                .sorted(count == 0 ? byPrice : byDate)
                .limit(10)
                .collect(Collectors.toList());
    }

    public void printSortData() {
        List<InputData> price = sortDataBy(readFile(),1);
        price.forEach(each -> {
            System.out.println(each.getDate() + "  " + each.getPrice());
        });
    }



}

