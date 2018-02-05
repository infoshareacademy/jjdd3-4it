package com.infoshareacademy.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportStock {
    String sourceFile = "src/main/resources/bitcoin.csv";
    File file = new File(sourceFile);
    ResourceFromFile resource = new ResourceFromFile();

    public void readFromFile() {
        try (Scanner inputStream = new Scanner(file)) {
            if (inputStream.hasNext()) {
                String inputData = inputStream.next();
            }
            while (inputStream.hasNext()) {
                String inputData = inputStream.next();
                String[] stringsArray = inputData.split(",");
                resource.addDateElement(stringsArray[0]);
                resource.addPriceUSD(stringsArray[4]);
            }
        } catch (FileNotFoundException fnfExc) {
            System.out.println("Invalid file name or wrong path to file!!!");
            System.out.println(fnfExc);
        }

    }

}
