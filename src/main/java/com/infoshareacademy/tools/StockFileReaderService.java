package com.infoshareacademy.tools;

import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.model.InputData;

import java.util.List;

public class StockFileReaderService {

    public static List<InputData> readFile() {
        String pathToFile = "src/main/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();
        return importStock.getResources();
    }

}