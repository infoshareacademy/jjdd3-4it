package com.infoshareacademy.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

/**
 * Generics:
 * The Class DisplayMenu provides the user a text console menu the user can navigate
**/

public class DisplayMenu {

    private final String teamName = "JJDD3_4 IT: Development TEAM";
    private final String pathCurrency = "currencies";
    private final String pathOperations = "operations";
    private List operationsList = getFromFile(getPathOperations());
    private List currencyList = getFromFile(getPathCurrency());


    public String getPathCurrency() {
        return pathCurrency;
    }

    public String getPathOperations() {
        return pathOperations;
    }

    public String getTeamName() {
        return teamName;
    }

    public void menuHeading(){
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println(getTeamName());
    }

    public void menuFooting() {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public int menuCurrency() {
        clearScreen();

        menuHeading();
        menuCurrencyTitle();
        menuFooting();
        menuCurrencySubTitle();
        printOutList(currencyList);

        return getChoice(currencyList.size());
    }

    public void menuCurrencyTitle() {
        System.out.println("                                          Crypto Currency Menu");
    }

    public void menuCurrencySubTitle(){
        System.out.println("Select a Crypto Currency from the list below by typing the related number at the left of the currency:");
        System.out.println();
    }

    public int menuOperations(int choice) {
        clearScreen();

        menuHeading();
        menuOperationsTitle();
        menuFooting();
        menuOperationsDisplayCurrency(choice);
        menuOperationsSubTitle();
        printOutList(operationsList);

        return getChoice(operationsList.size());
    }

    public void menuOperationsTitle(){
        System.out.println("                                            Operations Menu");
    }

    public void menuOperationsDisplayCurrency(int choice){
        System.out.println("Your choice of Crypto Currency is: " + currencyList.get(choice)); // To be implemented : show on this line the name of the actual currency selected
        System.out.println();
    }

    public void menuOperationsSubTitle(){
        System.out.println("Select an option from the below list to be performed by typing the related number at the left of the screen:");
        System.out.println();
    }

    public int getChoice(int numberOfChoice){
        int choice = 0;
        do {

            System.out.println();
            System.out.print("Type here the selected choice: ");

            Scanner newScanner = new Scanner(System.in);
            choice = newScanner.nextInt();
        } while (choice < 1 || choice >numberOfChoice);

        return choice;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public List getFromFile(String pathCurrency){

        Scanner newScanner = null;

        try {
            newScanner = new Scanner(new File(pathCurrency));
        } catch (FileNotFoundException e) {
            System.out.println("Problems with origin file");
            return new ArrayList();
        }

        List newList = new ArrayList();

        for (; newScanner.hasNext(); ) {
            String line = newScanner.nextLine();
            newList.add(line);

        }
        return newList;
    }

    public void printOutList(List ArrayList) {
        for (int i = 0; i < ArrayList.size(); i++) {
            System.out.println(i + "  " + ArrayList.get(i));
        }
    }

    public boolean hasIncorrectLists() {
        return operationsList.isEmpty() || currencyList.isEmpty();
    }
}
