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

public class SortStock {

    private int dateFrom = 31;
    private int dateFor = 365;

    private double priceMax;
    private double priceMin;
    private double averagePrice;
    private double medianPrice;

    List<InputData> listHelp = new ArrayList<InputData>();
    //  ArrayList<Double> listHelp2 = new ArrayList<Double>();
    List<Double> listForHelp = new ArrayList<Double>();

    static ImportStock importStock = new ImportStock("src/main/resources/bitCoin.csv");
    static InputData inputData;

//    public double priceMinForRange(List<InputData> resources) {
//        priceMin = Double.MAX_VALUE;
//        for (int i = dateFrom; i < dateFor; i++) {
//            if (priceMin > resources.get(i).getPrice()) {
//                priceMin = resources.get(i).getPrice();
//            }
//        }
//        return priceMin;
//    }
//
//    public double priceMaxForRange(List<InputData> resources) {
//        priceMax = Double.MIN_VALUE;
//        for (int i = dateFrom; i < dateFor; i++) {
//            if (priceMax < resources.get(i).getPrice()) {
//                priceMax = resources.get(i).getPrice();
//            }
//        }
//        return priceMax;
//
//    }
//
//
//    public double averragePriceForRange(List<InputData> resources) {
//        for (int i = dateFrom; i < dateFor; i++) {
//            averagePrice += resources.get(i).getPrice();
//        }
//        averagePrice /= (dateFor - dateFrom);
//
//        return averagePrice;
//    }
//
//
//    public double medianPriceForRange(List<InputData> resources) {
//
//        for (int i = dateFrom; i < dateFor; i++) {
//            listHelp.add(resources.get(i).getPrice());
//
//        }
//        Collections.sort(listHelp);
//        int medianRange = dateFor - dateFrom;
//        if (medianRange % 2 != 0) {
//            medianRange = (medianRange - 1) / 2;
//            medianPrice = listHelp.get(medianRange);
//            return medianPrice;
//
//        } else {
//            medianRange = medianRange / 2;
//            medianPrice = (listHelp.get(medianRange) + listHelp.get(medianRange - 1)) / 2;
//            return medianPrice;
//        }
//
//    }


    //-------------------------------------------------------------------------->Stream

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


//
    public void priceMinStream(List<Double> resources) {
       // streamList(resources);
        System.out.println(resources.stream().min((p1, p2) -> Double.compare(p1, p2)).get());

    }

//
//
//
//    public void priceMinStream(List<InputData> resources) {
//
//listHelp.stream().mapToDouble((p1,p2) ->
//
//       listHelp.stream().sorted((p1, p2) -> Double.compare(p1,
//
//    }


}

