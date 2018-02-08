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
        String pathToFile = "src/main/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();
        importStock.showPriceAndDate();
    }
}
