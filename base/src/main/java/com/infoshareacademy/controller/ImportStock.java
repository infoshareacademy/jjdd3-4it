package com.infoshareacademy.controller;

import com.infoshareacademy.model.InputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportStock {
    private static Logger LOG = LoggerFactory.getLogger(ImportStock.class);
    private File file;
    private List<InputData> resources = new ArrayList<>();

    public ImportStock(String pathToFile) {
        this.file = new File(pathToFile);
    }

    public List<InputData> getResources() {
        return resources;
    }

    public void readFromFile() {
        LOG.info("User retrieves data from file {} with method readFromFile", file);
        try (Scanner inputStream = new Scanner(file)) {
            if (inputStream.hasNext()) {
                inputStream.next();
            }
            while (inputStream.hasNext()) {
                String inputData = inputStream.next();
                String[] stringsArray = inputData.split(",");

                InputData r = new InputData(LocalDate.parse(stringsArray[0]),
                        Double.parseDouble(stringsArray[1]));
                resources.add(r);
            }
        } catch (FileNotFoundException fnfExc) {
            System.out.println("Invalid file name or wrong path to file!!!");
            System.out.println(fnfExc);
            LOG.error("Chosen file was not found");
        }
    }
}
