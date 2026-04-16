package com.mayankPaliwal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    // Read data.propertie file and gave who ever is asking for


    public static String readKey(String key){

        Properties p;
        String userDir = System.getProperty("user.dir");
        String file_path = userDir+"/src/main/resources/data.properties";
        try {
            FileInputStream file = new FileInputStream(file_path);
            p = new Properties();
            p.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return p.getProperty(key);
    }
}
