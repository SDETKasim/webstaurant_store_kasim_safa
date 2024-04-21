package com.webstaurant_project.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    /** Created the Properties object, made it "private" so we are limiting access to the object.
     * The "static" block is to make sure its created and loaded before everything else.
     */
    private static Properties properties = new Properties();

    static {
        try {
            /**
             * Opened file using FileInputStream (open file).
             */
            FileInputStream file = new FileInputStream("config.properties");
            /**
             * Loaded the "properties" object with file (load properties).
             */
            properties.load(file);
            /**
             * Closed the file in the memory.
             */
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** Created a utility method to use the "properties" object to read file.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

