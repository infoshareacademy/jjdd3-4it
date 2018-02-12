package com.infoshareacademy;

import com.infoshareacademy.controller.SortStock;
import com.infoshareacademy.model.ImportStock;

public class App
{
    public static void main( String[] args ) {
       String pathToFile = "src/main/resources/bitCoin.csv";
      ImportStock importStock = new ImportStock(pathToFile);
       importStock.readFromFile();
//       importStock.showPriceAndDate();
//    }
        SortStock sortStock=new SortStock();

        System.out.println(sortStock.priceMinForRange(importStock.getResources()));
        System.out.println("*************************************************");
     System.out.println(sortStock.priceMaxForRange(importStock.getResources()));
        System.out.println("*************************************************");
        System.out.println(sortStock.averragePriceForRange(importStock.getResources()));
        System.out.println("*************************************************");
        System.out.println(sortStock.medianPriceForRange(importStock.getResources()));
        System.out.println("*************************************************");

    }
}
