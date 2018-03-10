package com.infoshareacademy.servlet;

import javax.enterprise.context.RequestScoped;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequestScoped
public class DataProviderBean {

    public List getFromFile(String path) {

        Scanner newScanner = null;

        try {
            newScanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Problems with origin file");
            return new ArrayList();
        }

        List newList = new ArrayList();

        for (; newScanner.hasNext(); ) {
            String line = newScanner.nextLine();
            newList.add(line);

        }
        return newList;
    }
}
