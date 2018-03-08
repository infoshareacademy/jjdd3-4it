package com.infoshareacademy.base_wrappers;

import com.infoshareacademy.model.InputData;
import com.infoshareacademy.tools.StockFileReaderService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class StockFileReaderServiceWrapper {

    private StockFileReaderService stockFileReaderService = new StockFileReaderService();

    public List<InputData> readCryptoFromFile(String cryptoFile){
        return stockFileReaderService.readCryptoFromFile(cryptoFile);
    }

}
