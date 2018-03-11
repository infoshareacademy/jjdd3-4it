package com.infoshareacademy.servlet;

import com.infoshareacademy.cdi.FileUploadProcessor;
import com.infoshareacademy.domain.FileToServer;
import com.infoshareacademy.exceptions.UserImageNotFound;
import com.infoshareacademy.freemarker.TemplateProvider;
import freemarker.template.Template;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/add-user")
@MultipartConfig
public class AddUserServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

//    File templatesPath;
    Template template;

    @Inject
    FileUploadProcessor fileUploadProcessor;

    @Override
    public void init() throws ServletException {
        try {
            template = TemplateProvider.createTemplate(getServletContext(), "add-edit-user.ftlh");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileToServer fileToServer = new FileToServer();
        Part filePart = req.getPart("image");
        File file = null;
        try {
            file = fileUploadProcessor.uploadImageFile(filePart);
            fileToServer.setImageURL("/images/" + file.getName());
        } catch (UserImageNotFound userImageNotFound) {
            logger.log(Level.SEVERE, userImageNotFound.getMessage());
        }

//        usersRepositoryDao.addUser(fileToServer);

//        resp.sendRedirect("/users-list");
    }
}
