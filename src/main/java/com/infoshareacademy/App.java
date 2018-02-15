package com.infoshareacademy;

import com.infoshareacademy.controller.SortStock;
import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.model.InputData;
import com.infoshareacademy.view.DisplayMenu;

public class App {
    public static void main(String[] args) {
        String pathToFile = "src/main/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();

        DisplayMenu newMenu = new DisplayMenu();


//        if (newMenu.hasIncorrectLists()) {
//            return;
//        }
//        newMenu.menuControl();
//
SortStock sortStock=new SortStock();

sortStock.printPriceMax(importStock.getResources());
//sortStock.priceMinStream(importStock.getResources());
      //  sortStock.priceMinStream(importStock.getResources());
    }

}
