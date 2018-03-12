package com.infoshareacademy.domain;

public class CurrencyObject {
    private String name;
    private String description;
    private String url;
    private String path;

    public CurrencyObject(){};

    public CurrencyObject(String name, String description, String url, String path) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
