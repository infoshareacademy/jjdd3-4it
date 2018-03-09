package com.infoshareacademy.servlet;

import com.infoshareacademy.cdi.StockFileReaderBean;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.model.InputData;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class StockReaderServlet extends HttpServlet{

    private static final Logger LOG = LoggerFactory.getLogger(StockReaderServlet.class);

    @Inject
    StockFileReaderBean stockFileReaderService;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOG.info("StockReaderServlet");

        String path = getServletContext().getResource("/WEB-INF/currency/bitCoin.csv").getPath();
        LOG.info("PATH TO FILE: {}", path);

        List<InputData> cryptoData = stockFileReaderService.sortCurrenciesData(path);//stockFileReaderService.readCryptoFromFile(path);

        LOG.info("data: {}, cena {} ", cryptoData.get(0).getDate(), cryptoData.get(0).getPrice());
        //resp.getWriter().write();


        //REFACTOR SZBLONY FREEMARKET
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("cryptos", cryptoData);

        Template template = TemplateProvider.createTemplate(getServletContext(), "users-list.ftlh");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
