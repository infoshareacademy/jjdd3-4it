package com.infoshareacademy;

import com.infoshareacademy.controller.MathStock;
import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.view.DisplayMenu;

import java.time.LocalDate;
import java.time.Month;

public class App {
    public static void main(String[] args) {
        String pathToFile = "src/main/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();



        MathStock mathStock = new MathStock();
        LocalDate start = importStock.getResources().get(0).getDate();
        LocalDate end = importStock.getResources().get(30).getDate();



        mathStock.streamList(importStock.getResources(), start, end);

        mathStock.printPriceMax(mathStock.streamList(importStock.getResources(), start, end));


        mathStock.printPriceMin(mathStock.streamList(importStock.getResources(), start, end));

        System.out.println(mathStock.averragePriceForRange(mathStock.streamList(importStock.getResources(), start, end)));
        System.out.println(mathStock.medianPriceForRange(mathStock.streamList(importStock.getResources(), start, end)));


        DisplayMenu newMenu = new DisplayMenu();


//        if (newMenu.hasIncorrectLists()) {
//            return;
//        }
//        newMenu.menuControl();
//
    }

}
