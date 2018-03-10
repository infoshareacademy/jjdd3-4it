package com.infoshareacademy.cdi;

import com.infoshareacademy.controller.MathStock;
import com.infoshareacademy.controller.SearchStock;
import com.infoshareacademy.controller.StockSorter;
import com.infoshareacademy.model.InputData;
import com.infoshareacademy.tools.StockFileReaderService;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class CountingFunctionsBean {
    //StockFileReaderService
    private StockFileReaderService stockFileReaderService = new StockFileReaderService();

    public List<InputData> readFileBean(String cryptoFile) {
        return stockFileReaderService.readFile(cryptoFile);
    }

    //StockSorter
    private StockSorter stockSorter = new StockSorter();

    public List<InputData> sortDataByBean(String cryptoFile){
        return stockSorter.sortDataBy(readFileBean(cryptoFile),stockSorter.byPrice, LocalDate.parse("2017-01-01"), LocalDate.parse("2017-01-03"));
    }

    //SearchStock
    private SearchStock searchStock = new SearchStock();

    public InputData printMaxPriceBean(List<InputData> resources, String cryptoFile){
        return searchStock.printPriceMax(sortDataByBean(cryptoFile));
    }

    public InputData printMinPriceBean(List<InputData> resources, String cryptoFile){
        return searchStock.printPriceMin(sortDataByBean(cryptoFile));
    }

    //MathStock
    private MathStock mathStock = new MathStock();

    public double medianPriceForRangeBean(List<InputData> resources, String cryptoFile){
        return mathStock.medianPriceForRange(sortDataByBean(cryptoFile));
    }

    public double avaragePriceForRangeBean(List<InputData> resources, String cryptoFile){
        return mathStock.averagePriceForRange(sortDataByBean(cryptoFile));
    }






}
