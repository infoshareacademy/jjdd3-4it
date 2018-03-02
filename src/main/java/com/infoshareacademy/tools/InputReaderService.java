package com.infoshareacademy.tools;

import java.util.Scanner;

public class InputReaderService {

    public static String read() {
        Scanner scanner = new Scanner(System.in);
        String inputData = null;
        if (scanner.hasNext()) {
            inputData = scanner.next();
        }
        return inputData;
    }

    public static Integer readInt() {
        return Integer.valueOf(read());
    }

}
