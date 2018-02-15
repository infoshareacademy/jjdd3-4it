package com.infoshareacademy.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PropertyService {
    private final ClassLoader PROPERTIES_FILE = Thread.currentThread().getContextClassLoader();
    private final String FILE;
    private Properties properties = new Properties();
    private SortedSet<String> propertiesSet = new TreeSet<>();

    public PropertyService() {
        FILE = "fourIt.properties";
        try {
            loadProperties();
        }catch (IOException ioe){
            System.out.println("Where's the file?");
        }
    }

    public SortedSet<String> getPropertiesSet() {
        return propertiesSet;
    }

    private void loadProperties() throws IOException {
        Optional<InputStream> read = Optional.ofNullable(PROPERTIES_FILE.getResourceAsStream(FILE));
        if (read.isPresent()) {
            properties.load(read.get());
            Iterator<String> it = properties.stringPropertyNames().iterator();
            while(it.hasNext()) {
                propertiesSet.add(properties.getProperty(it.next()));
            }
        } else {
            propertiesSet.add("Dollar");
            propertiesSet.add("yyyy-MM-dd");
        }
    }
}
