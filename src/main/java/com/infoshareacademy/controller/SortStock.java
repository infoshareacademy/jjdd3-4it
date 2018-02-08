package com.infoshareacademy.controller;

//import com.sun.java.util.jar.pack.ConstantPool;

import java.util.ArrayList;
import java.util.Collections;

public class SortStock {

    private int dateFrom = 2;
    private int dateFor = 7;
    private boolean isMax;

    private double priceMax;
    private double priceMin;
    private double avveragePrice;

    private double varPriceforMinMaxLoop;
    private int startDateForMinMaxLoop;
    private int endDateForMinMaxLoop;


    private double medianPrice;


    ArrayList<Double> list = new ArrayList<Double>();
    ArrayList<Double> listHelp = new ArrayList<Double>();


    public void listavar() {
        list.add(2.6);
        list.add(5.0);
        list.add(2.3);
        list.add(9.0);
        list.add(7.6);
        list.add(0.1);
        list.add(4.1);
        list.add(8.3);
        list.add(5.4);
        list.add(8.9);
    }


    private double minMaxLoop() {


        for (int i = startDateForMinMaxLoop; i < endDateForMinMaxLoop; i++) {
            if (isMax) {
                while (list.get(i) > varPriceforMinMaxLoop) {
                    varPriceforMinMaxLoop = list.get(i);
                }
            } else {
                while (list.get(i) < varPriceforMinMaxLoop) {
                    varPriceforMinMaxLoop = list.get(i);
                }
            }

        }
        return varPriceforMinMaxLoop;

    }

    public double maxPrice() {
        varPriceforMinMaxLoop = minPriceFullRange();
        isMax = true;
        startDateForMinMaxLoop = dateFrom;
        endDateForMinMaxLoop = dateFor;
        priceMax = minMaxLoop();
        return priceMax;
    }


    public double minPriceFullRange() {
        isMax = false;
        startDateForMinMaxLoop = 0;
        endDateForMinMaxLoop = list.size();
        return minMaxLoop();
    }


    public double minPrice() {
        varPriceforMinMaxLoop = maxPriceFullRange();
        isMax = false;
        startDateForMinMaxLoop = dateFrom;
        endDateForMinMaxLoop = dateFor;
        priceMin = minMaxLoop();
        return priceMin;
    }


    public double maxPriceFullRange() {
        isMax = true;
        startDateForMinMaxLoop = 0;
        endDateForMinMaxLoop = list.size();
        return minMaxLoop();
    }


    public double averragePriceFromRage() {
        for (int i = dateFrom; i < dateFor; i++) {
            avveragePrice = avveragePrice + list.get(i);
        }
        avveragePrice = avveragePrice / (dateFor - dateFrom);
        return avveragePrice;
    }


    public void gettingRemovesSortAndExportElementsFromListToListHelpForFindMedian() {

        for (int i = dateFrom; i < dateFor; i++) {
            listHelp.add(list.get(i));
            System.out.println(list.get(i));
        }
        Collections.sort(listHelp);

        System.out.println("***************");
        System.out.println(listHelp);

        int medianRange = dateFor - dateFrom;
        if (medianRange % 2 != 0) {
            medianRange = (medianRange - 1) / 2;
            medianPrice = listHelp.get(medianRange);
            System.out.println(medianPrice);

        } else {
            medianRange = medianRange / 2;
            medianPrice = (listHelp.get(medianRange) + listHelp.get(medianRange - 1)) / 2;
            System.out.println(medianPrice);
        }

    }


}

