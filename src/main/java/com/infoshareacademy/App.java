package com.infoshareacademy;

import com.infoshareacademy.controller.MathStock;
import com.infoshareacademy.controller.SearchStock;
import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.tools.StockFileReaderService;
import com.infoshareacademy.view.DisplayMenu;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {


        DisplayMenu newMenu = new DisplayMenu();

        if (newMenu.hasIncorrectLists()) {
            return;
        }

        newMenu.menuControl();

    }
}
