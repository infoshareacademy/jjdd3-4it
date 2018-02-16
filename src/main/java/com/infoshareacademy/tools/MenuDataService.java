package com.infoshareacademy.tools;

import java.util.List;

public class MenuDataService {

    static int checkNumerCorrectFormat() {

        do {
            try {
                int result = InputReaderService.readInt();
                return result;
            } catch (NumberFormatException e) {
                System.out.print("  please write correct numeric format: ");
            }
        } while (true);
    }

    public static int getMenuValue(List<String> list) {
        int input;
        do {
            System.out.print("  please give number in range [" + 0 + "-" + (list.size() - 1) + "]: ");
            input = checkNumerCorrectFormat();
        } while (input < 0 || input > (list.size() - 1));
        return input;
    }
}
