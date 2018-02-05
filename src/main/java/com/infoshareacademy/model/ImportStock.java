package com.infoshareacademy.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportStock {
    private File file;
    private ResourceFromFile resource;

    public ImportStock(String pathToFile) {
        this.file = new File(pathToFile);
        this.resource = new ResourceFromFile();
    }

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

    public void showPrice() {
        System.out.println("Price array list size: " + resource.getPriceUSD().size());
        resource.showPrice();
    }
    public void showDate() {
        System.out.println("Date array list size: " + resource.getDate().size());
        resource.showDate();
    }

}
