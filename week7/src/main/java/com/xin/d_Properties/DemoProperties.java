package com.xin.d_Properties;

import java.util.Properties;
import java.util.Set;

public class DemoProperties {
    public static void main(String[] args) {
        Properties pp=new Properties();
        //Object setProperty(String key,String value)     存键值对
        pp.setProperty("username", "root");
        pp.setProperty("password", "123456");
        //String getProperty(String key)                  根据key获取value
        System.out.println(pp.getProperty("password"));
        //Set<String> stringPropertyNames()               获取所有key，存到set集合中，类似于keySet方法
        Set<String> set=pp.stringPropertyNames();
        for (String key: set) {
            System.out.println(pp.getProperty(key));
        }
    }
}
