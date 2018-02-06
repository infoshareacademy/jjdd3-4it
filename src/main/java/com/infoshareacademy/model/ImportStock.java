package com.infoshareacademy.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportStock {
    private File file;
    private List<InputData> resources;

    public ImportStock(String pathToFile) {
        this.file = new File(pathToFile);
        this.resources = new ArrayList<>();
    }


    public void readFromFile() {
        try (Scanner inputStream = new Scanner(file)) {
            if (inputStream.hasNext()) {
                String inputData = inputStream.next();
            }
            while (inputStream.hasNext()) {
                String inputData = inputStream.next();
                String[] stringsArray = inputData.split(",");

                InputData r = new InputData(stringsArray[4], stringsArray[0]);
                resources.add(r);
            }
        } catch (FileNotFoundException fnfExc) {
            System.out.println("Invalid file name or wrong path to file!!!");
            System.out.println(fnfExc);
        }

    }

    public void showPriceAndDate() {
        System.out.println("Number of items: " + resources.size());
        for (InputData i : resources) {
            System.out.print(i.getDate());
            System.out.println(" " + i.getPrice());
        }
    }


}
