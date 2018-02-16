package com.infoshareacademy;

import com.infoshareacademy.controller.MathStock;
import com.infoshareacademy.controller.SearchStock;
import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.tools.StockFileReaderService;
import com.infoshareacademy.view.DisplayMenu;

import java.time.LocalDate;


public class App {
    public static void main(String[] args) {


        MathStock mathStock = new MathStock();
        SearchStock searchStock = new SearchStock();
        LocalDate start = StockFileReaderService.readFile().get(1).getDate();
        LocalDate end = StockFileReaderService.readFile().get(53).getDate();

        searchStock.streamList(StockFileReaderService.readFile(), start, end);
        searchStock.printPriceMax(searchStock.streamList(StockFileReaderService.readFile(), start, end));
        searchStock.printPriceMin(searchStock.streamList(StockFileReaderService.readFile(), start, end));
        System.out.println(mathStock.averragePriceForRange(searchStock.streamList(StockFileReaderService.readFile(), start, end)));
        System.out.println(mathStock.medianPriceForRange(searchStock.streamList(StockFileReaderService.readFile(), start, end)));


        DisplayMenu newMenu = new DisplayMenu();


//        if (newMenu.hasIncorrectLists()) {
//            return;
//        }
//        newMenu.menuControl();
//
    }

}
