package com.infoshareacademy.tools;

import java.io.IOException;
import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;

public class PropertyService {
    private final ClassLoader PROPERTIES_FILE = Thread.currentThread().getContextClassLoader();
    private final String FILE;
    private Properties properties = new Properties();
    private SortedSet<String> propertiesList = new TreeSet<>();

    public PropertyService() {
        FILE = "fourIt.properties";
        try {
            loadProperties();
        }catch (IOException ioe){
            System.out.println("Where's the file?");
        }
    }

    public SortedSet<String> getPropertiesList() {
        return propertiesList;
    }

    private void loadProperties() throws IOException {
        properties.load(PROPERTIES_FILE.getResourceAsStream(FILE));
        Iterator<String> it = properties.stringPropertyNames().iterator();
        while(it.hasNext()) {
            propertiesList.add(properties.getProperty(it.next()));
        }
    }

    public String getValue(String value) {
        return properties.getProperty(value);
    }

    public void printProperties() {
        for(String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            System.out.println(key + " => " + value);
        }
    }
}
