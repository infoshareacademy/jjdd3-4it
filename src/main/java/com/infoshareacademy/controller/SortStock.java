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

    private int dateFrom = 0;
    private int dateFor = 150;


    private double priceMax;
    private double priceMin;
    private double averagePrice;
    private double medianPrice;

    ArrayList<Double> listHelp = new ArrayList<Double>();

   List<Double> listForHelp = new ArrayList<Double>();

    static ImportStock importStock = new ImportStock("src/main/resources/bitCoin.csv");
    static InputData inputData;

    public double priceMinForRange(List<InputData> resources) {
        priceMin = Double.MAX_VALUE;
        for (int i = dateFrom; i < dateFor; i++) {
            if (priceMin > resources.get(i).getPrice()) {
                priceMin = resources.get(i).getPrice();
            }
        }
        return priceMin;
    }

    public double priceMaxForRange(List<InputData> resources) {
        priceMax = Double.MIN_VALUE;
        for (int i = dateFrom; i < dateFor; i++) {
            if (priceMax < resources.get(i).getPrice()) {
                priceMax = resources.get(i).getPrice();
            }
        }
        return priceMax;

    }


    public double averragePriceForRange(List<InputData> resources) {
        for (int i = dateFrom; i < dateFor; i++) {
            averagePrice += resources.get(i).getPrice();
        }
        averagePrice /= (dateFor - dateFrom);

        return averagePrice;
    }


    public double medianPriceForRange(List<InputData> resources) {

        for (int i = dateFrom; i < dateFor; i++) {
            listHelp.add(resources.get(i).getPrice());

        }
        Collections.sort(listHelp);
        int medianRange = dateFor - dateFrom;
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


    //-------------------------------------------------------------------------->Stream
//    public double priceMinForRange(List<InputData> resources) {
//        priceMin = Double.MAX_VALUE;
//        for (int i = dateFrom; i < dateFor; i++) {
//            if (priceMin > resources.get(i).getPrice()) {
//                priceMin = resources.get(i).getPrice();
//            }
//        }
//        return priceMin;
//    }
    public void priceMinForRangeStream(List<InputData> resources) {

//        final List <Integer> listForHelp
//                = IntStream.range(dateFrom, dateFor).boxed().collect(Collectors.toList());
//

        LocalDate def1=LocalDate.of(2017, Month.JANUARY,1);
        LocalDate def2=LocalDate.of(2017, Month.MARCH,31);


        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusDays(9);


        List<InputData> listHelp = resources.stream().filter(p ->  p.getDate().isAfter(def1) && p.getDate().isBefore(def2)).collect(Collectors.toList());


        Comparator<InputData> comp = (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice());
            System.out.println(listHelp.stream().max(comp).get().getPrice());
            System.out.println(listHelp.stream().min(comp).get().getPrice());


//        IntStream intStream = IntStream.range(dateFrom, dateFor);
//resources.stream()                    p1.getPrice(), p2.getPrice()



    }



}

