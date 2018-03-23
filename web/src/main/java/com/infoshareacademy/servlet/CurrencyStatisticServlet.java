package com.infoshareacademy.servlet;

import com.infoshareacademy.dao.CurrencyStatisticDao;
import com.infoshareacademy.model.CurrencyStatistic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/statistic")
public class CurrencyStatisticServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CurrencyStatisticServlet.class);

    @Inject
    CurrencyStatisticDao currencyStatisticDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        findAllCurrenciesStatistic(req, resp);

    }

    private void findAllCurrenciesStatistic(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<CurrencyStatistic> currenciesStatistics = currencyStatisticDao.findAll();
        LOG.info("Load statistic to screen");
        for (CurrencyStatistic currencyStatistic : currenciesStatistics) {
            resp.getWriter().println(currencyStatistic);
        }
    }
}
