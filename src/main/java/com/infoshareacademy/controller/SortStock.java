package com.infoshareacademy.controller;

//import com.sun.java.util.jar.pack.ConstantPool;

import java.util.ArrayList;
import java.util.Collections;

public class SortStock {

    private int dateFrom = 0;
    private int dateFor = 3;
    private boolean isMax;

    private double priceMax;
    private double priceMin;


    private double varPriceforMinMaxLoop;
    private int startDateForMinMaxLoop;
    private int endDateForMinMaxLoop;


    private double avveragePrice;
    private double medianPrice;


    ArrayList<Double> list = new ArrayList<Double>();
    ArrayList<Double> listHelp = new ArrayList<Double>();


    public void listavar() {
        list.add(2.6);
        list.add(4.0);
        list.add(7.3);
        list.add(99.0);
        list.add(7.6);
        list.add(0.1);
        list.add(44.1);
        list.add(8.3);
        list.add(65.4);
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
        avveragePrice = avveragePrice / (dateFrom - dateFor);
        return avveragePrice;
    }
}

//    //  to jest mi potrzebne  do liczenia mediany

//    public void sortAndRemoveThingsInListForMedian() {
//        int helpDateAlmostInMediumPlace = dateFrom - dateFor;
//        for (int i = dateFrom; i < dateFor; i++) {
//            listHelp.add(list.get(i));
//            System.out.println(list.get(i));
//        }
//        Collections.sort(listHelp);
//        System.out.println("***************");
//        System.out.println(listHelp);
//        int x4;
//        if (helpDateAlmostInMediumPlace % 2 != 0) {
//
//
//            return;
//        } else {
//            x4 = x2 - 1;
//            x4 = x4 / 2;
//        }
//        System.out.println(listHelp.get(x4));
//
//    }
//}


//    }
//    ------------->


//    public int methodMedian() {
////medianY=list.get(x2)-
////         number=(yMax-yMin)/2;
////        return number;
//    }




