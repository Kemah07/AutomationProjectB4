package io.loop.test.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static{
        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path); //opening the file in the Java memory

            properties = new Properties(); // Creating Properties class object
            properties.load(input); //loading the "properties" object with the fileStream
            input.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperties(String keyName){ // Use properties object and getProperty method to pass "key" and read "value"
        return properties.getProperty(keyName);
    }
}
