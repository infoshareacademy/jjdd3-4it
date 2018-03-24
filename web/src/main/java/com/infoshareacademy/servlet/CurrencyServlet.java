package com.infoshareacademy.servlet;

import com.infoshareacademy.cdi.CurrencyProviderBean;
import com.infoshareacademy.domain.CurrencyObject;
import com.infoshareacademy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/currency")
public class CurrencyServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CurrencyServlet.class);

    @Inject
    CurrencyProviderBean currencyProviderBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        String fullPath = context.getRealPath("/WEB-INF/currencies");
        List<CurrencyObject> newList = currencyProviderBean.getFromFile(fullPath);

        Map<String, List> dataModel = new HashMap<>();
        dataModel.put("currencies", newList);

        Template template = TemplateProvider.createTemplate(getServletContext(), "currency.ftlh");

        try {
            template.process(dataModel, response.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error template loading: {}", e);
        }
    }
}
