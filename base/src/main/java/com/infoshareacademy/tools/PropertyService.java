package com.infoshareacademy.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyService {
    private static Logger LOG = LoggerFactory.getLogger(PropertyService.class);
    private static final String CURRENCY = "currency";
    private static final String DATE_FORMAT = "dateFormat";
    private final String FILE;

    private Properties properties = new Properties();

    public PropertyService() {
        LOG.info("PropertyService class -> constructor ");
        FILE = "fourIt.properties";
        try {
            loadProperties();
        }catch (IOException ioe){
            System.out.println("File not found!");
            LOG.error("Chosen data was not found in this FILE {} ", FILE);
        }
    }

    private String getValue(String value) {
        return properties.getProperty(value);
    }

    public String getCurrency() {
        LOG.info("User retrieves {} using getCurrency", CURRENCY);
        return getValue(CURRENCY);
    }

    public String getDateFormat() {
        LOG.info("User retrieves {} using getDateFormat", DATE_FORMAT);
        return getValue(DATE_FORMAT);
    }

    private void loadProperties() throws IOException {
        InputStream read = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE);
        properties.load(read);
    }
}
