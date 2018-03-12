package com.infoshareacademy.cdi;

import com.infoshareacademy.controller.MathStock;
import com.infoshareacademy.controller.SearchStock;
import com.infoshareacademy.controller.StockSorter;
import com.infoshareacademy.model.InputData;
import com.infoshareacademy.tools.StockFileReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class CountingFunctionsBean {
    private static Logger LOG = LoggerFactory.getLogger(CountingFunctionsBean.class);
    private StockFileReaderService stockFileReaderService = new StockFileReaderService();

    public List<InputData> readFileBean(String cryptoFile) {
        return stockFileReaderService.readFile(cryptoFile);
    }

    private StockSorter stockSorter = new StockSorter();

    public List<InputData> sortDataByBean(String cryptoFile, LocalDate startDate, LocalDate endDate) {
        LOG.info("choosing cryptoFile");
        return stockSorter.sortDataBy(readFileBean(cryptoFile), stockSorter.byPrice, startDate, endDate);
    }

    private SearchStock searchStock = new SearchStock();

    public InputData printMaxPriceBean(String cryptoFile, LocalDate startDate, LocalDate endDate) {
        return searchStock.printPriceMax(sortDataByBean(cryptoFile, startDate, endDate));
    }

    public InputData printMinPriceBean(String cryptoFile, LocalDate startDate, LocalDate endDate) {
        return searchStock.printPriceMin(sortDataByBean(cryptoFile, startDate, endDate));
    }

    private MathStock mathStock = new MathStock();

    public double medianPriceForRangeBean(String cryptoFile, LocalDate startDate, LocalDate endDate) {
        return mathStock.medianPriceForRange(sortDataByBean(cryptoFile, startDate, endDate));
    }

    public double avaragePriceForRangeBean(String cryptoFile, LocalDate startDate, LocalDate endDate) {
        return mathStock.averagePriceForRange(sortDataByBean(cryptoFile, startDate, endDate));
    }

}
