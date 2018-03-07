package com.infoshareacademy.service;

import javax.enterprise.context.RequestScoped;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequestScoped
public class DataProviderBean {

    private final String pathCurrency = "currencies";
    private final String pathOperations = "operations";
    private final String pathGreeting = "greetingmenu";
    private List<String> operationsList = getFromFile(getPathOperations());
    private List<String> currencyList = getFromFile(getPathCurrency());
    private List<String> greetingList = getFromFile(getPathGreeting());

    public String getPathCurrency() {
        return pathCurrency;
    }

    public String getPathOperations() {
        return pathOperations;
    }

    public String getPathGreeting() {
        return pathGreeting;
    }

    public List<String> getOperationsList() {
        return operationsList;
    }

    public void setOperationsList(List<String> operationsList) {
        this.operationsList = operationsList;
    }

    public List<String> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<String> currencyList) {
        this.currencyList = currencyList;
    }

    public List<String> getGreetingList() {
        return greetingList;
    }

    public void setGreetingList(List<String> greetingList) {
        this.greetingList = greetingList;
    }

    public List getFromFile(String pathCurrency) {

        Scanner newScanner = null;

        try {
            newScanner = new Scanner(new File(pathCurrency));
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
