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

        LOG.info("StockReaderServlet");

        String path = getServletContext().getResource("/WEB-INF/currency/bitCoin.csv").getPath();
        LOG.info("PATH TO FILE: {}", path);

        List<InputData> cryptoData = countingFunctionBean.sortDataByBean(path);

        double max = countingFunctionBean.printMaxPriceBean(cryptoData, path);

        double min = countingFunctionBean.printMinPriceBean(cryptoData, path);

        double avg = countingFunctionBean.avaragePriceForRangeBean(cryptoData, path);

        double med = countingFunctionBean.medianPriceForRangeBean(cryptoData, path);

        PrintWriter printWriter = resp.getWriter();


        //REFACTOR SZBLONY FREEMARKET
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("cryptos", cryptoData);


        Template template = TemplateProvider.createTemplate(getServletContext(), "users-list.ftlh");



        try {
            template.process(dataModel, resp.getWriter());
            printWriter.write("-----------------------\n");
            printWriter.write(String.valueOf(max));
            printWriter.write("-----------------------\n");
            printWriter.write(String.valueOf(min));
            printWriter.write("-----------------------\n");
            printWriter.write(String.valueOf(med));
            printWriter.write("-----------------------\n");
            printWriter.write(String.valueOf(avg));

        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
