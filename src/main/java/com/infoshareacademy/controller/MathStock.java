package com.infoshareacademy.controller;

import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.model.InputData;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MathStock {

    private ImportStock importStock = new ImportStock("src/main/resources/bitCoin.csv");
    private InputData inputData;

    private double averagePrice;
    private double medianPrice;

    List<Double> listHelp = new ArrayList<Double>();


    public double averragePriceForRange(List<InputData> resources) {


        for (int i = 0; i < resources.size(); i++) {
            averagePrice += resources.get(i).getPrice();
        }
        averagePrice /= (resources.size());

        return averagePrice;
    }


    public double medianPriceForRange(List<InputData> resources) {
        for (int i = 0; i < resources.size(); i++) {
            listHelp.add(resources.get(i).getPrice());

        }
        Collections.sort(listHelp);
        int medianRange = resources.size();
        if (medianRange % 2 != 0) {
            medianRange = (medianRange - 1) / 2;
            medianPrice = listHelp.get(medianRange);
            return medianPrice;

        } else {
            medianRange = medianRange / 2;
            medianPrice = (listHelp.get(medianRange) + listHelp.get(medianRange - 1)) / 2;
            return medianPrice;
        }

    }


    public List<InputData> streamList(List<InputData> resources, LocalDate start, LocalDate end) {

        return resources.stream()
                .filter(p -> p.getDate()
                        .isAfter(start) && p.getDate()
                        .isBefore(end))
                .collect(Collectors.toList());
    }


    public void printPriceMax(List<InputData> resources) {

        System.out.println(resources.stream().max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).get().getPrice());
    }

    public void printPriceMin(List<InputData> resources) {

        System.out.println(resources.stream().min((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).get().getPrice());
    }


}

