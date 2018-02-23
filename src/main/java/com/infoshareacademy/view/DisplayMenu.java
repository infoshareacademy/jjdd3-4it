package com.infoshareacademy.view;

import com.infoshareacademy.controller.MathStock;
import com.infoshareacademy.controller.SearchStock;
import com.infoshareacademy.controller.StockSorter;
import com.infoshareacademy.model.InputData;
import com.infoshareacademy.tools.DateService;
import com.infoshareacademy.tools.MenuDataService;
import com.infoshareacademy.tools.StockFileReaderService;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
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
    private LocalDate startDate;
    private LocalDate endDate;
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
        runOperations();
    }

    public void menuDataStart() {
        clearScreen();
        menuHeading();
        menuDataStartTitle();
        menuFooting();
        menuChoice();
        startDate = DateService.getDateFromUser();
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
        endDate = DateService.getDateFromUser();
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

    public void runOperations() {
        int userOperation = getUserOperation();
        MathStock newMath = new MathStock();
        SearchStock newSearchStock = new SearchStock();
        StockSorter newStockSorter = new StockSorter();
        switch (userOperation) {
            case 1:
                clearScreen();
                menuHeading();
                menuFooting();
                double minimum = newSearchStock.printPriceMin(newSearchStock.streamList(StockFileReaderService.readFile(), startDate, endDate));
                System.out.println("The minimum value of the Cryptovalue "
                        + extractCurrency()
                        + " from the selected start date "
                        + startDate
                        + " to the selected end date "
                        + endDate
                        + " is:\n"
                        + String.format("%.2f", minimum));
                pressToProceed();
                break;
            case 2:
                clearScreen();
                menuHeading();
                menuFooting();
                double maximum = newSearchStock.printPriceMax(newSearchStock.streamList(StockFileReaderService.readFile(), startDate, endDate));
                System.out.println("The maximum value of the Cryptovalue "
                        + extractCurrency()
                        + " from the selected start date "
                        + startDate
                        + " to the selected end date "
                        + endDate
                        + " is:\n"
                        + String.format("%.2f", maximum));
                pressToProceed();
                break;
            case 3:
                double average = newMath.averragePriceForRange(newSearchStock.streamList(StockFileReaderService.readFile(), startDate, endDate));
                clearScreen();
                menuHeading();
                menuFooting();
                System.out.println("The average value of the Cryptovalue "
                        + extractCurrency()
                        + " from the selected start date "
                        + startDate
                        + " to the selected end date "
                        + endDate
                        + " is:\n"
                        + String.format("%.2f", average));
                pressToProceed();
                break;
            case 4:
                double median = newMath.medianPriceForRange(newSearchStock.streamList(StockFileReaderService.readFile(), startDate, endDate));
                clearScreen();
                menuHeading();
                menuFooting();
                System.out.println("The median value of the Cryptovalue "
                        + extractCurrency()
                        + " from the selected start date "
                        + startDate
                        + " to the selected end date "
                        + endDate
                        + " is:\n"
                        + String.format("%.2f", median));
                pressToProceed();
                break;
            case 5:
                List<InputData> selValue = newSearchStock.streamList(StockFileReaderService.readFile(), startDate, endDate);
                System.out.println("The list of values of the Cryptovalue "
                        + extractCurrency()
                        + " from the selected start date "
                        + startDate
                        + " to the selected end date "
                        + endDate
                        + " are listed below:\n");
                for (InputData i : selValue) {
                    System.out.print(i.getDate());
                    System.out.println(" " + i.getPrice());
                }
                pressToProceed();
                break;
            case 6:
                List<InputData> selValueByPrice = newStockSorter.sortDataBy(StockFileReaderService.readFile(), StockSorter.byPrice);
                System.out.println("The list of values of the Cryptovalue "
                        + extractCurrency()
                        + " from the selected start date "
                        + startDate
                        + " to the selected end date "
                        + endDate
                        + " sorted by price value are listed below:\n");
                for (InputData i : selValueByPrice) {
                    System.out.print(i.getDate());
                    System.out.println(" " + i.getPrice());
                }
                pressToProceed();
                break;
        } // end switch condition
    } // end runOperations method

    private void pressToProceed(){
        System.out.println("\nPress Enter to get back to -> Operations Menu");
        Scanner newScanner = new Scanner(System.in);
        newScanner.nextLine();
        menuControl();
    } // end pressToProceed method

} // end DisplayMenu class

