package com.infoshareacademy;

import com.infoshareacademy.view.DisplayMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    public static final Logger LOG = LoggerFactory.getLogger(App.class.getName());

    public static void main(String[] args) {

        DisplayMenu newMenu = new DisplayMenu();

        if (newMenu.hasIncorrectLists()) {
            return;
        }

        newMenu.menuControl();

    }
}
