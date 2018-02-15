package com.infoshareacademy;

import com.infoshareacademy.controller.SortDataStock;
import com.infoshareacademy.view.DisplayMenu;



public class App {
    public static void main(String[] args) {

        SortDataStock sortDataStock = new SortDataStock();
        sortDataStock.printSortData();

//        String pathToFile = "src/main/resources/bitCoin.csv";
//        ImportStock importStock = new ImportStock(pathToFile);
//        importStock.readFromFile();
//        importStock.showPriceAndDate();


        DisplayMenu newMenu = new DisplayMenu();


        if (newMenu.hasIncorrectLists()) {
            return;
        }
        newMenu.menuControl();


    }
}
