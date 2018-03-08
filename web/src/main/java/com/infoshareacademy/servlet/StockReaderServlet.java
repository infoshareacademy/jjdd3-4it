package com.infoshareacademy.servlet;

import com.infoshareacademy.base_wrappers.StockFileReaderServiceWrapper;
import com.infoshareacademy.model.InputData;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet
public class StockReaderServlet extends HttpServlet{

    @Inject
    StockFileReaderServiceWrapper stockFileReaderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<InputData> cryptoData = stockFileReaderService.readCryptoFromFile("sfs");
        resp.getWriter().write();
    }
}
