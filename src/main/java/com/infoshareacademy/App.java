package com.infoshareacademy;

import com.infoshareacademy.controller.SortStock;

/**
 * Hello world!
 *
 */
public class App 
{






    public static void main( String[] args )
    {




        SortStock sortStock=new SortStock();

sortStock.listavar();
        System.out.println("***********************************************");
        System.out.println(sortStock.maxPrice());
        System.out.println(sortStock.minPrice());
        System.out.println("***********************************************");
        System.out.println(sortStock.maxPriceFullRange());
        System.out.println(sortStock.minPriceFullRange());
        System.out.println("***********************************************");



//        System.out.println(sortStock.methodAverrage());
//      //  System.out.println(sortStock.methodMedian());
//
//        System.out.println("***********************************************");
//        sortStock.sortAndRemoveThingsInListForMedian();



    }







}
