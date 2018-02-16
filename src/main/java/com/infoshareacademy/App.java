package com.infoshareacademy;

import com.infoshareacademy.controller.SortStock;
import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.model.InputData;
import com.infoshareacademy.tools.PropertyService;
import com.infoshareacademy.view.DisplayMenu;

public class App {
    private static final String CURRENCY = "currency";
    public static void main(String[] args) {
//        String pathToFile = "src/main/resources/bitCoin.csv";
//        ImportStock importStock = new ImportStock(pathToFile);
//        importStock.readFromFile();
//
//        DisplayMenu newMenu = new DisplayMenu();
//
//
//        if (newMenu.hasIncorrectLists()) {
//            return;
//        }
//        newMenu.menuControl();

        PropertyService propertyService = new PropertyService();
        System.out.println(propertyService.getPropertiesMap().get("currency"));
        System.out.println(propertyService.getValue(CURRENCY));

    }
}
