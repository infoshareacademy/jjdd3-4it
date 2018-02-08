package com.infoshareacademy;

import com.infoshareacademy.view.DisplayMenu;

import java.io.FileNotFoundException;

public class App
{
    public static void main( String[] args ){

        // for testing purposes only
        
        DisplayMenu newMenu = new DisplayMenu();
        if (newMenu.hasIncorrectLists()) {
            return;
        }

        int choice = newMenu.menuCurrency();
        newMenu.menuOperations(choice);

    } // end of method main
} // end of class App
