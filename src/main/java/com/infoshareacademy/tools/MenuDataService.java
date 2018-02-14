package com.infoshareacademy.tools;

import java.util.List;

public class MenuDataService {

    static int checkNumerCorrectFormat() {
        boolean flag = false;
        do {
            try {
                int result = InputReaderTool.readInt();
                flag = true;
                return result;
            } catch (NumberFormatException e) {
                System.out.print("  please write correct numeric format: ");
            }
        } while (flag == false);
        return 0;
    }

    public static int getMenuValue(List<String> list) {
        int input;
        do {
            System.out.print("  please give number in range [" + 0 + "-" + (list.size() - 1) + "]: ");
            return input = checkNumerCorrectFormat();
        } while (input < 0 || input > (list.size() - 1));
    }
}
