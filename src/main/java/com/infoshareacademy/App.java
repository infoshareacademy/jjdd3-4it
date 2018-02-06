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
        System.out.println( "Hello World!" );



        SortStock sortStock=new SortStock();

sortStock.listavar();

        System.out.println(sortStock.methodMax());
        System.out.println(sortStock.methodMin());


        System.out.println(sortStock.methodAverrage());


    }







}
