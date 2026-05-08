package com.xin.i_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Properties_01 {
    public static void main(String[] args) throws IOException {
        Properties pp=new Properties();
        FileInputStream fis=new FileInputStream("week8\\jdbc.properties");
        pp.load(fis);
        fis.close();
        Set<String> set=pp.stringPropertyNames();
        for (String key : set) {
            System.out.println(key+"..."+pp.getProperty(key));
        }
    }
}
