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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/operation")
public class OperationServlet extends HttpServlet {

    @Inject
    com.infoshareacademy.cdi.OperationProviderBean OperationProviderBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        String fullPath = context.getRealPath("/WEB-INF/operations");
        List<OperationObject> operationList = OperationProviderBean.getFromFile(fullPath);
        String cryptoCurrency = request.getParameter("cryptoCurrency");

        HttpSession session = request.getSession();
        session.setAttribute("cryptoCurrency", cryptoCurrency);
        session.setAttribute("fullPath", fullPath);

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String fullPath = (String)session.getAttribute("fullPath");
        String cryptoCurrency = (String) session.getAttribute("cryptoCurrency");

        List<OperationObject> operationList = OperationProviderBean.getFromFile(fullPath);

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
