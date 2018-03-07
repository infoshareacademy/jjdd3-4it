package com.infoshareacademy.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MenuDataService {

    private static Logger LOG = LoggerFactory.getLogger(MenuDataService.class);

    static int checkNumerCorrectFormat() {

        do {
            try {
                int result = InputReaderService.readInt();
                return result;
            } catch (NumberFormatException e) {
                System.out.print("  please write correct numeric format: ");
                LOG.error("User write not Integer format");
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