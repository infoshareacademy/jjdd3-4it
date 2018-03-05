package com.infoshareacademy.tools;

import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.model.InputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StockFileReaderService {

    public static Logger LOG = LoggerFactory.getLogger(StockFileReaderService.class);

    public static List<InputData> readFile(String cryptoFile) {
        LOG.info("Application use {} file", cryptoFile);
        String pathToFile = "src/main/resources/" + cryptoFile;
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();
        return importStock.getResources();
    }

}