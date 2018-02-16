package com.infoshareacademy.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.SortedMap;
import java.util.Properties;
import java.util.TreeMap;

public class PropertyService {
    private final String FILE;
    private Properties properties = new Properties();
    private SortedMap<String, String> propertiesMap = new TreeMap<>();

    public PropertyService() {
        FILE = "fourIt.properties";
        try {
            loadProperties();
        }catch (IOException ioe){
            System.out.println("File not found!");
        }
    }

    public SortedMap<String, String> getPropertiesMap() {
        return propertiesMap;
    }

    public String getValue(String value) {
        return properties.getProperty(value);
    }

    private void loadProperties() throws IOException {
        Optional<InputStream> read = Optional.ofNullable(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE));
        if (read.isPresent()) {
            properties.load(read.get());
            for(String key : properties.stringPropertyNames()) {
                String value = getValue(key);
                propertiesMap.put(key, value);
            }
        } else {
            propertiesMap.put("currency", "Dollar");
            propertiesMap.put("dateFormat", "yyyy-MM-dd");
        }
    }
}
