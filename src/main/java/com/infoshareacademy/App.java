package com.infoshareacademy;

import com.infoshareacademy.tools.PropertyService;

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
        //propertyService.printProperties();
        String s = propertyService.getPropertiesSet().first();
        System.out.println(s);
//        for (String s :propertyService.getPropertiesSet()) {
//            System.out.println(s);
//        }
    }
}
