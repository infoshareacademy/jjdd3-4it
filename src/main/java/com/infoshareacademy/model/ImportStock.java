package com.infoshareacademy.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportStock {
    private File file;
    private List<InputData> resources = new ArrayList<>();

    public ImportStock(String pathToFile) {
        this.file = new File(pathToFile);
    }

    public List<InputData> getResources() {
        return resources;
    }

    public void readFromFile() {
        try (Scanner inputStream = new Scanner(file)) {
            if (inputStream.hasNext()) {
                inputStream.next();
            }
            while (inputStream.hasNext()) {
                String inputData = inputStream.next();
                String[] stringsArray = inputData.split(",");

                InputData r = new InputData(LocalDate.parse(stringsArray[0]),
                        Double.parseDouble(stringsArray[4]));
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
