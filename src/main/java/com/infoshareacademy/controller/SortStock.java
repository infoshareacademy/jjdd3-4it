package com.infoshareacademy.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class SortStock {
    private int yMinFullRange;
    private int yMaxFullRange;
private int number;
    private int yMax=0;
    private int yMin=99;


private int x1= 5;

private int x2 =10;


//private int x0;
//private int xLast;



    ArrayList<Integer> lista=new ArrayList<Integer>();

public void listavar(){
    lista.add(2);
    lista.add(5);
    lista.add(7);
    lista.add(99);
    lista.add(7);
    lista.add(0);
    lista.add(44);
    lista.add(8);
    lista.add(65);
    lista.add(8);
    lista.add(4);
}



    public int methodmax() {

        for (int i = x1; i < x2; i++) {
            if (lista.get(i) > yMax) {
                yMax = lista.get(i);
            }
        }return yMax;
    }


        public int methodmin() {

            for (int i = x1; i < x2; i++) {
                if (lista.get(i) < yMin) {
                    yMin = lista.get(i);
                }
            }return yMin;
        }









}
