package com.infoshareacademy.model;

import java.util.ArrayList;
import java.util.List;

public class ResourceFromFile {
    private List<String> date;
    private List<String> priceUSD;

    public ResourceFromFile() {
        date = new ArrayList<>();
        priceUSD = new ArrayList<>();
    }

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<String> getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(List<String> priceUSD) {
        this.priceUSD = priceUSD;
    }

    public String getDateElement(int index) {
        return date.get(index);
    }

    public void addDateElement(String element) {
        this.date.add(element);
    }

    public String getPriceUSD(int index) {
        return priceUSD.get(index);
    }

    public void addPriceUSD(String element) {
        priceUSD.add(element);
    }

    public void showDate() {
        for (String date : getDate()) {
            System.out.println(date);
        }
    }
    public void showPrice() {
        for (String price : getPriceUSD()) {
            System.out.println(price);
        }
    }


}
