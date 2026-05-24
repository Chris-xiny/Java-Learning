package com.Chrisxin.b_ReflectionPractice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //1. 创建配置文件
        Properties properties = new Properties();
        //2. 读取并解析配置文件
        InputStream in = ReflectDemo.class.getClassLoader().getResourceAsStream("pro.properties");
        properties.load(in);
        System.out.println(properties);
        //3. 根据解析出来的className创建Class对象
        String className = properties.getProperty("className");
        Class<?> aClass = Class.forName(className);
        //4. 根据解析出来的methodName获取目标方法
        String methodName = properties.getProperty("methodName");
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        Method method = aClass.getMethod(methodName);
        /*
        5. 执行方法
            (此时想要执行Person的哪个方法，
                只需更改配置文件对应的methodName的值就行了，不需要动源码,这就是简单的小框架思想,
                    自动解析配置文件获取方法名调用方法)
        */
        method.invoke(o);
    }
}
