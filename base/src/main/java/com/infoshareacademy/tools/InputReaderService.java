package com.infoshareacademy.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class InputReaderService {
    private static Logger LOG = LoggerFactory.getLogger(InputReaderService.class);

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