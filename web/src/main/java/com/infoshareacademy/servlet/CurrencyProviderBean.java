package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.CurrencyObject;

import javax.enterprise.context.RequestScoped;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequestScoped
public class CurrencyProviderBean {

    public List getFromFile(String path) {

        Scanner newScanner = null;
        List<String> newStringList = new ArrayList();
        String[] toObject = new String[2];
        List<CurrencyObject> newFrontObjectList = new ArrayList();

        try {
            newScanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Problems with origin file");
            return new ArrayList();
        }

        for (; newScanner.hasNext(); ) {
            String newLine = newScanner.nextLine();
            CurrencyObject newCurrencyObject = new CurrencyObject();
            toObject = newLine.split("__");
            newCurrencyObject.setName(toObject[0]);
            newCurrencyObject.setDescription(toObject[1]);
            newCurrencyObject.setUrl(toObject[2]);
            newCurrencyObject.setPath(toObject[3]);
            newFrontObjectList.add(newCurrencyObject);
        }

        return newFrontObjectList;
    }
}
