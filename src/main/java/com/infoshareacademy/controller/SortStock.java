package com.infoshareacademy.controller;

//import com.sun.java.util.jar.pack.ConstantPool;

import java.util.ArrayList;
import java.util.Collections;

public class SortStock {

    private int dateFrom = 0;
    private int dateFor = 3;
    private boolean isMax=true;

    private double priceMinFullRange;
    private double priceMaxFullRange;
    private double priceMax;
    private double priceMin;

    private double avveragePrice;
    private double medianPrice;



    ArrayList<Double> list = new ArrayList<Double>();
    ArrayList<Integer> listHelp = new ArrayList<Integer>();


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
        double varMaxMin;
        int date1;
        int date2;

        for (int i = date1; i < date2; i++) {
            if (isMax) {
                while (list.get(i) > varMaxMin) {
                    varMaxMin = list.get(i);
                }
            } else {
                while (list.get(i) < varMaxMin) {
                    varMaxMin = list.get(i);
                }
            }
            return varMaxMin;
        }





        public int maxPrice () {

            priceMax = minPriceFullRange();
            date1 = dateFrom;
            date2 = dateFor;

            minMaxLoop();

        }


        public int minPriceFullRange () {
            double priceMaxFullRange;
            date1 = 0;
            date2 = list.size();
            minMaxLoop();
            return priceMaxFullRange;
        }


        public int maxPriceFullRange () {
            double priceMaxFullRange;
            date1 = 0;
            date2 = list.size();
            minMaxLoop();
            return priceMaxFullRange;
        }


        public int methodMax () {
            yMax = methodMinFullRange();
            for (int i = x1; i < x2; i++) {
                if (list.get(i) > yMax) {
                    yMax = list.get(i);
                }
            }
            return yMax;
        }


        public int methodMaxFullRange () {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > yMaxFullRange) {
                    yMaxFullRange = list.get(i);
                }
            }
            return yMaxFullRange;
        }


        public int methodMin () {
            yMin = methodMaxFullRange();
            for (int i = x1; i < x2; i++) {
                if (list.get(i) < yMin) {
                    yMin = list.get(i);
                }
            }
            return yMin;
        }


        public int methodMinFullRange () {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < yMinFullRange) {
                    yMinFullRange = list.get(i);
                }
            }
            return yMinFullRange;
        }


        public int methodAverrage () {
            for (int i = x1; i < x2; i++) {
                avverageY = avverageY + list.get(i);
            }
            avverageY = avverageY / (x2 - x1);
            return avverageY;
        }


        public void sortAndRemoveThingsInListForMedian () {
            int x3 = x2 - x1;
            // x1 do x2
            for (int i = x1; i < x2; i++) {
                listHelp.add(list.get(i));
                System.out.println(list.get(i));
            }

            Collections.sort(listHelp);
            System.out.println("***************");
            System.out.println(listHelp);
            int x4;
            if (x3 % 2 != 0) {


                return;
            } else {
                x4 = x2 - 1;
                x4 = x4 / 2;
            }
            System.out.println(listHelp.get(x4));

        }


    }
//    ------------->












//    public int methodMedian() {
////medianY=list.get(x2)-
////         number=(yMax-yMin)/2;
////        return number;
//    }




