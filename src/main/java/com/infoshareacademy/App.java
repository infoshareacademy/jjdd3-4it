package com.infoshareacademy;

import com.infoshareacademy.view.InputDisplay;

public class App
{
    public static void main( String[] args )    {

        InputDisplay inputDisplay = new InputDisplay();
        int choice = inputDisplay.greetingScreen();
        inputDisplay.optionMenuScreen(choice);

    } // end of method main
} // end of class App
