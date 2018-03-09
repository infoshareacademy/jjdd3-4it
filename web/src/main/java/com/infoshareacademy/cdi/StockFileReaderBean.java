package com.infoshareacademy.cdi;

import com.infoshareacademy.controller.StockSorter;
import com.infoshareacademy.model.InputData;
import com.infoshareacademy.tools.StockFileReaderService;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class StockFileReaderBean {

    private StockFileReaderService stockFileReaderService = new StockFileReaderService();

    public List<InputData> readCryptoFromFile(String cryptoFile) {
        return stockFileReaderService.readFile(cryptoFile);
    }

    private StockSorter stockSorter = new StockSorter();

    public List<InputData> sortCurrenciesData(String cryptoFile){
        return stockSorter.sortDataBy(readCryptoFromFile(cryptoFile),stockSorter.byPrice, LocalDate.parse("2017-01-01"), LocalDate.parse("2017-01-03"));
    }

}
