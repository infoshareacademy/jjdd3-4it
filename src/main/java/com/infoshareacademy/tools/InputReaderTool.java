package com.infoshareacademy.tools;

import java.util.Scanner;

public class InputReaderTool {

    public static String read() {
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        return inputData;
    }

    public static Integer readInt() {
        return Integer.valueOf(read());
    }

}
