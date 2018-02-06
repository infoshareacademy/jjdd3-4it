package com.infoshareacademy.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class SortStock {


    private int yMinFullRange;
    private int yMaxFullRange;
    private int yMax;
    private int yMin;
    private int avverageY;


    private int x1 = 8;
    private int x2 = 11;


    ArrayList<Integer> list = new ArrayList<Integer>();

    public void listavar() {
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(99);
        list.add(7);
        list.add(0);
        list.add(44);
        list.add(8);
        list.add(65);
        list.add(8);
        list.add(4);
    }


    public int methodMax() {
        ;
        yMax = methodMinFullRange();
        for (int i = x1; i < x2; i++) {
            if (list.get(i) > yMax) {
                yMax = list.get(i);
            }
        }
        return yMax;
    }


    public int methodMin() {
        yMin = methodMaxFullRange();
        for (int i = x1; i < x2; i++) {
            if (list.get(i) < yMin) {
                yMin = list.get(i);
            }
        }
        return yMin;
    }


    public int methodMaxFullRange() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > yMaxFullRange) {
                yMaxFullRange = list.get(i);
            }
        }
        return yMaxFullRange;
    }


    public int methodMinFullRange() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < yMinFullRange) {
                yMinFullRange = list.get(i);
            }
        }
        return yMinFullRange;
    }


    public int methodAverrage() {

        for (int i = 0; i < list.size(); i++) {
            avverageY = avverageY + list.get(i);
        }
        avverageY = avverageY / list.size();
        return avverageY;
    }
}
