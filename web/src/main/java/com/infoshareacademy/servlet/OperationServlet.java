package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.OperationObject;
import com.infoshareacademy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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

@WebServlet("/operation")
public class OperationServlet extends HttpServlet {

    @Inject
    com.infoshareacademy.cdi.OperationProviderBean OperationProviderBean;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        String fullPath = context.getRealPath("/WEB-INF/operations");
        List<OperationObject> operationList = OperationProviderBean.getFromFile(fullPath);

        String cryptoCurrency = request.getParameter("cryptoCurrency");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("operation", operationList);
        dataModel.put("cryptoCurrency", cryptoCurrency);

        Template template = TemplateProvider.createTemplate(getServletContext(), "operation.ftlh");

        try {
            template.process(dataModel, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        String fullPath = context.getRealPath("/WEB-INF/operations");
        List<OperationObject> operationList = OperationProviderBean.getFromFile(fullPath);

        String cryptoCurrency = request.getParameter("cryptoCurrency");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("operation", operationList);
        dataModel.put("cryptoCurrency", cryptoCurrency);

        Template template = TemplateProvider.createTemplate(getServletContext(), "operation.ftlh");

        try {
            template.process(dataModel, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
