package com.infoshareacademy.servlet;

import com.infoshareacademy.dao.InputDataDao;
import com.infoshareacademy.model.InputData;
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

@WebServlet("/find")
public class InputDataServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(InputDataServlet.class);

    @Inject
    InputDataDao inputDataDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<InputData> result = inputDataDao.findAllData();
        LOG.info("Size of list {}-----------------------------------", result.size());
        for (InputData inputData: result) {
            resp.getWriter().println(inputData);
        }
    }
}
