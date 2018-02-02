package com.infoshareacademy;

import com.infoshareacademy.model.ImportStock;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println("Hello World!");
        ImportStock importStock = new ImportStock();
        importStock.readFromFile();
    }
}
