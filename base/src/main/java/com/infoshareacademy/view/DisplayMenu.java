//package com.infoshareacademy.view;
//
//import com.infoshareacademy.controller.MathStock;
//import com.infoshareacademy.controller.SearchStock;
//import com.infoshareacademy.controller.StockSorter;
//import com.infoshareacademy.model.InputData;
//import com.infoshareacademy.tools.DateService;
//import com.infoshareacademy.tools.MenuDataService;
//import com.infoshareacademy.tools.PropertyService;
//import com.infoshareacademy.tools.StockFileReaderService;
//import java.text.DecimalFormat;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//
///**
// * Generics:
// * The Class DisplayMenu provides the user a text console menu the user can navigate
// **/
//
//public class DisplayMenu {
//    // Fields
//    private int menuStatus = 1;
//    private int userCurrency = 0;
//    private int userOperation = 0;
//    private LocalDate startDate;
//    private LocalDate endDate;
//    private String pathToCrypto = "bitCoin.csv";
//    private final String teamName = "JJDD3_4 IT: Development TEAM";
//    private final String pathCurrency = "src/main/currencies";
//    private final String pathOperations = "src/main/operations";
//    private final String pathGreeting = "src/main/greetingmenu";
//    private static DecimalFormat df2 = new DecimalFormat(".##");
//    private List<String> operationsList = getFromFile(getPathOperations());
//    private List<String> currencyList = getFromFile(getPathCurrency());
//    private List<String> greetingList = getFromFile(getPathGreeting());
//
//    // Getter and Setter
//
//    public String getPathToCrypto() {
//        return pathToCrypto;
//    }
//
//    public String getPathGreeting() {
//        return pathGreeting;
//    }
//
//    public List<String> getOperationsList() {
//        return operationsList;
//    }
//
//    public List<String> getCurrencyList() {
//        return currencyList;
//    }
//
//    public List<String> getGreetingList() {
//        return greetingList;
//    }
//
//    public void setPathToCrypto(String pathToCrypto) {
//        this.pathToCrypto = pathToCrypto;
//    }
//
//    public void setMenuStatus(int menuStatus) {
//        this.menuStatus = menuStatus;
//    }
//
//    public void setUserCurrency(int userChoice) {
//        this.userCurrency = userChoice;
//    }
//
//    public int getMenuStatus() {
//        return menuStatus;
//    }
//
//    public int getUserCurrency() {
//        return userCurrency;
//    }
//
//    public String getPathCurrency() {
//        return pathCurrency;
//    }
//
//    public String getPathOperations() {
//        return pathOperations;
//    }
//
//    public String getTeamName() {
//        return teamName;
//    }
//
//    public int getUserOperation() {
//        return userOperation;
//    }
//
//    public void setUserOperation(int userOperation) {
//        this.userOperation = userOperation;
//    }
//
//    private static final PropertyService propertyService = new PropertyService();
//    private static final String DATE_FORMAT = propertyService.getDateFormat();
//    private static final String CURRENCY = propertyService.getCurrency();
//
//    public void menuHeading() {
//        System.out.println("-----------------------------------------------------------------------------------------------------");
//        System.out.println("    " + getTeamName());
//    }
//
//    public void menuFooting() {
//        System.out.println("-----------------------------------------------------------------------------------------------------");
//        System.out.println();
//    }
//
//    private String chosenCrypto(int inputSet) {
//        String result;
//        switch (inputSet) {
//            case 1:
//                result = "bitCoin.csv";
//                break;
//            case 2:
//                result = "dogeCoin.csv";
//                break;
//            case 3:
//                result = "ethereum.csv";
//                break;
//            case 4:
//                result = "liteCoin.csv";
//                break;
//            case 5:
//                result = "monero.csv";
//                break;
//            default:
//                result = "bitCoin.csv";
//        }
//        return result;
//    }
//
//    public void menuCurrency() {
//        clearScreen();
//        menuHeading();
//        menuCurrencyTitle();
//        menuFooting();
//        menuCurrencySubTitle();
//        printOutList(currencyList);
//        int inputSet = MenuDataService.getMenuValue(currencyList);
//        setPathToCrypto(chosenCrypto(inputSet));
//        menuCurrencyControl(inputSet);
//    }
//
//    public void menuCurrencyTitle() {
//        System.out.println("                                          Crypto Currency Menu");
//    }
//
//    public void menuCurrencySubTitle() {
//        System.out.println("    " + "Select a Crypto Currency from the list below by typing the related number at the left of the currency:");
//        System.out.println();
//    }
//
//    public void menuOperations() {
//        clearScreen();
//        menuHeading();
//        menuOperationsTitle();
//        menuFooting();
//        menuOperationsDisplayCurrency();
//        menuFooting();
//        menuOperationsSubTitle();
//        printOutList(operationsList);
//        int input = MenuDataService.getMenuValue(operationsList);
//        menuOperationsControl(input);
//    }
//
//    public void menuOperationsTitle() {
//        System.out.println("                                            Operations Menu");
//    }
//
//    public void menuOperationsDisplayCurrency() {
//        System.out.println("    "
//                + "Your choice of Crypto Currency is: "
//                + extractCurrency());
//        System.out.println();
//    }
//
//    private String extractCurrency() {
//        String s = currencyList.get(getUserCurrency());
//        String[] tab = s.split("-");
//
//        return tab[0].trim();
//    }
//
//    public void menuOperationsSubTitle() {
//        System.out.println("    " + "Select an option from the below list to be performed by typing the related number at the left of the screen:");
//        System.out.println();
//    }
//
//    public void menuDataChoice() {
//        System.out.println();
//        System.out.print("  " + "Type here the selected date in the format " + DATE_FORMAT + " : ");
//    }
//
//    public static void clearScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }
//
//    public List getFromFile(String pathCurrency) {
//
//        Scanner newScanner = null;
//
//        try {
//            newScanner = new Scanner(new File(pathCurrency));
//        } catch (FileNotFoundException e) {
//            System.out.println("Problems with origin file");
//            return new ArrayList();
//        }
//
//        List newList = new ArrayList();
//
//        for (; newScanner.hasNext(); ) {
//            String line = newScanner.nextLine();
//            newList.add(line);
//
//        }
//        return newList;
//    }
//
//    public void printOutList(List ArrayList) {
//        for (int i = 0; i < ArrayList.size(); i++) {
//            System.out.println("    " + "   " + i + ".  " + ArrayList.get(i));
//        }
//        System.out.println();
//    }
//
//    public boolean hasIncorrectLists() {
//        return operationsList.isEmpty() || currencyList.isEmpty();
//    }
//
//    public void menuControl() {
//
//        switch (getMenuStatus()) {
//            case 1:
//                menuGreeting();
//                break;
//            case 2:
//                menuCurrency();
//                break;
//            case 3:
//                menuOperations();
//                break;
//            case 4:
//                menuDataStart();
//                break;
//            case 5:
//                menuDataEnd();
//                break;
//        }
//    }
//
//    public void menuCurrencyControl(int a) {
//        if (a == 0) {
//            setMenuStatus(1);
//        } else {
//            setMenuStatus(3);
//            setUserCurrency(a);
//        }
//        menuControl();
//    }
//
//    public void menuOperationsControl(int a) {
//        if (a == 0) {
//            setMenuStatus(2);
//        } else {
//            setMenuStatus(4);
//            setUserOperation(a);
//        }
//        menuControl();
//    }
//
//    public void menuDataStartControl() {
//        setMenuStatus(5);
//        menuControl();
//    }
//
//    public void menuDataEndControl() {
//        setMenuStatus(3);
//        runOperations();
//    }
//
//    public void menuDataStart() {
//        clearScreen();
//        menuHeading();
//        menuDataStartTitle();
//        menuFooting();
//        menuDataChoice();
//        startDate = DateService.getDateFromUser();
//        menuDataStartControl();
//    }
//
//    public void menuDataStartTitle() {
//        System.out.println("                                            Start Date Selection Menu");
//    }
//
//    public void menuDataEndShowStartDate(){
//        System.out.println("    "
//                + "The chosen start date is: "
//                + startDate);
//        System.out.println();
//    }
//
//    public void menuDataEnd() {
//        clearScreen();
//        menuHeading();
//        menuDataEndTitle();
//        menuFooting();
//        menuDataEndShowStartDate();
//        menuFooting();
//        menuDataChoice();
//        endDate = DateService.getDateFromUser();
//        if(startDate.isBefore(endDate)) {
//            menuDataEndControl();
//        } else {
//            System.out.println("End date MUST be chronologically latter than start date (at least one day more)!!");
//            pressToProceed();
//            menuDataEnd();
//        }
//    }
//
//    public void menuDataEndTitle() {
//        System.out.println("                                            End Date Selection Menu");
//    }
//
//    public void menuGreeting() {
//        clearScreen();
//        menuHeading();
//        menuGreetingTitle();
//        menuFooting();
//        menuGreetingSubTitle();
//        printOutList(greetingList);
//        menuGreetingControl(MenuDataService.getMenuValue(greetingList));
//    }
//
//    public void menuGreetingTitle() {
//        System.out.println("                                            Start Menu");
//    }
//
//    public void menuGreetingSubTitle() {
//        System.out.println("    " + "Welcome to our application." + "\n");
//    }
//
//    public void menuGreetingControl(int input) {
//        switch (input) {
//            case 0:
//                setMenuStatus(2);
//                menuControl();
//                break;
//            case 1:
//                exitApp();
//                break;
//            default:
//                menuGreeting();
//        }
//    }
//
//    public void exitApp() {
//        clearScreen();
//        System.out.println("\n Thank you for using our application. We hope you appreciated it."
//                + "\n\n              "
//                + getTeamName()
//                + "\n");
//        System.exit(0);
//    }
//
//    public void runOperations() {
//        int userOperation = getUserOperation();
//        MathStock newMath = new MathStock();
//        SearchStock newSearchStock = new SearchStock();
//        StockSorter newStockSorter = new StockSorter();
//        switch (userOperation) {
//            case 1:
//                clearScreen();
//                menuHeading();
//                menuFooting();
//                double minimum = newSearchStock.printPriceMin(newSearchStock.streamList(
//                        StockFileReaderService.readFile(getPathToCrypto()), startDate, endDate));
//                System.out.println("The minimum value of the Cryptovalue "
//                        + extractCurrency()
//                        + " from the selected start date "
//                        + startDate
//                        + " to the selected end date "
//                        + endDate
//                        + " is:\n"
//                        + df2.format(minimum)
//                        + " "
//                        + CURRENCY);
//                pressToProceed();
//                break;
//            case 2:
//                clearScreen();
//                menuHeading();
//                menuFooting();
//                double maximum = newSearchStock.printPriceMax(newSearchStock.streamList(
//                        StockFileReaderService.readFile(getPathToCrypto()), startDate, endDate));
//                System.out.println("The maximum value of the Cryptovalue "
//                        + extractCurrency()
//                        + " from the selected start date "
//                        + startDate
//                        + " to the selected end date "
//                        + endDate
//                        + " is:\n"
//                        + df2.format(maximum)
//                        + " "
//                        + CURRENCY);
//                pressToProceed();
//                break;
//            case 3:
//                double average = newMath.averagePriceForRange(
//                        newSearchStock.streamList(StockFileReaderService.readFile(getPathToCrypto()),
//                                startDate, endDate));
//                clearScreen();
//                menuHeading();
//                menuFooting();
//                System.out.println("The average value of the Cryptovalue "
//                        + extractCurrency()
//                        + " from the selected start date "
//                        + startDate
//                        + " to the selected end date "
//                        + endDate
//                        + " is:\n"
//                        + df2.format(average)
//                        + " "
//                        + CURRENCY);
//                pressToProceed();
//                break;
//            case 4:
//                double median = newMath.medianPriceForRange(
//                        newSearchStock.streamList(StockFileReaderService.readFile(getPathToCrypto()),
//                                startDate, endDate));
//                clearScreen();
//                menuHeading();
//                menuFooting();
//                System.out.println("The median value of the Cryptovalue "
//                        + extractCurrency()
//                        + " from the selected start date "
//                        + startDate
//                        + " to the selected end date "
//                        + endDate
//                        + " is:\n"
//                        + df2.format(median)
//                        + " "
//                        + CURRENCY);
//                pressToProceed();
//                break;
//            case 5:
//                List<Double> movingAverage = newMath.movingAveragePriceForRange(
//                        newSearchStock.streamList(StockFileReaderService.readFile(getPathToCrypto()), startDate, endDate));
//                clearScreen();
//                menuHeading();
//                menuFooting();
//                System.out.println("The list of values of the Cryptovalue "
//                        + extractCurrency()
//                        + " from the selected start date "
//                        + startDate
//                        + " to the selected end date "
//                        + endDate
//                        + " are listed below:\n");
//                for (Double i : movingAverage) {
//                    System.out.println(df2.format(i)
//                                    + " "
//                                    + CURRENCY);
//                }
//                pressToProceed();
//                break;
//            case 6:
//                List<InputData> selValueByPrice = newStockSorter.sortDataBy(
//                        StockFileReaderService.readFile(getPathToCrypto()), StockSorter.byPrice, startDate, endDate);
//                clearScreen();
//                menuHeading();
//                menuFooting();
//                System.out.println("The moving average of the Cryptovalue "
//                        + extractCurrency()
//                        + " from the selected start date "
//                        + startDate
//                        + " to the selected end date "
//                        + endDate
//                        + " sorted by price value are listed below:\n");
//                for (InputData i : selValueByPrice) {
//                    System.out.print(i.getDate());
//                    System.out.println(" | "
//                            + df2.format(i.getPrice())
//                            + " "
//                            + CURRENCY);
//                }
//                pressToProceed();
//                break;
//            case 7:
//                List<InputData> selValueByDate = newStockSorter.sortDataBy(
//                        StockFileReaderService.readFile(getPathToCrypto()), StockSorter.byDate, startDate, endDate);
//                clearScreen();
//                menuHeading();
//                menuFooting();
//                System.out.println("The list of values of the Cryptovalue "
//                        + extractCurrency()
//                        + " from the selected start date "
//                        + startDate
//                        + " to the selected end date "
//                        + endDate
//                        + " sorted by date are listed below:\n");
//                for (InputData i : selValueByDate) {
//                    System.out.print(i.getDate());
//                    System.out.println(" | "
//                            + df2.format(i.getPrice())
//                            + " "
//                            + CURRENCY);
//                }
//                pressToProceed();
//                break;
//        }
//    }
//
//    private void pressToProceed() {
//        System.out.println("\nPress Enter to get back to the Menu");
//        Scanner newScanner = new Scanner(System.in);
//        newScanner.nextLine();
//        menuControl();
//    }
//
//}
//
