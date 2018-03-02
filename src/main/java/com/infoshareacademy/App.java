package com.infoshareacademy;

import com.infoshareacademy.view.DisplayMenu;

public class App {
    public static void main(String[] args) {


        DisplayMenu newMenu = new DisplayMenu();

        if (newMenu.hasIncorrectLists()) {
            return;
        }

        newMenu.menuControl();

    }
}
