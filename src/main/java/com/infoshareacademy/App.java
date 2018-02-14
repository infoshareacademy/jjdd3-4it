package com.infoshareacademy;

import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.tools.PropertyService;
import com.infoshareacademy.view.DisplayMenu;

public class App
{
    public static void main( String[] args )
    {
//        String pathToFile = "src/main/resources/bitCoin.csv";
//        ImportStock importStock = new ImportStock(pathToFile);
//        importStock.readFromFile();
//        importStock.showPriceAndDate();
//
//        DisplayMenu newMenu = new DisplayMenu();
//
//        if (newMenu.hasIncorrectLists()) {
//            return;
//        }
//
//        newMenu.menuControl();
        PropertyService propertyService = new PropertyService();
        propertyService.printProperties();
    }
}
