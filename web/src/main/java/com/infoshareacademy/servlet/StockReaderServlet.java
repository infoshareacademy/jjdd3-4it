package com.infoshareacademy.servlet;

import com.infoshareacademy.cdi.CountingFunctionsBean;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.model.InputData;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class StockReaderServlet extends HttpServlet{

    private static final Logger LOG = LoggerFactory.getLogger(StockReaderServlet.class);

    @EJB
    CountingFunctionsBean countingFunctionBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathToFile = getServletContext().getResource("/WEB-INF/currency/bitCoin.csv").getPath();
        LOG.info("PATH TO FILE: {}", pathToFile);

        List<InputData> cryptoData = countingFunctionBean.sortDataByBean(pathToFile);
        InputData minPrice = countingFunctionBean.printMinPriceBean(cryptoData, pathToFile);
        InputData maxPrice = countingFunctionBean.printMaxPriceBean(cryptoData, pathToFile);
        Double averageOfPrice = countingFunctionBean.avaragePriceForRangeBean(cryptoData, pathToFile);
        Double medianOfPrice = countingFunctionBean.medianPriceForRangeBean(cryptoData, pathToFile);


        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("cryptos", cryptoData);
        dataModel.put("min", minPrice);
        dataModel.put("max", maxPrice);
        dataModel.put("avg", averageOfPrice);
        dataModel.put("med", medianOfPrice);

        Template template = TemplateProvider.createTemplate(getServletContext(), "start-menu.ftlh");

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }
}
