package com.infoshareacademy.controller;

//import com.sun.java.util.jar.pack.ConstantPool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SortStock {


    private int yMinFullRange;
    private int yMaxFullRange;
    private int yMax;
    private int yMin;
    private int avverageY;
private int medianY;

    private int x1 = 0;
    private int x2 = 3;


    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> listHelp = new ArrayList<Integer>();


    public void listavar() {
        list.add(2);
        list.add(4);
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
        for (int i = x1; i < x2; i++) {
            avverageY = avverageY + list.get(i);
        }
        avverageY = avverageY / (x2-x1);
        return avverageY;
    }



public void sortAndRemoveThingsInListForMedian() {
int x3=x2-x1;
    // x1 do x2
    for (int i = x1; i < x2; i++) {
        listHelp.add(list.get(i));
        System.out.println(list.get(i));
    }

    Collections.sort(listHelp);
    System.out.println("***************");
    System.out.println(listHelp);
    int x4;
    if (x3%2!=0) {


        return;
    }else{
        x4=x2-1;
        x4=x4/2;
    }
    System.out.println(listHelp.get(x4));

}



//    ------------->












//    public int methodMedian() {
////medianY=list.get(x2)-
////         number=(yMax-yMin)/2;
////        return number;
//    }
}



