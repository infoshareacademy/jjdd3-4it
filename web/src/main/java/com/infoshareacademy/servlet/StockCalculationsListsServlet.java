package com.infoshareacademy.servlet;

import com.infoshareacademy.cdi.CountingFunctionsBean;
import com.infoshareacademy.dao.InputDataDao;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.model.InputData;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class StockCalculationsListsServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(StockCalculationsListsServlet.class);

    @Inject
    CountingFunctionsBean countingFunctionBean;

    @Inject
    InputDataDao inputDataDao;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        LocalDate startDate = LocalDate.parse(req.getParameter("start"));
        LocalDate endDate = LocalDate.parse(req.getParameter("end"));
        String currencyName = req.getParameter("currency");
//        String operation = req.getParameter("operation");
//        resp.getWriter().println("operation: " + operation);
        String pathToFile = getServletContext().getResource("/WEB-INF/currency/" + currencyName + ".csv").getPath();
        LOG.info("Path to file:  {}", pathToFile);


        List<InputData> printData = countingFunctionBean.readFileBean(pathToFile);
        for (InputData inputDataDb : printData) {
            inputDataDb.setCurrency(currencyName);
            inputDataDao.save(inputDataDb);
        }

        List<InputData> cryptoData = countingFunctionBean.sortDataByBean(pathToFile, startDate, endDate);
        InputData minPrice = countingFunctionBean.printMinPriceBean(pathToFile, startDate, endDate);
        InputData maxPrice = countingFunctionBean.printMaxPriceBean(pathToFile, startDate, endDate);
        Double averageOfPrice = countingFunctionBean.avaragePriceForRangeBean(pathToFile, startDate, endDate);
        Double medianOfPrice = countingFunctionBean.medianPriceForRangeBean(pathToFile, startDate, endDate);


        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("cryptos", cryptoData);
        dataModel.put("min", minPrice);
        dataModel.put("max", maxPrice);
        dataModel.put("avg", averageOfPrice);
        dataModel.put("med", medianOfPrice);
        dataModel.put("startdate", startDate);
        dataModel.put("enddate", endDate);
        String whichCoin;
        whichCoin = currencyName;
        whichCoin = whichCoin.toLowerCase();
        whichCoin = whichCoin.substring(0, whichCoin.length() - 4);
        dataModel.put("whichCoin", whichCoin);

        Template template = TemplateProvider.createTemplate(getServletContext(), "start-menu.ftlh");

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }
}
