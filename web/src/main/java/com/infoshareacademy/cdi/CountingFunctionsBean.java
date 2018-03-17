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
public class CountingFunctionsBean {
    @Inject
    InputDataDao inputDataDao;

    private static Logger LOG = LoggerFactory.getLogger(CountingFunctionsBean.class);
    private StockFileReaderService stockFileReaderService = new StockFileReaderService();

    public List<InputData> readFileBean(String cryptoFile) {
        return stockFileReaderService.readFile(cryptoFile);
    }

    private StockSorter stockSorter = new StockSorter();

    public List<InputData> sortDataByBean(LocalDate startDate, LocalDate endDate) {
        LOG.info("choosing cryptoFile");
        return stockSorter.sortDataBy(inputDataDao.findAllData(), stockSorter.byDate, startDate, endDate);
    }

    private SearchStock searchStock = new SearchStock();

    public InputData printMaxPriceBean(LocalDate startDate, LocalDate endDate) {
        return searchStock.printPriceMax(sortDataByBean(startDate, endDate));
    }

    public InputData printMinPriceBean(LocalDate startDate, LocalDate endDate) {
        return searchStock.printPriceMin(sortDataByBean(startDate, endDate));
    }

    private MathStock mathStock = new MathStock();

    public double medianPriceForRangeBean(LocalDate startDate, LocalDate endDate) {
        return mathStock.medianPriceForRange(sortDataByBean(startDate, endDate));
    }

    public double avaragePriceForRangeBean(LocalDate startDate, LocalDate endDate) {
        return mathStock.averagePriceForRange(sortDataByBean(startDate, endDate));
    }

}
