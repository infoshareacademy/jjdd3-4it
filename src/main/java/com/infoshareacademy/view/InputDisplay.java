package com.infoshareacademy.view;

import java.util.Scanner;

/**
 * Generics:
 * The Class InputDisply shows the user a text console menu the user can navigate
**/

public class InputDisplay {

    /**
     * greetingScreen is the first menu the user see when the application starts
     * and give a choice of CryptoCurrencies to choose
     *
     * @return getChoice integer value corresponding to user keyboard input
    **/

    public int greetingScreen(){
        clearScreen();

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("JJDD3_4 IT: Development TEAM");
        System.out.println("                                          Crypto Currency Menu");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Select a Crypto Currency from the list below by typing the related number at the left of the currency:");
        System.out.println();
        System.out.println("1. Bitcoin   - Most popular cryptovalue on the market.");
        System.out.println("2. Dogecoin  - Currency gaining traction as an Internet tipping system.");
        System.out.println("3. Ethereum  - Ethereum is an open-source, public, blockchain-based distributed computing platform.");
        System.out.println("4. LiteCoin  - Peer-to-peer cryptocurrency and open source software project released under the MIT/X11 license.");
        System.out.println("5. Monero    - Open-source cryptocurrency that focuses on privacy and decentralization.");
        return getChoice(5);
    }

    /**
     * optionMenuScreen is shown when the user has defined
     * CryptoCurrencies on which perform and various possible operations
     *
     * @return getChoice integer value corresponding to user keyboard input
     **/

    public int optionMenuScreen(int choice){
        clearScreen();

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("JJDD3_4 IT: Development TEAM");
        System.out.println("                                            Operations Menu");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Your choice of Crypto Currency is: "); // To be implemented : show on this line the name of the actual currency selected
        System.out.println("Select an option to be performed from the below list by typing the related number at the left of the screen:");
        System.out.println();
        System.out.println("1. Go back to Crypto Currency Menu to select a different Currency.");
        System.out.println("2. Print to the screen the minimum value of the currency in beetween the dates defined.");
        System.out.println("3. Print to the screen the maximum value of the currency in beetween the dates defined.");
        System.out.println("4. Print to the screen the average value of the currency in beetween the dates defined.");
        System.out.println("5. Print to the screen the mediana value of the currency in beetween the dates defined.");
        System.out.println("6. Print to the screen the moving average value of the currency in beetween the dates defined.");
        System.out.println("7. Print to the screen all the Crypto Currency daily value in beetween the dates defined.");

        return getChoice(7);
    }

    /**
     * getChoice call a Scanner object to catch
     * the keyboard input from the user
     *
     * @return Choice integer value corresponding to user keyboard input
     **/

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

    /**
     * clearScreen clean the terminal when
     * switching through the menus
     **/

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
