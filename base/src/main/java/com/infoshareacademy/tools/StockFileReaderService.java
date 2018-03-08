package com.infoshareacademy.tools;

import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.model.InputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StockFileReaderService {

    private static Logger LOG = LoggerFactory.getLogger(StockFileReaderService.class);

    public static List<InputData> readFile(String cryptoFile) {
        return new StockFileReaderService().readCryptoFromFile(cryptoFile);
    }

    public List<InputData> readCryptoFromFile(String cryptoFile) {
        LOG.info("Application use {} file", cryptoFile);
        //"src/main/resources/" + cryptoFile;
        String pathToFile = StockFileReaderService.class.getClassLoader().getResource(cryptoFile).getPath();
        LOG.debug("Full path to file: {}", pathToFile);
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();
        return importStock.getResources();
    }

}