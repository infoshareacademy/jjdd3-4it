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

        ImportStock importStock = new ImportStock("src/main/resources/bitcoin.csv");
        importStock.readFromFile();
        importStock.showPrice();
        System.out.println("-----------------------------------------");
        importStock.showDate();
    }
}
