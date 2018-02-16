package com.infoshareacademy.view;

import com.infoshareacademy.controller.SortStock;
import com.infoshareacademy.tools.DateService;
import com.infoshareacademy.tools.MenuDataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Generics:
 * The Class DisplayMenu provides the user a text console menu the user can navigate
 **/

public class DisplayMenu {
    // Fields
    private int menuStatus = 1;
    private int userCurrency = 0;
    private int userOperation = 0;
    private final String teamName = "JJDD3_4 IT: Development TEAM";
    private final String pathCurrency = "currencies";
    private final String pathOperations = "operations";
    private final String pathGreeting = "greetingmenu";
    private List<String> operationsList = getFromFile(getPathOperations());
    private List<String> currencyList = getFromFile(getPathCurrency());
    private List<String> greetingList = getFromFile(getPathGreeting());

    // Getter and Setter
    public String getPathGreeting() {
        return pathGreeting;
    }

    public List<String> getOperationsList() {
        return operationsList;
    }

    public List<String> getCurrencyList() {
        return currencyList;
    }

    public List<String> getGreetingList() {
        return greetingList;
    }

    public void setMenuStatus(int menuStatus) {
        this.menuStatus = menuStatus;
    }

    public void setUserCurrency(int userChoice) {
        this.userCurrency = userChoice;
    }

    public int getMenuStatus() {
        return menuStatus;
    }

    public int getUserCurrency() {
        return userCurrency;
    }

    public String getPathCurrency() {
        return pathCurrency;
    }

    public String getPathOperations() {
        return pathOperations;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getUserOperation() {
        return userOperation;
    }

    public void setUserOperation(int userOperation) {
        this.userOperation = userOperation;
    }

    public void menuHeading() {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("    " + getTeamName());
    }

    public void menuFooting() {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public void menuCurrency() {
        clearScreen();
        menuHeading();
        menuCurrencyTitle();
        menuFooting();
        menuCurrencySubTitle();
        printOutList(currencyList);
        int inputSet = MenuDataService.getMenuValue(currencyList);
        menuCurrencyControl(inputSet);
    }

    public void menuCurrencyTitle() {
        System.out.println("                                          Crypto Currency Menu");
    }

    public void menuCurrencySubTitle() {
        System.out.println("    " + "Select a Crypto Currency from the list below by typing the related number at the left of the currency:");
        System.out.println();
    }

    public void menuOperations() {
        clearScreen();
        menuHeading();
        menuOperationsTitle();
        menuFooting();
        menuOperationsDisplayCurrency();
        menuOperationsSubTitle();
        printOutList(operationsList);
        int input = MenuDataService.getMenuValue(operationsList);
        menuOperationsControl(input);
    }

    public void menuOperationsTitle() {
        System.out.println("                                            Operations Menu");
    }

    public void menuOperationsDisplayCurrency() {
        System.out.println("    "
                + "Your choice of Crypto Currency is: "
                + extractCurrency());
        System.out.println();
    }

    private String extractCurrency() {
        String s = currencyList.get(getUserCurrency());
        String[] tab = s.split("-");

        return tab[0].trim();
    }

    public void menuOperationsSubTitle() {
        System.out.println("    " + "Select an option from the below list to be performed by typing the related number at the left of the screen:");
        System.out.println();
    }

    public void menuChoice() {
        System.out.println();
        System.out.print("  " + "Type here your selection: ");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public List getFromFile(String pathCurrency) {

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
            System.out.println("    " + "   " + i + ".  " + ArrayList.get(i));
        }
        System.out.println();
    }

    public boolean hasIncorrectLists() {
        return operationsList.isEmpty() || currencyList.isEmpty();
    }

    public void menuControl() {

        switch (getMenuStatus()) {
            case 1:
                menuGreeting();
                break;
            case 2:
                menuCurrency();
                break;
            case 3:
                menuOperations();
                break;
            case 4:
                menuDataStart();
                break;
            case 5:
                menuDataEnd();
                break;
        }
    }

    public void menuCurrencyControl(int a) {
        if (a == 0) {
            setMenuStatus(1);
        } else {
            setMenuStatus(3);
            setUserCurrency(a);
        }
        menuControl();
    }

    public void menuOperationsControl(int a) {
        if (a == 0) {
            setMenuStatus(2);
        } else {
            setMenuStatus(4);
            setUserOperation(a);
        }
        menuControl();
    }

    public void menuDataStartControl() {
        setMenuStatus(5);
        menuControl();
    }

    public void menuDataEndControl() {
        setMenuStatus(3);
        menuControl();
    }

    public void menuDataStart() {
        clearScreen();
        menuHeading();
        menuDataStartTitle();
        menuFooting();
        menuChoice();
        DateService.getDateFromUser();
        menuDataStartControl();
    }

    public void menuDataStartTitle() {
        System.out.println("                                            Start Date Selection Menu");
    }

    public void menuDataEnd() {
        clearScreen();
        menuHeading();
        menuDataEndTitle();
        menuFooting();
        menuChoice();
        DateService.getDateFromUser();
        menuDataEndControl();
    }

    public void menuDataEndTitle() {
        System.out.println("                                            End Date Selection Menu");
    }

    public void menuGreeting() {
        clearScreen();
        menuHeading();
        menuGreetingTitle();
        menuFooting();
        menuGreetingSubTitle();
        printOutList(greetingList);
        menuGreetingControl(MenuDataService.getMenuValue(greetingList));
    }

    public void menuGreetingTitle() {
        System.out.println("                                            Start Menu");
    }

    public void menuGreetingSubTitle() {
        System.out.println("    " + "Welcome to our application." + "\n");
    }

    public void menuGreetingControl(int input) {
        switch (input) {
            case 0:
                setMenuStatus(2);
                menuControl();
                break;
            case 1:
                exitApp();
                break;
            default:
                menuGreeting();
        }
    }

    public void exitApp() {
        clearScreen();
        System.out.println("\n Thank you for using our application. We hope you appreciated it."
                + "\n\n              "
                + getTeamName()
                + "\n");
        System.exit(0);
    }

    // waiting for Jacek method to be merged
    public void runOperations(){
        int userOperation = getUserOperation();
        SortStock newOperation = new SortStock();
        switch(userOperation){
            case 1:
//                newOperation.priceMinForRange();
                break;
            case 2:
//                newOperation.priceMaxForRange();
                break;
            case 3:
//                newOperation.averragePriceForRange();
                break;
            case 4:
//                newOperation.medianPriceForRange();
                break;
            case 5:
//                newOperation.
        }
    }

    public void pressToProceed(){
        System.out.println("Press Enter to get back to -> Operations Menu");
        Scanner newScanner = new Scanner(System.in);
        newScanner.nextLine();
    }

}
