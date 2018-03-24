package com.infoshareacademy.cdi;

import com.infoshareacademy.controller.MathStock;
import com.infoshareacademy.controller.SearchStock;
import com.infoshareacademy.controller.StockSorter;
import com.infoshareacademy.dao.InputDataDao;
import com.infoshareacademy.model.InputData;
import com.infoshareacademy.tools.StockFileReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class StockCalculationsListsBean {
    @Inject
    private InputDataDao inputDataDao;

    private static Logger LOG = LoggerFactory.getLogger(StockCalculationsListsBean.class);
    private StockFileReaderService stockFileReaderService = new StockFileReaderService();

    public List<InputData> readFileBean(String cryptoFile) {
        LOG.info("choosing cryptoFile {}", cryptoFile);
        return stockFileReaderService.readFile(cryptoFile);
    }

    private StockSorter stockSorter = new StockSorter();

    public List<InputData> sortDataByBean(String currencyName, LocalDate startDate, LocalDate endDate) {
        return stockSorter.sortDataBy(inputDataDao.findAll(currencyName), stockSorter.byDate, startDate, endDate);
    }

    private SearchStock searchStock = new SearchStock();

    public InputData printMaxPriceBean(String currencyName, LocalDate startDate, LocalDate endDate) {
        return searchStock.printPriceMax(sortDataByBean(currencyName, startDate, endDate));
    }

    public InputData printMinPriceBean(String currencyName, LocalDate startDate, LocalDate endDate) {
        return searchStock.printPriceMin(sortDataByBean(currencyName, startDate, endDate));
    }

    private MathStock mathStock = new MathStock();

    public double medianPriceForRangeBean(String currencyName, LocalDate startDate, LocalDate endDate) {
        return mathStock.medianPriceForRange(sortDataByBean(currencyName, startDate, endDate));
    }

    public double avaragePriceForRangeBean(String currencyName, LocalDate startDate, LocalDate endDate) {
        return mathStock.averagePriceForRange(sortDataByBean(currencyName, startDate, endDate));
    }

}
