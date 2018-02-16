package com.infoshareacademy.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyService {
    private static final String CURRENCY = "currency";
    private static final String DATE_FORMAT = "dateFormat";
    private final String FILE;

    private Properties properties = new Properties();

    public PropertyService() {
        FILE = "fourIt.properties";
        try {
            loadProperties();
        }catch (IOException ioe){
            System.out.println("File not found!");
        }
    }

    private String getValue(String value) {
        return properties.getProperty(value);
    }

    public String getCurrency() {
        return getValue(CURRENCY);
    }

    public String getDateFormat() {
        return getValue(DATE_FORMAT);
    }

    private void loadProperties() throws IOException {
        InputStream read = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE);
        properties.load(read);
    }
}
